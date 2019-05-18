package de.svedie.eqonomize.xml.converter

import com.tickaroo.tikxml.TypeConverter
import de.svedie.eqonomize.enums.CategoryType

/**
 * Convertes the categories from the XML file to the CategoryType enum.
 *
 * @author svedie
 */
class CategoryConverter : TypeConverter<CategoryType> {

  override fun write(value: CategoryType?): String {
    if (value != null) {
      return value.type
    }
    return ""
  }

  override fun read(value: String?): CategoryType {
    return CategoryType.getEnumByType(value!!)
  }
}