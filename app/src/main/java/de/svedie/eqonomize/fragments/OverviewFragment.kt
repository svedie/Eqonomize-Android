package de.svedie.eqonomize.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import de.svedie.eqonomize.R

/**
 * Overview fragment, which shows the user the basic information or provides functions to create an income or expense.
 *
 * @author svedie
 */
class OverviewFragment : Fragment() {

  private lateinit var mainView: View

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    setHasOptionsMenu(true)
    mainView = inflater.inflate(R.layout.overview_fragment, container, false)
    return mainView
  }

  override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
    inflater.inflate(R.menu.menu_fast_entry, menu)
    super.onCreateOptionsMenu(menu, inflater)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.menu_plus -> {
        return true
      }
      R.id.menu_minus -> {
        return true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }
}