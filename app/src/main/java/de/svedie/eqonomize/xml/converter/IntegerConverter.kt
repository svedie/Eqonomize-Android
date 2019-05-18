package de.svedie.eqonomize.xml.converter

import com.tickaroo.tikxml.TypeConverter

/**
 * Converts an integer from and to an string.
 *
 * @author svedie
 */
class IntegerConverter : TypeConverter<Int> {
  override fun write(value: Int?): String {
    return value.toString()
  }

  override fun read(value: String?): Int {
    return value?.toInt()!!
  }
}