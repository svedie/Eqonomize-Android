package de.svedie.eqonomize.xml.converter

import com.tickaroo.tikxml.TypeConverter
import de.svedie.eqonomize.enums.WeekendHandlingType

/**
 * Convertes the weekend handlings from the XML file to the WeekendHandlingType enum.
 *
 * @author svedie
 */
class WeekendHandlingConverter : TypeConverter<WeekendHandlingType> {

  override fun write(value: WeekendHandlingType?): String {
    if (value != null) {
      return value.type
    }
    return ""
  }

  override fun read(value: String?): WeekendHandlingType {
    return WeekendHandlingType.getEnumByType(value!!)
  }
}