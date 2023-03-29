package fr.ablanc.qualidev.model.pokemon

import fr.ablanc.qualidev.model.Card
import fr.ablanc.qualidev.model.CardType

class PokemonCard(
        var type : Type,
        var hp: Int,
        var attack: Array<Attack>,
        var rarity: String,
        var level : Int,
        name: String,
        cardType: CardType
) : Card(name, cardType) {
    override fun toString(): String {
        return super.toString()+" de type=$type, hp=$hp, rarity='$rarity', level=$level. \n"
    }
}