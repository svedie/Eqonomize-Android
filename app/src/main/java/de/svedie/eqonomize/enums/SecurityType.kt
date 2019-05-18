package de.svedie.eqonomize.enums

/**
 * @author svedie
 */
enum class SecurityType(val type: String) {

  BOND("bond"),
  MUTUAL_FUND("mutual fund"),
  STOCK("stock"),
  OTHER("other");

  companion object {
    fun getEnumByType(value: String): SecurityType {
      return SecurityType.values().first { securityType -> securityType.type == value }
    }
  }
}