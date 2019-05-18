package de.svedie.eqonomize.fragments

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.provider.OpenableColumns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.svedie.eqonomize.R
import de.svedie.eqonomize.adapters.EqonomizeFileAdapter
import de.svedie.eqonomize.database.entities.EqonomizeFile
import de.svedie.eqonomize.database.service.EqonomizeFileService
import de.svedie.eqonomize.utils.common.AppConstants
import de.svedie.eqonomize.utils.common.MessageDialog
import kotlinx.android.synthetic.main.eqonomizefile_fragment.view.*

/**
 * EqonomizeFile fragment, where the user opens, creates or selects files.
 *
 * @author svedie
 */
class EqonomizeFileFragment : Fragment() {

  private lateinit var mainView: View

  companion object {
    const val READ_FILE_RESULT_CODE = 1
    const val CREATE_FILE_RESULT_CODE = 2
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    mainView = inflater.inflate(R.layout.eqonomizefile_fragment, container, false)

    mainView.file_activity_b_select_file?.setOnClickListener { selectFileIntent() }
    mainView.file_activity_b_create_file?.setOnClickListener { createFile(mainView.context) }

    setAdapter(mainView)
    return mainView
  }

  override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    if ((requestCode == READ_FILE_RESULT_CODE || requestCode == CREATE_FILE_RESULT_CODE)
      && resultCode == Activity.RESULT_OK
    ) {
      var name = ""
      var path = ""

      data?.data?.let { uri ->
        path = uri.path
        this.context!!.contentResolver.query(uri, null, null, null, null)
      }?.use { cursor ->
        val nameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
        cursor.moveToFirst()
        name = cursor.getString(nameIndex)
        cursor.close()
      }

      if (name.endsWith(AppConstants.EXTENSION)) {
        EqonomizeFileService(this.context!!).insertFile(EqonomizeFile(path, name))
        setAdapter(mainView)
      } else {
        MessageDialog(this.context!!).showErrorDialog(
          R.string.eqonomizefile_activity_dialog_error,
          R.string.eqonomizefile_activity_dialog_error_file,
          null
        )
      }
    }
  }

  /**
   * Shows an alert dialog to user and calls createFileIntent method.
   */
  private fun createFile(viewContext: Context) {
    val dialog = MessageDialog(viewContext)
    dialog.showAlertDialog(R.string.eqonomizefile_activity_dialog_alert,
      R.string.eqonomizefile_activity_dialog_alert_file,
      DialogInterface.OnClickListener { _: DialogInterface, _: Int ->
        createFileIntent()
      }
    )
  }

  /**
   * Open a file using Android Storage Framework.
   */
  private fun selectFileIntent() {
    val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
      type = "*/*"
    }
    startActivityForResult(intent, READ_FILE_RESULT_CODE)
  }

  /**
   * Create a file using Android Storage Framework.
   */
  private fun createFileIntent() {
    val intent = Intent(Intent.ACTION_CREATE_DOCUMENT)
    intent.addCategory(Intent.CATEGORY_OPENABLE)
    intent.type = "*/*"
    intent.putExtra(Intent.EXTRA_TITLE, AppConstants.FILE_NAME)
    startActivityForResult(intent, CREATE_FILE_RESULT_CODE)
  }

  /**
   * Sets an adapter to the list.
   */
  private fun setAdapter(mainView: View) {
    val fileAdapter =
      EqonomizeFileAdapter(mainView.context, EqonomizeFileService(mainView.context).getAll())
    mainView.file_activity_lv_files.adapter = fileAdapter
    mainView.file_activity_lv_files.setOnItemClickListener { _, _, _, _ -> println("onClickListener") }
    mainView.file_activity_lv_files.setOnItemLongClickListener { _, _, _, _ ->
      println("onLongClickListener")
      true
    }
  }
}
