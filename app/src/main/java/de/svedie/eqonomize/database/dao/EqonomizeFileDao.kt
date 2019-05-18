package de.svedie.eqonomize.database.dao

import androidx.room.*
import de.svedie.eqonomize.database.entities.EqonomizeFile

/**
 * DAO for the EqonomizeFile entity.
 *
 * @author svedie
 */
@Dao
interface EqonomizeFileDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(eqonomizeFile: EqonomizeFile)

  @Delete
  fun delete(eqonomizeFile: EqonomizeFile)

  @Query("SELECT * FROM eqonomizefile ORDER BY opendate DESC")
  fun getAll(): List<EqonomizeFile>

  @Query("SELECT * FROM eqonomizefile ORDER BY opendate DESC LIMIT 1")
  fun getLastOpenedFile(): EqonomizeFile
}