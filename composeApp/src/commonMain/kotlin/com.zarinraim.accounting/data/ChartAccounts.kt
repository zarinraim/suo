package com.zarinraim.accounting.data

import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.ChartAccount
import com.zarinraim.accounting.model.ClassAccount

object ChartAccounts {

    private val classAccount0 = ClassAccount(
        id = AccountId(code = "0", title = "DLOUHODOBÝ MAJETEK"),
        groupAccounts = listOf(
            ClassAccount0.groupAccount01,
            ClassAccount0.groupAccount02,
            ClassAccount0.groupAccount03,
            ClassAccount0.groupAccount04,
            ClassAccount0.groupAccount05,
            ClassAccount0.groupAccount06,
            ClassAccount0.groupAccount07,
            ClassAccount0.groupAccount08,
            ClassAccount0.groupAccount09,
        )
    )

    private val classAccount1 = ClassAccount(
        id = AccountId(code = "1", title = "ZÁSOBY"),
        groupAccounts = listOf(
            ClassAccount1.groupAccount11,
            ClassAccount1.groupAccount12,
            ClassAccount1.groupAccount13,
            ClassAccount1.groupAccount15,
            ClassAccount1.groupAccount19,
        )
    )

    private val classAccount2 = ClassAccount(
        id = AccountId(code = "2", title = "KRÁTKODOBÝ FINANČNÍ MAJETEK A PENĚŽNÍ PROSTŘEDKY"),
        groupAccounts = listOf(
            ClassAccount2.groupAccount21,
            ClassAccount2.groupAccount22,
            ClassAccount2.groupAccount23,
            ClassAccount2.groupAccount24,
            ClassAccount2.groupAccount25,
            ClassAccount2.groupAccount26,
            ClassAccount2.groupAccount29,
        )
    )

    private val classAccount3 = ClassAccount(
        id = AccountId(code = "3", title = "ZÚČTOVACÍ VZTAHY"),
        groupAccounts = listOf(
            ClassAccount3.groupAccount31,
            ClassAccount3.groupAccount32,
            ClassAccount3.groupAccount33,
            ClassAccount3.groupAccount34,
            ClassAccount3.groupAccount35,
            ClassAccount3.groupAccount36,
            ClassAccount3.groupAccount37,
            ClassAccount3.groupAccount38,
            ClassAccount3.groupAccount39,
        )
    )

    private val classAccount4 = ClassAccount(
        id = AccountId(code = "4", title = "KAPITÁLOVÉ ÚČTY A DLOUHODOBÉ ZÁVAZKY"),
        groupAccounts = listOf(
            ClassAccount4.groupAccount41,
            ClassAccount4.groupAccount42,
            ClassAccount4.groupAccount43,
            ClassAccount4.groupAccount45,
            ClassAccount4.groupAccount46,
            ClassAccount4.groupAccount47,
            ClassAccount4.groupAccount48,
            ClassAccount4.groupAccount49,
        )
    )

    private val classAccount5 = ClassAccount(
        id = AccountId(code = "5", title = "NÁKLADY"),
        groupAccounts = listOf(
            ClassAccount5.groupAccount50,
            ClassAccount5.groupAccount51,
            ClassAccount5.groupAccount52,
            ClassAccount5.groupAccount53,
            ClassAccount5.groupAccount54,
            ClassAccount5.groupAccount55,
            ClassAccount5.groupAccount56,
            ClassAccount5.groupAccount57,
            ClassAccount5.groupAccount58,
            ClassAccount5.groupAccount59,
        )
    )

    private val classAccount6 = ClassAccount(
        id = AccountId(code = "6", title = "VÝNOSY"),
        groupAccounts = listOf(
            ClassAccount6.groupAccount60,
            ClassAccount6.groupAccount64,
            ClassAccount6.groupAccount66,
            ClassAccount6.groupAccount69,
        )
    )

    private val classAccount7 = ClassAccount(
        id = AccountId(code = "7", title = "ZÁVĚRKOVÉ A PODROZVAHOVÉ ÚČTY"),
        groupAccounts = listOf(
            ClassAccount7.groupAccount70,
            ClassAccount7.groupAccount71,
            ClassAccount7.groupAccount79,
        )
    )

    val data = ChartAccount(
        classAccounts = listOf(
            classAccount0,
            classAccount1,
            classAccount2,
            classAccount3,
            classAccount4,
            classAccount5,
            classAccount6,
            classAccount7,
        )
    )
}