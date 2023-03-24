package fr.ablanc.qualidev

import fr.ablanc.qualidev.model.Card

class CardList private constructor(){
    private var cardList : MutableList<Card> = ArrayList<Card>();

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


}