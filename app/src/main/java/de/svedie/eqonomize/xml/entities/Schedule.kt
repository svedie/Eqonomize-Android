package de.svedie.eqonomize.xml.entities

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml

/**
 * Data class representation of the schedule.
 *
 * @author svedie
 */
@Xml
data class Schedule(

  @Attribute
  var id: Int?,

  @Attribute
  var revisions: String?

// TODO to fix this you need to use a list, single element does not work
//    @Element
//    var transaction: Transaction?,
//
//    @Element
//    var recurrence: Recurrence?
)