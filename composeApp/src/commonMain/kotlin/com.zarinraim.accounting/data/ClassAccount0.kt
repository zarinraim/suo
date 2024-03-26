package com.zarinraim.accounting.data

import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.model.SyntheticAccount
import com.zarinraim.accounting.model.SyntheticAccount.Feature

object ClassAccount0 {

    val groupAccount01 = GroupAccount(
        id = AccountId(code = "01", title = "Dlouhodobý nehmotný majetek"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "012", title = "Nehmotné výsledky výzkumu a vývoje"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "013", title = "Software"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "014", title = "Ostatní ocenitelná práva"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "015", title = "Goodwill"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "016", title = "Povolenky na emise"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "017", title = "Preferenční limity"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "019", title = "Ostatní dlouhodobý nehmotný majetek"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount02 = GroupAccount(
        id = AccountId(code = "02", title = "Dlouhodobý hmotný majetek odpisovaný"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "021", title = "Stavby"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "022", title = "Hmotné movité věci a jejich soubory"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "025", title = "Pěstitelské celky trvalých porostů"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "026", title = "Dospělá zvířata a jejich skupiny"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "029", title = "Jiný dlouhodobý hmotný majetek"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount03 = GroupAccount(
        id = AccountId(code = "03", title = "Dlouhodobý hmotný majetek neodpisovaný"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "031", title = "Pozemky"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "032", title = "Umělecká díla a sbírky"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount04 = GroupAccount(
        id = AccountId(
            code = "04",
            title = "Nedokončený dlouhodobý nehmotný a hmotný majetek"
        ), syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "041", title = "Pořízení dlouhodobého nehmotného majetku"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "042", title = "Pořízení dlouhodobého hmotného majetku"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount05 = GroupAccount(
        id = AccountId(code = "05", title = "Poskytnuté zálohy na dlouhodobý majetek"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "051", title = "Poskytnuté zálohy na dlouhodobý nehmotný majetek"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "052", title = "Poskytnuté zálohy na dlouhodobý hmotný majetek"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "053", title = "Poskytnuté zálohy na dlouhodobý finanční majetek"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount06 = GroupAccount(
        id = AccountId(code = "06", title = "Dlouhodobý finanční majetek"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "061", title = "Podíly – ovládaná nebo ovládající osoba"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "062", title = "Podíly – podstatný vliv"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "063", title = "Ostatní dlouhodobé cenné papíry a podíly"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "065", title = "Dluhové cenné papíry držené do splatnosti"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "066", title = "Zápůjčky a úvěry - ovládaná nebo ovládající osoba"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "067", title = "Ostatní zápůjčky a úvěry"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "068", title = "Zápůjčky a úvěry – podstatný vliv"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "069", title = "Jiný dlouhodobý finanční majetek"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount07 = GroupAccount(
        id = AccountId(code = "07", title = "Oprávky k dlouhodobému nehmotnému majetku"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "072", title = "Oprávky k nehmotným výsledkům výzkumu a vývoje"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "073", title = "Oprávky k softwaru"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "074", title = "Oprávky k ostatním ocenitelným právům"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "075", title = "Oprávky ke goodwillu"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "079", title = "Oprávky k ostatnímu dlouhodobému nehmotnému majetku"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount08 = GroupAccount(
        id = AccountId(code = "08", title = "Oprávky k dlouhodobému hmotnému majetku"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "081", title = "Oprávky ke stavbám"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "082", title = "Oprávky k hmotným movitým věcem a jejich souborům"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "085", title = "Oprávky k pěstitelským celkům trvalých porostů"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "086", title = "Oprávky k dospělým zvířatům a jejich skupinám"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "089", title = "Oprávky k jinému dlouhodobému hmotnému majetku"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount09 = GroupAccount(
        id = AccountId(code = "09", title = "Opravné položky k dlouhodobému majetku"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "091", title = "Opravná položka k dlouhodobému nehmotnému majetku"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "092", title = "Opravná položka k dlouhodobému hmotnému majetku"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "093", title = "Opravná položka k dlouhodobému nedokončenému nehmotnému majetku"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "094", title = "Opravná položka k dlouhodobému nedokončenému hmotnému majetku"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "095", title = "Opravná položka k poskytnutým zálohám na dlouhodobý majetek"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "096", title = "Opravná položka k dlouhodobému finančnímu majetku"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "097", title = "Oceňovací rozdíl k nabytému majetku"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "098", title = "Oprávky k oceňovacímu rozdílu k nabytému majetku"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )
}