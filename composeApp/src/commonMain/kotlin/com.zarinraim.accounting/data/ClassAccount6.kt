package com.zarinraim.accounting.data

import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.model.SyntheticAccount
import com.zarinraim.accounting.model.SyntheticAccount.Feature

object ClassAccount6 {

    val groupAccount60 = GroupAccount(
        id = AccountId(code = "60", title = "Tržby za vlastní výkony a zboží"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "601", title = "Tržby za vlastní výrobky"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "602", title = "Tržby z prodeje služeb"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "604", title = "Tržby za zboží"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
        )
    )
    val groupAccount64 = GroupAccount(
        id = AccountId(code = "64", title = "Jiné provozní výnosy"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "641", title = "Tržby z prodeje dlouhodobého nehmotného a hmotného majetku"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "642", title = "Tržby z prodeje materiálu"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "643", title = "Přijaté dary (nepeněžní)"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "644", title = "Smluvní pokuty a úroky z prodlení"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "645", title = "Výnosy z postoupených pohledávek"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "646", title = "Výnosy z odepsaných pohledávek"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "647", title = "Mimořádné provozní výnosy"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "648", title = "Ostatní provozní výnosy"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(
                    code = "649",
                    title = "Odpis záporného goodwillu a zúčtování oprávky k oceň. rozdílu k nabytému majetku"
                ),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
        )
    )

    val groupAccount66 = GroupAccount(
        id = AccountId(code = "66", title = "Finanční výnosy"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "661", title = "Tržby z prodeje cenných papírů a podílů"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "662", title = "Úroky"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "663", title = "Kurzové zisky"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "664", title = "Výnosy z přecenění majetkových cenných papírů k obchodování"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "665", title = "Výnosy z dlouhodobého finančního majetku"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "666", title = "Výnosy z krátkodobého finančního majetku"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "667", title = "Výnosy z derivátových operací"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "668", title = "Ostatní finanční a mimořádné výnosy"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "669", title = "Přijaté dary (peněžní)"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
        )
    )

    val groupAccount69 = GroupAccount(
        id = AccountId(code = "69", title = "Převodové účty"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "697", title = "Převod provozních výnosů"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "698", title = "Převod finančních výnosů"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
        )
    )
}