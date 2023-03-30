package fr.ablanc.qualidev.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.ablanc.qualidev.FirstFragment
import fr.ablanc.qualidev.model.Card
import fr.ablanc.qualidev.model.CardType
import fr.ablanc.qualidev.model.magic.MagicCard
import fr.ablanc.qualidev.model.pokemon.Attack
import fr.ablanc.qualidev.model.pokemon.PokemonCard
import fr.ablanc.qualidev.model.pokemon.Type
import kotlinx.coroutines.launch

class MainVM : ViewModel() {

    val word: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

//    fun updateWord() {
//        word.postValue(text)
//    }

    fun getData() {
        var temps = ""
        viewModelScope.launch {
            val pikachuAttack1 = Attack(10, 25, "Pikachu Attack 1");
            val pikachuAttack2 = Attack(23, 48, "Pikachu Attack 2");
            val pikachuAttackArray = arrayOf(pikachuAttack1, pikachuAttack2);
            val pikachu = PokemonCard(
                Type.Electric,
                12,
                pikachuAttackArray,
                "Rare",
                12,
                "Pikachu",
                CardType.Pokemon
            );
            Log.i("pikachu", pikachu.toString());

            val magicCardAttack =
                fr.ablanc.qualidev.model.magic.Attack(12, 23, "Magic Card Attack 1");
            val magicCard = MagicCard(
                10,
                45,
                fr.ablanc.qualidev.model.magic.Type.Vanguard,
                "Normal",
                magicCardAttack,
                "MagicCard",
                CardType.Magic
            );

            val list: MutableList<Card> = ArrayList()
            list.add(pikachu)
            list.add(magicCard)
            Log.i("Taille tableau", (list.size).toString())

            for (cards in list) {
                temps += cards.toString()
            }
        }
        word.postValue(temps)
    }


}