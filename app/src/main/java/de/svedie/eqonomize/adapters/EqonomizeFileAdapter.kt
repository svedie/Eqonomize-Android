package de.svedie.eqonomize.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.svedie.eqonomize.R
import de.svedie.eqonomize.database.entities.EqonomizeFile

/**
 * Creates the Eqonomize File list.
 *
 * @author svedie
 */
class EqonomizeFileAdapter(private val context: Context, private val files: List<EqonomizeFile>) :
  BaseAdapter() {

  override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
    val inflater: LayoutInflater =
      context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val view = inflater.inflate(R.layout.eqonomizefile_fragment_list_item, parent, false)
    val name = view.findViewById<TextView>(R.id.file_list_item_tv_file_name)
    val path = view.findViewById<TextView>(R.id.file_list_item_tv_file_path)
    name.text = files[position].name
    path.text = files[position].path

    return view
  }

  override fun getItem(position: Int): Any {
    return files[position]
  }

  override fun getItemId(position: Int): Long {
    return position.toLong()
  }

  override fun getCount(): Int {
    return files.size
  }
}