package fr.ablanc.qualidev.model.magic

import fr.ablanc.qualidev.model.Card

class MagicCard(
        var price: Int,
        var strength: Int,
        var type: String,
        var rarity: String,
        name: String,
        cardType: String
) : Card(name, cardType) {
        override fun toString(): String {
                return "MagicCard(prixMagicCard=$price, forceCard=$strength, typeMagicCard='$type', rareteMagicCard='$rarity')"
        }
}
