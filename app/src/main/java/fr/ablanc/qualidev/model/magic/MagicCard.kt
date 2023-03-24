package fr.ablanc.qualidev.model.magic

import fr.ablanc.qualidev.model.Card

class MagicCard(
        var prixMagicCard: Int,
        var forceCard: Int,
        var typeMagicCard: String,
        var rareteMagicCard: String,
        name: String,
        cardType: String
) : Card(name, cardType) {
        override fun toString(): String {
                return "MagicCard(prixMagicCard=$prixMagicCard, forceCard=$forceCard, typeMagicCard='$typeMagicCard', rareteMagicCard='$rareteMagicCard')"
        }
}
