package de.svedie.eqonomize.database.service

import android.content.Context
import de.svedie.eqonomize.database.entities.EqonomizeFile

/**
 * EqonomizeFile service to interoperate with the DAO.
 *
 * @author svedie
 */
class EqonomizeFileService(context: Context) : Service() {

  private val instance = getDatabaseInstance(context)

  fun insertFile(eqonomizeFile: EqonomizeFile) {
    instance.filesDao().insert(eqonomizeFile)
  }

  fun deleteFile(eqonomizeFile: EqonomizeFile) {
    instance.filesDao().delete(eqonomizeFile)
  }

  fun getLastOpenedFile(): EqonomizeFile? {
    return instance.filesDao().getLastOpenedFile()
  }

  fun getAll(): List<EqonomizeFile> {
    return instance.filesDao().getAll()
  }
}