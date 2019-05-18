package de.svedie.eqonomize.xml.entities

import de.svedie.eqonomize.enums.AccountType
import de.svedie.eqonomize.enums.CategoryType
import de.svedie.eqonomize.utils.common.AppConstants
import org.junit.Before
import org.junit.Test

/**
 * Test class for EqonomizeDoc.
 *
 * @author Sven Diesendorf - svedie
 * @since 25.12.2018
 */
class EqonomizeDocTest {

  private val account1 = Account(
    "test", 1, "1", "description", "EUR", 0.0f,
    0, AccountType.CASH, "bank", "lender", "issuer"
  )

  private val account2 = Account(
    "test", 1, "1", "description", "EUR", 0.0f,
    0, AccountType.CREDIT_CARD, "bank", "lender", "issuer"
  )

  private val category1 = Category(
    CategoryType.EXPENSES, CategoryType.INCOMES.type, 1,
    "1", "description", null, null, mutableListOf()
  )

  private val category2 = Category(
    CategoryType.INCOMES, CategoryType.INCOMES.type, 1,
    "1", "description", null, null, mutableListOf()
  )

  private val eqonomizeDoc = EqonomizeDoc()

  @Before
  fun init() {
    eqonomizeDoc.accounts = mutableListOf(account1, account2)
//    eqonomizeDoc.categories = mutableListOf(category1, category2)
  }

  @Test
  fun testDefaultAccountFile() {
    val eqoDoc = EqonomizeDoc()
    assert(eqoDoc.version == AppConstants.EQONOMIZE_DOC_VERSION)
    assert(eqoDoc.revision == AppConstants.EQONOMIZE_DOC_REVISION)
    assert(eqoDoc.lastId == AppConstants.EQONOMIZE_DOC_LAST_ID)
    assert(eqoDoc.firstDayOfMonth == AppConstants.EQONOMIZE_DOC_FIRST_DAY_OF_MONTH)
    assert(eqoDoc.firstMonthOfYear == AppConstants.EQONOMIZE_DOC_FIRST_MONTH_OF_YEAR)
  }

  @Test
  fun getAccountsByType() {
    assert(eqonomizeDoc.getAccountsByType().size == 2)
    assert(eqonomizeDoc.getAccountsByType(AccountType.CREDIT_CARD).size == 1)
  }

  @Test
  fun getCategoriesByType() {
//    assert(eqonomizeDoc.getCategoriesByType().size == 2)
//    assert(eqonomizeDoc.getCategoriesByType(CategoryType.INCOMES).size == 1)
  }
}