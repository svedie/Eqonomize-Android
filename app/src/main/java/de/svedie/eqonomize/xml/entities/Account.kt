package de.svedie.eqonomize.xml.entities

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml
import de.svedie.eqonomize.enums.AccountType
import de.svedie.eqonomize.xml.converter.AccountConverter
import de.svedie.eqonomize.xml.converter.FloatConverter
import java.util.*

/**
 * Data class representation of the accounts.
 *
 * @author svedie
 */
@Xml
data class Account(
  @Attribute
  var name: String,

  @Attribute
  var id: Int,

  @Attribute
  var revisions: String?,

  @Attribute
  var description: String?,

  @Attribute
  var currency: String = Currency.getInstance(Locale.getDefault()).currencyCode,

  @Attribute(converter = FloatConverter::class)
  var initialbalance: Float = 0.0f,

  @Attribute
  var budgetaccount: Int?,

  @Attribute(converter = AccountConverter::class)
  var type: AccountType = AccountType.OTHER,

  @Attribute
  var bank: String?,

  @Attribute
  var lender: String?,

  @Attribute
  var issuer: String?,

  @Attribute
  var closed: Boolean?
)