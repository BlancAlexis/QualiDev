package fr.ablanc.qualidev.model

abstract class Card(val name: String, val cardType : CardType ){
    override fun toString(): String {
        return "Type=$cardType, $name "
    }
}