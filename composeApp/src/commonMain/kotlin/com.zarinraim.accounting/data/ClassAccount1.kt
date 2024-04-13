package com.zarinraim.accounting.data

import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.Feature
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.model.SyntheticAccount

object ClassAccount1 {

    val groupAccount11 = GroupAccount(
        id = AccountId(code = "11", title = "Materiál"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "111", title = "Pořízení materiálu"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "112", title = "Materiál na skladě"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "119", title = "Materiál na cestě"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount12 = GroupAccount(
        id = AccountId(code = "12", title = "Zásoby vlastní činnosti"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "121", title = "Nedokončená výroba"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "122", title = "Polotovary vlastní výroby"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "123", title = "Výrobky"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "124", title = "Mladá a ostatní zvířata a jejich skupiny"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount13 = GroupAccount(
        id = AccountId(code = "13", title = "Zboží"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "131", title = "Pořízení zboží"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "132", title = "Zboží na skladě a v prodejnách"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "139", title = "Zboží na cestě"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount15 = GroupAccount(
        id = AccountId(code = "15", title = "Poskytnuté zálohy na zásoby"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "151", title = "Poskytnuté zálohy na materiál"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "152", title = "Poskytnuté zálohy na mladá zvířata"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "153", title = "Poskytnuté zálohy na zboží"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount19 = GroupAccount(
        id = AccountId(code = "19", title = "Opravné položky k zásobám"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "191", title = "Opravná položka k materiálu"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "192", title = "Opravná položka k nedokončené výrobě"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "193", title = "Opravná položka k polotovarům vlastní výroby"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "194", title = "Opravná položka k výrobkům"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "195", title = "Opravná položka k mladým zvířatům"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "196", title = "Opravná položka ke zboží"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "197", title = "Opravná položka k zálohám na materiál"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "198", title = "Opravná položka k zálohám na zboží"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "199", title = "Opravná položka k zálohám na mladá zvířata"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )
}