package de.svedie.eqonomize.xml.entities

import com.tickaroo.tikxml.annotation.*
import de.svedie.eqonomize.enums.AccountType
import de.svedie.eqonomize.enums.CategoryType
import de.svedie.eqonomize.utils.common.AppConstants
import java.util.*

/**
 * Data class representation of the EqonomizeDoc.
 *
 * @author svedie
 */
@Xml(name = "EqonomizeDoc")
data class EqonomizeDoc(
  @Attribute
  var version: String = AppConstants.EQONOMIZE_DOC_VERSION,

  @Attribute
  var revision: String = AppConstants.EQONOMIZE_DOC_REVISION,

  @Attribute
  var lastid: Int = AppConstants.EQONOMIZE_DOC_LAST_ID,

  @Path("budget_period")
  @PropertyElement(name = "first_day_of_month")
  var firstDayOfMonth: Int = AppConstants.EQONOMIZE_DOC_FIRST_DAY_OF_MONTH,

  @Path("budget_period")
  @PropertyElement(name = "first_month_of_year")
  var firstMonthOfYear: Int = AppConstants.EQONOMIZE_DOC_FIRST_MONTH_OF_YEAR,

  @Path("currency")
  @Attribute(name = "code")
  var currency: String = Currency.getInstance(Locale.getDefault()).currencyCode,

// TODO to fix this you need to use a list, single element does not work
//  @Element
//  var synchronization: Synchronization?,

  @Element
  var accounts: MutableList<Account> = mutableListOf(),

  @Element
  var categories: MutableList<Category> = mutableListOf()

// TODO to fix this you need to use a list, single element does not work
//  @Element
//  var schedules: MutableList<Schedule> = mutableListOf()

//    @Element
//    var transactions: MutableList<Transaction> = mutableListOf()

//    @Element
//    var securities: MutableList<Security> = mutableListOf()
) {

  fun getNextId(): Int {
    return lastid++
  }

  fun getAccountsByType(vararg accountType: AccountType): List<Account> {
    return accounts.filter { account -> accountType.all { it == account.type } }
  }

  fun getCategoriesByType(vararg categoryType: CategoryType): List<Category> {
    return categories.filter { category -> categoryType.all { it == category.type } }
  }

//  fun getSchedulesByTransactionType(vararg transactionType: TransactionType): List<Schedule> {
//    return schedules.filter { schedule -> transactionType.all { it == schedule.transaction?.type } }
//  }
}