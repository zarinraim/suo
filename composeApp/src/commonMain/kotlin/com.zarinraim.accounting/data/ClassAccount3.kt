package com.zarinraim.accounting.data

import com.zarinraim.accounting.model.AccountId
import com.zarinraim.accounting.model.GroupAccount
import com.zarinraim.accounting.model.SyntheticAccount
import com.zarinraim.accounting.model.SyntheticAccount.Feature

object ClassAccount3 {

    val groupAccount31 = GroupAccount(
        id = AccountId(code = "31", title = "Pohledávky (krátkodobé a dlouhodobé)"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "311", title = "Pohledávky z obchodních vztahů"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "312", title = "Směnky k inkasu"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "313", title = "Pohledávky za eskontované cenné papíry"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "314", title = "Poskytnuté zálohy – dlouhodobé a krátkodobé"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "315", title = "Ostatní pohledávky"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount32 = GroupAccount(
        id = AccountId(code = "32", title = "Závazky (krátkodobé)"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "321", title = "Závazky z obchodních vztahů"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "322", title = "Směnky k úhradě"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "324", title = "Přijaté zálohy"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "325", title = "Ostatní závazky"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )

    val groupAccount33 = GroupAccount(
        id = AccountId(code = "33", title = "Zúčtování se zaměstnanci a institucemi"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "331", title = "Zaměstnanci"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "333", title = "Ostatní závazky vůči zaměstnancům"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "335", title = "Pohledávky za zaměstnanci"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "336", title = "Zúčtování s institucemi sociál. zabezpečení a zdravot. pojištění"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )

    val groupAccount34 = GroupAccount(
        id = AccountId(code = "34", title = "Zúčtování daní a dotací"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "341", title = "Daň z příjmů"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "342", title = "Ostatní přímé daně"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "343", title = "Daň z přidané hodnoty"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "345", title = "Ostatní daně a poplatky"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "346", title = "Dotace ze státního rozpočtu"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "347", title = "Ostatní dotace"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "349", title = "Vyrovnávací účet pro DPH"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount35 = GroupAccount(
        id = AccountId(code = "35", title = "Pohledávky za společníky"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "351", title = "Pohledávky – ovládaná nebo ovládající osoba"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "352", title = "Pohledávky – podstatný vliv"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "353", title = "Pohledávky za upsaný základní kapitál"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "354", title = "Pohledávky za společníky při úhradě ztráty"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "355", title = "Ostatní pohledávky za společníky obchodní korporace"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "358", title = "Pohledávky za společníky sdruženými ve společnostech"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )

    val groupAccount36 = GroupAccount(
        id = AccountId(code = "36", title = "Závazky ke společníkům"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "361", title = "Závazky – ovládaná nebo ovládající osoba"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "362", title = "Závazky – podstatný vliv"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "364", title = "Závazky ke společníkům při rozdělování zisku"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "365", title = "Ostatní závazky ke společníkům obchodní korporace"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "366", title = "Závazky ke společníkům ze závislé činnosti"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "367", title = "Závazky z upsaných nesplacených cenných papírů a vkladů"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "368", title = "Závazky ke společníkům sdruženým ve společnosti"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )

    val groupAccount37 = GroupAccount(
        id = AccountId(code = "37", title = "Jiné pohledávky a závazky"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "371", title = "Pohledávky z prodeje obchodního závodu"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "372", title = "Závazky z koupě obchodního závodu"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "373", title = "Pohledávky a závazky z pevných termínových operací"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "374", title = "Pohledávky z nájmu a pachtu"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "375", title = "Pohledávky z vydaných dluhopisů"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "376", title = "Nakoupené opce"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "377", title = "Prodané opce"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "378", title = "Jiné pohledávky"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "379", title = "Jiné závazky"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )

    val groupAccount38 = GroupAccount(
        id = AccountId(code = "38", title = "Přechodné účty aktiv a pasiv"),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "381", title = "Náklady příštích období"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "382", title = "Komplexní náklady příštích období"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "383", title = "Výdaje příštích období"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "384", title = "Výnosy příštích období"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
            SyntheticAccount(
                id = AccountId(code = "385", title = "Příjmy příštích období"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "388", title = "Dohadné účty aktivní"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "389", title = "Dohadné účty pasivní"),
                features = listOf(Feature.Balance, Feature.Liability)
            ),
        )
    )

    val groupAccount39 = GroupAccount(
        id = AccountId(
            code = "39",
            title = "Opravná položka k zúčtovacím vztahům a vnitřní zúčtování"
        ),
        syntheticAccounts = listOf(
            SyntheticAccount(
                id = AccountId(code = "391", title = "Opravná položka k pohledávkám"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "395", title = "Vnitřní zúčtování"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
            SyntheticAccount(
                id = AccountId(code = "398", title = "Spojovací účet při společnosti"),
                features = listOf(Feature.Balance, Feature.Asset)
            ),
        )
    )
}