package de.svedie.eqonomize.xml.converter

import com.tickaroo.tikxml.TypeConverter
import de.svedie.eqonomize.enums.SecurityType

/**
 * Converts the securities from the XML file to the SecurityType enum.
 *
 * @author svedie
 */
class SecurityConverter : TypeConverter<SecurityType> {

  override fun write(value: SecurityType?): String {
    if (value != null) {
      return value.type
    }
    return ""
  }

  override fun read(value: String?): SecurityType {
    return SecurityType.getEnumByType(value!!)
  }
}