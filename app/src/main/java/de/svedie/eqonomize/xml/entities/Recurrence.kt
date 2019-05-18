package de.svedie.eqonomize.xml.entities

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Path
import com.tickaroo.tikxml.annotation.Xml
import de.svedie.eqonomize.enums.RecurrenceType
import de.svedie.eqonomize.enums.WeekendHandlingType
import de.svedie.eqonomize.xml.converter.IntegerConverter
import de.svedie.eqonomize.xml.converter.RecurrenceConverter
import de.svedie.eqonomize.xml.converter.WeekendHandlingConverter

/**
 * Data class representation of the recurrencies.
 *
 * @author svedie
 */
@Xml
data class Recurrence(

  @Attribute(converter = RecurrenceConverter::class)
  var type: RecurrenceType?,

  @Attribute
  var startdate: String?,

  @Attribute
  var enddate: String?,

  @Attribute(converter = IntegerConverter::class)
  var frequency: Int?,

  @Attribute
  var day: String?,

  @Attribute
  var week: String?,

  @Attribute
  var month: String?,

  @Attribute
  var dayofweek: String?,

  @Attribute
  var dayofmonth: String?,

  @Attribute
  var dayofyear: String?,

  @Attribute
  var days: String?,

  @Attribute(converter = WeekendHandlingConverter::class)
  var weekendhandling: WeekendHandlingType?,

  @Path("exception")
  @Attribute(name = "date")
  var exceptiondate: String?
)