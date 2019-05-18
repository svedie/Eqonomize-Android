package de.svedie.eqonomize.xml.entities

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml
import de.svedie.eqonomize.enums.TransactionType
import de.svedie.eqonomize.xml.converter.TransactionConverter

/**
 * Data class representation of the transaction.
 *
 * @author svedie
 */
@Xml
data class Transaction(

  @Attribute(converter = TransactionConverter::class)
  var type: TransactionType?
)