package de.svedie.eqonomize.xml.converter

import com.tickaroo.tikxml.TypeConverter
import de.svedie.eqonomize.enums.TransactionType

/**
 * Convertes the transactions from the XML file to the TransactionType enum.
 *
 * @author svedie
 */
class TransactionConverter : TypeConverter<TransactionType> {

  override fun write(value: TransactionType?): String {
    if (value != null) {
      return value.type
    }
    return ""
  }

  override fun read(value: String?): TransactionType {
    return TransactionType.getEnumByType(value!!)
  }
}