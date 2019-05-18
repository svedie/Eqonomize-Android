package de.svedie.eqonomize.xml.entities

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

/**
 * Data class representation of the synchronisation.
 *
 * @author svedie
 */
@Xml
data class Synchronization(
  @Attribute
  var type: String?,

  @Attribute
  var autosync: Int?,

  @Attribute
  var revision: String?,

  @PropertyElement
  var url: String?,

  @PropertyElement
  var download: String?,

  @PropertyElement
  var upload: String?
)