package de.svedie.eqonomize.enums

/**
 * @author svedie
 */
enum class WeekendHandlingType(val type: String) {

  WEEKEND_HANDLING_NONE("0"),
  WEEKEND_HANDLING_BEFORE("1"),
  WEEKEND_HANDLING_AFTER("2"),
  WEEKEND_HANDLING_NEAREST("3");

  companion object {
    fun getEnumByType(value: String): WeekendHandlingType {
      return WeekendHandlingType.values().first { weekendType -> weekendType.type == value }
    }
  }
}