package de.svedie.eqonomize.xml.entities

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Path
import com.tickaroo.tikxml.annotation.Xml
import de.svedie.eqonomize.enums.CategoryType
import de.svedie.eqonomize.xml.converter.CategoryConverter
import de.svedie.eqonomize.xml.converter.FloatConverter

/**
 * Data class representation of the categories.
 *
 * @author svedie
 */
@Xml
data class Category(

  @Attribute(converter = CategoryConverter::class)
  var type: CategoryType?,

  @Attribute
  var name: String?,

  @Attribute
  var id: Int?,

  @Attribute
  var revisions: String?,

  @Attribute
  var description: String?,

  @Path("budget")
  @Attribute(name = "value", converter = FloatConverter::class)
  var budgetvalue: Float?,

  @Path("budget")
  @Attribute(name = "date")
  var budgetdate: String?,

  @Element
  var category: MutableList<Category>? = mutableListOf()
)