package de.svedie.eqonomize.database

import androidx.room.Database
import androidx.room.RoomDatabase
import de.svedie.eqonomize.database.dao.EqonomizeFileDao
import de.svedie.eqonomize.database.entities.EqonomizeFile

/**
 * Default database.
 *
 * @author svedie
 */
@Database(entities = [EqonomizeFile::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

  abstract fun filesDao(): EqonomizeFileDao
}