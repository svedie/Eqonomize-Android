package de.svedie.eqonomize.enums

/**
 * Account type.
 *
 * @author svedie
 */
enum class AccountType(val type: String) {

  CURRENT("current"),
  SAVINGS("savings"),
  CREDIT_CARD("credit card"),
  LIABILITIES("liabilities"),
  SECURITIES("securities"),
  BALANCING("balancing"),
  CASH("cash"),
  OTHER("other");

  companion object {
    fun getEnumByType(value: String): AccountType {
      return values().first { accountType -> accountType.type == value }
    }
  }
}