package de.svedie.eqonomize.xml.entities

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Path
import de.svedie.eqonomize.xml.converter.FloatConverter
import de.svedie.eqonomize.xml.converter.IntegerConverter

/**
 * Data class representation of the security.
 *
 * @author svedie
 */
data class Security(

  @Attribute(converter = IntegerConverter::class)
  var id: Int?,

  @Attribute
  var revisions: String?,

  @Attribute
  var name: String,

  @Attribute
  var type: String?,

  @Attribute(converter = IntegerConverter::class)
  var decimals: Int,

  @Attribute(converter = IntegerConverter::class)
  var quotationdecimals: Int,

  @Attribute(converter = FloatConverter::class)
  var initialshares: Float?,

  @Attribute
  var description: String?,

  @Attribute
  var account: String?,

  @Path("quotation")
  @Attribute(converter = FloatConverter::class)
  var value: Float,

  @Path("quotation")
  @Attribute
  var date: String?
)