package de.svedie.eqonomize.activities

import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import de.svedie.eqonomize.R
import de.svedie.eqonomize.database.service.EqonomizeFileService
import de.svedie.eqonomize.fragments.EqonomizeFileFragment
import de.svedie.eqonomize.fragments.OverviewFragment
import de.svedie.eqonomize.utils.common.PermissionUtils
import de.svedie.eqonomize.xml.service.FileService
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.android.synthetic.main.main_app_bar.*

/**
 * Main Activity of the app.
 *
 * @author svedie
 */
class MainAppActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activity)
    setSupportActionBar(toolbar)
    PermissionUtils().requestPermissions(this)

    val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, 0, 0)
    drawer_layout.addDrawerListener(toggle)
    toggle.syncState()
    nav_view.setNavigationItemSelectedListener(this)

    if (supportFragmentManager.fragments.isEmpty()) {
      initOverviewFragment()
    }
  }

  /**
   * Initializes the default Overview fragment.
   */
  private fun initOverviewFragment() {
    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()

    val fragment = OverviewFragment()
    fragmentTransaction.replace(R.id.main_content_fragment_content, fragment)
    fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commit()

    val eqonomizeFileService = EqonomizeFileService(this)
    val lastOpenedFile = eqonomizeFileService.getLastOpenedFile()
    if (lastOpenedFile != null) {
      val uri = Uri.parse(lastOpenedFile.path)
      val file = FileService(uri).readFile()
      println(file.toString())
    }
  }

  override fun onBackPressed() {
    if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
      drawer_layout.closeDrawer(GravityCompat.START)
    } else {
      super.onBackPressed()
    }
  }

  override fun onNavigationItemSelected(item: MenuItem): Boolean {

    val fragmentManager = supportFragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()

    when (item.itemId) {
      R.id.nav_management_overview -> {
        val fragment = OverviewFragment()
        fragmentTransaction.replace(R.id.main_content_fragment_content, fragment)
      }

      R.id.nav_settings_openfile -> {
        val fragment = EqonomizeFileFragment()
        fragmentTransaction.replace(R.id.main_content_fragment_content, fragment)
      }
//      R.id.nav_help_about -> {
//
//      }
//      R.id.nav_help_help -> {
//
//      }
//      R.id.nav_help_bug -> {
//
//      }
    }

    fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commit()
    drawer_layout.closeDrawer(GravityCompat.START)
    return true
  }
}
