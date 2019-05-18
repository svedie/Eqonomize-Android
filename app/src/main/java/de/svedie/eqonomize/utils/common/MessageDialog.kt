package de.svedie.eqonomize.utils.common

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import androidx.annotation.Nullable
import de.svedie.eqonomize.R

/**
 * Creates an alert dialog with the specified title and message.
 *
 * @author svedie
 */
class MessageDialog(private val context: Context) {

  /**
   * Shows error dialog with desired title and message.
   */
  fun showErrorDialog(
    title: Int,
    message: Int,
    @Nullable listener: DialogInterface.OnClickListener?
  ): AlertDialog {
    return createAlertDialog(title, message, R.drawable.alert_circle, listener)
  }


  /**
   * Shows alert dialog with desired title and message.
   */
  fun showAlertDialog(
    title: Int,
    message: Int,
    @Nullable listener: DialogInterface.OnClickListener?
  ): AlertDialog {
    return createAlertDialog(title, message, R.drawable.alert, listener)
  }

  /**
   * Shows info dialog with desired title and message.
   */
  fun showInfoDialog(
    title: Int,
    message: Int,
    @Nullable listener: DialogInterface.OnClickListener?
  ): AlertDialog {
    return createAlertDialog(title, message, R.drawable.information, listener)
  }

  /**
   * Constructs the alert dialog and shows it to the user.
   */
  private fun createAlertDialog(
    title: Int,
    message: Int,
    icon: Int,
    listener: DialogInterface.OnClickListener?
  ): AlertDialog {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)
    builder.setIcon(icon)
    builder.setTitle(title)
    builder.setMessage(message)
    builder.setPositiveButton(android.R.string.ok, listener)
    return builder.show()
  }
}