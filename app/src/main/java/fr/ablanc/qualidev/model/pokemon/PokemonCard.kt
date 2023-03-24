package fr.ablanc.qualidev.model.pokemon

import fr.ablanc.qualidev.model.Card

class PokemonCard(
        var type : String,
        var hp: Int,
        var attack: Array<Attack>,
        var rarity: String,
        var level : Int,
        name: String,
        cardType: String
) : Card(name, cardType) {
    override fun toString(): String {
        return "PokemonCard(name= $name,type='$type', hp=$hp, attack=${attack.contentToString()}, rarity='$rarity', level=$level)"
    }
}