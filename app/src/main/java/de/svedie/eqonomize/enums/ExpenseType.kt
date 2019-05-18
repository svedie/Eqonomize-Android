package de.svedie.eqonomize.enums

/**
 * @author svedie
 */
enum class ExpenseType(val type: String) {

  EXPENSE("expense"),
  REFUND("refund"),
  INCOME("income"),
  REPAYMENT("repayment"),
  DIVIDEND("dividend"),
  TRANSFER("transfer"),
  BALANCING("balancing"),
  REINVESTED_DIVIDENT("reinvested_divident"),
  SECURITY_BUY("security_buy"),
  SECURITY_SELL("security_sell"),
  SECURITY_TRADE("security_trade"),
  MULTIITEM("multiitem"),
  SPLIT("split"),
  MULTIACCOUNT("multiaccount"),
  DEBTPAYMENT("debtpayment");

  companion object {
    fun getEnumByType(value: String): ExpenseType {
      return values().first { expenseType -> expenseType.type == value }
    }
  }
}