package de.svedie.eqonomize.enums

/**
 * Transaction type.
 *
 * @author svedie
 */
enum class TransactionType(val type: String) {

  EXPENSE("expense"),
  INCOME("income"),
  DIVIDEND("dividend"),
  BALANCING("balancing"),
  TRANSFER("transfer"),
  SECURITY_BUY("security_buy"),
  SECURITY_SELL("security_sell");

  companion object {
    fun getEnumByType(value: String): TransactionType {
      return TransactionType.values().first { transactionType -> transactionType.type == value }
    }
  }
}