package com.zarinraim.accounting.data

import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.model.SyntheticAccount
import com.zarinraim.accounting.model.SyntheticAccount.Feature

object ClassAccount2 {

    val groupAccount21 = GroupAccount(
        id = AccountId(code = "21", title = "Peněžní prostředky v pokladně"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "211", title = "Peněžní prostředky v pokladně"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "213", title = "Ceniny"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount22 = GroupAccount(
        id = AccountId(code = "22", title = "Peněžní prostředky na účtech"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "221", title = "Peněžní prostředky na účtech"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount23 = GroupAccount(
        id = AccountId(code = "23", title = "Krátkodobé úvěry"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "231", title = "Krátkodobé úvěry"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "232", title = "Eskontní úvěry"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )

    val groupAccount24 = GroupAccount(
        id = AccountId(code = "24", title = "Krátkodobé finanční výpomoci"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "241", title = "Vydané krátkodobé dluhopisy"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "249", title = "Ostatní krátkodobé finanční výpomoci"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )

    val groupAccount25 = GroupAccount(
        id = AccountId(code = "25", title = "Krátkodobý finanční majetek"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "251", title = "Registrované majetkové cenné papíry k obchodování"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "252", title = "Vlastní podíly"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "253", title = "Registrované dluhové cenné papíry k obchodování"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "254", title = "Směnky k inkasu"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "255", title = "Vlastní dluhopisy"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "256", title = "Dluhové cenné papíry se splat. do 1 roku držené do splatnosti"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "257", title = "Ostatní cenné papíry k obchodování"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "258", title = "Podíly – ovládaná nebo ovládající osoba"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount26 = GroupAccount(
        id = AccountId(code = "26", title = "Převody mezi finančními účty"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "261", title = "Peníze na cestě"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount29 = GroupAccount(
        id = AccountId(
            code = "29",
            title = "Opravné položky ke krátkodobému finančnímu majetku"
        ),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "291", title = "Opravná položka ke krátkodobému finančnímu majetku"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )
}