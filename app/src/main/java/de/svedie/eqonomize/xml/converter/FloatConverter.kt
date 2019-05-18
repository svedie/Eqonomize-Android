package de.svedie.eqonomize.xml.converter

import com.tickaroo.tikxml.TypeConverter

/**
 * Converts an float value from and to an string.
 *
 * @author svedie
 */
class FloatConverter : TypeConverter<Float> {
  override fun write(value: Float?): String {
    return value.toString()
  }

  override fun read(value: String?): Float {
    return value?.toFloat()!!
  }
}