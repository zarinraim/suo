package com.zarinraim.accounting.data

import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.Feature
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.model.SyntheticAccount

object ClassAccount7 {

    val groupAccount70 = GroupAccount(
        id = AccountId(code = "70", title = "Účty rozvažné"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "701", title = "Počáteční účet rozvažný"),
                features = listOf(Feature.Financial)
            ),
            SyntheticAccount(
                id = AccountId(code = "702", title = "Konečný účet rozvažný"),
                features = listOf(Feature.Financial)
            ),
        )
    )
    val groupAccount71 = GroupAccount(
        id = AccountId(code = "71", title = "Účet zisků a ztrát"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "710", title = "Účet zisků a ztrát"),
                features = listOf(Feature.Financial)
            ),
        )
    )
    val groupAccount79 = GroupAccount(
        id = AccountId(code = "79", title = "Podrozvahové účty"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "799", title = "Evidenční účet"),
                features = listOf(Feature.OffBalance, Feature.Liability)
            ),
        )
    )
}