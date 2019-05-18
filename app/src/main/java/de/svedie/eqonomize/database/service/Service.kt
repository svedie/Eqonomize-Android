package de.svedie.eqonomize.database.service

import android.content.Context
import androidx.room.Room
import de.svedie.eqonomize.database.AppDatabase
import de.svedie.eqonomize.utils.common.AppConstants

/**
 * Abstract service class with the default database.
 *
 * @author svedie
 */
open class Service {
  fun getDatabaseInstance(context: Context): AppDatabase {
    return Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.DATABASE_NAME)
      .allowMainThreadQueries().build()
  }
}