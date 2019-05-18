package de.svedie.eqonomize.utils.common

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import de.svedie.eqonomize.R

/**
 * Permission utils to request needed rights.
 *
 * @author svedie
 */
class PermissionUtils {

  /**
   * Requests permission to write to external storage.
   */
  fun requestPermissions(activity: Activity) {
    if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
      != PackageManager.PERMISSION_GRANTED
    ) {
      if (ActivityCompat
          .shouldShowRequestPermissionRationale(
            activity,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
          )
      ) {
        val alertBuilder = AlertDialog.Builder(activity)
        alertBuilder.setCancelable(true)
        alertBuilder.setTitle(activity.getString(R.string.permission_title))
        alertBuilder.setMessage(activity.getString(R.string.permission_message))
        alertBuilder.setPositiveButton(android.R.string.yes) { _, _ ->
          ActivityCompat.requestPermissions(
            activity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 0
          )
        }

        alertBuilder.create().show()
      } else {
        ActivityCompat.requestPermissions(
          activity,
          arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 0
        )
      }
    }
  }
}