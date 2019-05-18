package de.svedie.eqonomize.xml.converter

import com.tickaroo.tikxml.TypeConverter
import de.svedie.eqonomize.enums.AccountType

/**
 * Convertes the accounts from the XML file to the AccountType enum.
 *
 * @author svedie
 */
class AccountConverter : TypeConverter<AccountType> {

  override fun write(value: AccountType?): String {
    if (value != null) {
      return value.type
    }
    return ""
  }

  override fun read(value: String?): AccountType {
    return AccountType.getEnumByType(value!!)
  }
}