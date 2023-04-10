package fr.ablanc.qualidev

import android.util.Log
import fr.ablanc.qualidev.model.Card
import fr.ablanc.qualidev.model.CardType
import fr.ablanc.qualidev.model.pokemon.PokemonCard

class CardList private constructor(){
    protected var cardList : MutableList<Card> = ArrayList<Card>();

    companion object{
        private var instance : CardList? = null;
        fun getInstance() : CardList{
            if(instance == null){
                instance = CardList();
            }
            return instance!!
        }
    }

    fun add(card : Card){
        cardList.add(card);
    }

    fun sortByPokemon() {
        val sortedList: ArrayList<Card> = ArrayList()
        val iterator = cardList.iterator()
        while (iterator.hasNext()) {
            val card = iterator.next()
            if (card.cardType == CardType.Pokemon) {
                val pokemonCard = card as PokemonCard
                for (attack in pokemonCard.attack) {
                    if (attack.getDamage() > 5) {
                        sortedList.add(card)
                        break
                    }
                }
            }
        }
        cardList.clear()
        cardList.addAll(sortedList)
    }
    fun sortByCardType(firtElementType : CardType){
        var sortedList : ArrayList<Card> = ArrayList<Card>();
        cardList.forEach(){
            if(it.cardType == firtElementType){
                sortedList.add(it);
                cardList.remove(it);
            }
        }
        sortedList.addAll(sortedList.lastIndex + 1,cardList)
        cardList.clear()
        cardList.addAll(sortedList)
    }

    fun display(): String{
        var temp=""
     for (Card in cardList){
         temp+=Card.toString()
        }
        return temp
    }
}