package com.zarinraim.accounting.data

import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.Feature
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.model.SyntheticAccount

object ClassAccount4 {

    val groupAccount41 = GroupAccount(
        id = AccountId(code = "41", title = "Základní kapitál a kapitálové fondy"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "411", title = "Základní kapitál"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "412", title = "Ážio"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "413", title = "Ostatní kapitálové fondy"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "414", title = "Oceňovací rozdíly z přecenění majetku a závazků"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "416", title = "Rozdíly z ocenění při přeměnách obchodních korporací"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "417", title = "Rozdíly z přeměn obchodních korporací"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "418", title = "Oceňovací rozdíly z přecenění při přeměnách obchodních korporací"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "419", title = "Změny základního kapitálu"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )
    val groupAccount42 = GroupAccount(
        id = AccountId(
            code = "42",
            title = "Fondy ze zisku a převedené výsledky hospodaření"
        ),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "421", title = "Ostatní rezervní fondy"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "422", title = "Nedělitelný fond"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "423", title = "Statutární fondy"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "426", title = "Jiný výsledek hospodaření minulých let"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "427", title = "Ostatní fondy"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "428", title = "Nerozdělený zisk minulých let"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "429", title = "Neuhrazená ztráta minulých let"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )

    val groupAccount43 = GroupAccount(
        id = AccountId(code = "43", title = "Výsledek hospodaření"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "431", title = "Výsledek hospodaření ve schvalovacím řízení"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "432", title = "Rozhodnuto o zálohové výplatě podílu na zisku"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )

    val groupAccount45 = GroupAccount(
        id = AccountId(code = "45", title = "Rezervy"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "451", title = "Rezervy podle zvláštních právních předpisů"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "453", title = "Rezerva na daň z příjmů"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "459", title = "Ostatní rezervy"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )

    val groupAccount46 = GroupAccount(
        id = AccountId(code = "46", title = "Dlouhodobé závazky k úvěrovým institucím"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "461", title = "Závazky k úvěrovým institucím"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )

    val groupAccount47 = GroupAccount(
        id = AccountId(code = "47", title = "Dlouhodobé závazky"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "471", title = "Dlouhodobé závazky – ovládaná nebo ovládající osoba"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "472", title = "Dlouhodobé závazky – podstatný vliv"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "473", title = "Vydané dluhopisy"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "474", title = "Závazky z nájmu a pachtu"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "475", title = "Dlouhodobé přijaté zálohy"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "478", title = "Dlouhodobé směnky k úhradě"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "479", title = "Jiné dlouhodobé závazky"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )

    val groupAccount48 = GroupAccount(
        id = AccountId(code = "48", title = "Odložený daňový závazek a pohledávka"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "481", title = "Odložený daňový závazek a pohledávka"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )

    val groupAccount49 = GroupAccount(
        id = AccountId(code = "49", title = "Individuální podnikatel"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "491", title = "Účet individuálního podnikatele"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )
}