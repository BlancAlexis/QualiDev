package fr.ablanc.qualidev.model.magic

import fr.ablanc.qualidev.model.Card
import fr.ablanc.qualidev.model.CardType

class MagicCard(
        var price: Int,
        var strength: Int,
        var type: Type,
        var rarity: String,
        var attack: Attack,
        name: String,
        cardType: CardType
) : Card(name, cardType) {
        override fun toString(): String {
                return super.toString()+"prix=$price, force=$strength, type=$type, rarete=$rarity \n"
        }
}
