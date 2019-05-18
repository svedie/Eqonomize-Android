package de.svedie.eqonomize.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

/**
 * EqonomizeFile entity to save the opened files in a database.
 *
 * @author svedie
 */
@Entity(tableName = "eqonomizefile")
data class EqonomizeFile(
  @PrimaryKey
  @ColumnInfo() var path: String,
  @ColumnInfo() var name: String
) {

  @ColumnInfo(name = "opendate")
  var openDate: Long = Calendar.getInstance().timeInMillis
}
