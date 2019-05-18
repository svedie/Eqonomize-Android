package de.svedie.eqonomize.enums

/**
 * Category type.
 *
 * @author svedie
 */
enum class CategoryType(val type: String) {

  INCOMES("incomes"),
  EXPENSES("expenses");

  companion object {
    fun getEnumByType(value: String): CategoryType {
      return CategoryType.values().first { categoryType -> categoryType.type == value }
    }
  }
}