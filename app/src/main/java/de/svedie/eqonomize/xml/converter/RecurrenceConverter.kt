package de.svedie.eqonomize.xml.converter

import com.tickaroo.tikxml.TypeConverter
import de.svedie.eqonomize.enums.RecurrenceType

/**
 * Convertes the recurrencies from the XML file to the RecurrencyType enum.
 *
 * @author svedie
 */
class RecurrenceConverter : TypeConverter<RecurrenceType> {

  override fun write(value: RecurrenceType?): String {
    if (value != null) {
      return value.type
    }
    return ""
  }

  override fun read(value: String?): RecurrenceType {
    return RecurrenceType.getEnumByType(value!!)
  }
}