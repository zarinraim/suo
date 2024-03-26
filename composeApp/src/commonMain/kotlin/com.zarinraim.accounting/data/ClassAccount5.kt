package com.zarinraim.accounting.data

import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.model.SyntheticAccount
import com.zarinraim.accounting.model.SyntheticAccount.Feature

object ClassAccount5 {

    val groupAccount50 = GroupAccount(
        id = AccountId(code = "50", title = "Spotřebované nákupy"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "501", title = "Spotřeba materiálu"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "502", title = "Spotřeba energie"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "503", title = "Spotřeba ostatních neskladovatelných dodávek"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "504", title = "Prodané zboží"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
        )
    )

    val groupAccount51 = GroupAccount(
        id = AccountId(code = "51", title = "Služby"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "511", title = "Opravy a udržování"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "512", title = "Cestovné"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "513", title = "Náklady na reprezentaci"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "518", title = "Ostatní služby"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
        )
    )

    val groupAccount52 = GroupAccount(
        id = AccountId(code = "52", title = "Osobní náklady"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "521", title = "Mzdové náklady"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "522", title = "Příjmy společníků obchodní korporace ze závislé činnosti"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "523", title = "Odměny členům orgánů obchodních korporací"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "524", title = "Zákonné sociální a zdravotní pojištění"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "525", title = "Ostatní sociální a zdravotní pojištění"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "526", title = "Sociální náklady individuálního podnikatele"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "527", title = "Zákonné sociální náklady"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "528", title = "Ostatní sociální náklady"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
        )
    )

    val groupAccount53 = GroupAccount(
        id = AccountId(code = "53", title = "Daně a poplatky"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "531", title = "Daň silniční"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "532", title = "Daň z nemovitých věcí"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "538", title = "Ostatní daně a poplatky"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
        )
    )

    val groupAccount54 = GroupAccount(
        id = AccountId(code = "54", title = "Jiné provozní náklady"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "541", title = "Zůstatková cena prodaného dlouhodobého nehmotného a hmotného majetku"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "542", title = "Prodaný materiál"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "543", title = "Poskytnuté dary"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "544", title = "Smluvní pokuty a úroky z prodlení"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "545", title = "Ostatní pokuty a penále"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "546", title = "Odpis pohledávky"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "547", title = "Mimořádné provozní náklady"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "548", title = "Ostatní provozní náklady"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "549", title = "Manka a škody"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
        )
    )

    val groupAccount55 = GroupAccount(
        id = AccountId(
            code = "55",
            title = "Odpisy, rezervy, komplexní náklady příštích období a opravné položky v provozní oblasti"
        ),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "551", title = "Odpisy dlouhodobého nehmotného a hmotného majetku"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "552", title = "Tvorba a zúčtování rezerv podle zvláštních právních předpisů"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "554", title = "Tvorba a zúčtování ostatních rezerv"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "555", title = "Tvorba a zúčtování komplexních nákladů příštích období"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "557", title = "Zúčtování oprávky k oceňovacímu rozdílu k nabytému majetku"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "558", title = "Tvorba a zúčtování zákonných opravných položek"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "559", title = "Tvorba a zúčtování opravných položek"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
        )
    )

    val groupAccount56 = GroupAccount(
        id = AccountId(code = "56", title = "Finanční náklady"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "561", title = "Prodané cenné papíry a podíly"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "562", title = "Úroky"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "563", title = "Kurzové ztráty"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "564", title = "Náklady z přecenění majetkových cenných papírů k obchodování"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "565", title = "Poskytnuté dary (peněžní)"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "566", title = "Náklady z finančního majetku"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "567", title = "Náklady z derivátových operací"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "568", title = "Ostatní a mimořádné finanční náklady"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "569", title = "Manka a škody na finančním majetku"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
        )
    )

    val groupAccount57 = GroupAccount(
        id = AccountId(
            code = "57",
            title = "Rezervy a opravné položky ve finanční oblasti"
        ),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "574", title = "Tvorba a zúčtování finančních rezerv"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "579", title = "Tvorba a zúčtování opravných položek ve finanční činnosti"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
        )
    )

    val groupAccount58 = GroupAccount(
        id = AccountId(
            code = "58",
            title = "Změna stavu zásob vlastní činnosti a aktivace"
        ),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "581", title = "Změna stavu nedokončené výroby"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "582", title = "Změna stavu polotovarů"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "583", title = "Změna stavu výrobků"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "584", title = "Změna stavu mladých a ostatních zvířat"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "585", title = "Aktivace materiálu a zboží"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "586", title = "Aktivace vnitropodnikových služeb"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "587", title = "Aktivace dlouhodobého nehmotného majetku"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "588", title = "Aktivace dlouhodobého hmotného majetku"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
        )
    )

    val groupAccount59 = GroupAccount(
        id = AccountId(
            code = "59",
            title = "Daně z příjmů, převodové účty a rezerva na daň z příjmů"
        ),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "591", title = "Daň z příjmů – splatná"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "592", title = "Daň z příjmů – odložená"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "595", title = "Dodatečné odvody daně z příjmů"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "596", title = "Převod podílu na výsledku hospodaření společníkům"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "597", title = "Převod provozních nákladů"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "598", title = "Převod finančních nákladů"),
                features = listOf(Feature.Income, Feature.TaxExpense)
            ),
            SyntheticAccount(
                id = AccountId(code = "599", title = "Změna stavu rezervy na daň z příjmů"),
                features = listOf(Feature.Income, Feature.NonTaxExpense)
            ),
        )
    )
}