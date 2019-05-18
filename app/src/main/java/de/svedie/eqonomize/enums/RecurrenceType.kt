package de.svedie.eqonomize.enums

/**
 * Recurrence type.
 *
 * @author svedie
 */
enum class RecurrenceType(val type: String) {

  DAILY("daily"),
  WEEKLY("weekly"),
  MONTHLY("monthly"),
  YEARLY("yearly");

  companion object {
    fun getEnumByType(value: String): RecurrenceType {
      return RecurrenceType.values().first { recurrenceType -> recurrenceType.type == value }
    }
  }
}