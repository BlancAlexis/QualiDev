package fr.ablanc.qualidev.tests

import android.util.Log
import fr.ablanc.qualidev.model.magic.Attack
import fr.ablanc.qualidev.utils.InitWithZeroException

class Test {
    fun testMagicAttackInit(){
        val attack = Attack(10,15,"condition")
        assert(attack.getCost() == 10)
        assert(attack.getDamage() == 15)
        assert(attack.getCondition() == "condition")
        Log.d("TEST", "testMagicAttackInit done");
    }

    fun testMagicAttackInitWithZero(){
        try {
            val attackWithZeroParams = Attack(0,0,"")
        }catch (e : InitWithZeroException) {
            Log.d("TEST", "testMagicAttackInitWithZero done")
            return
        }
        Log.e("TEST", "testMagicAttackInitWithZero failed");
    }

    fun testPokemonAttackInit(){
        val attack = fr.ablanc.qualidev.model.pokemon.Attack(10,15,"condition")
        assert(attack.getCost() == 10)
        assert(attack.getDamage() == 15)
        assert(attack.getCondition() == "condition")
        Log.d("TEST", "testMagicAttackInit done");
    }

    fun testPokemonAttackInitWithZero(){
        try {
            val attackWithZeroParams= fr.ablanc.qualidev.model.pokemon.Attack(0,0,"")
        }catch (e : InitWithZeroException) {
            Log.d("TEST", "testMagicAttackInitWithZero done")
            return
        }
        Log.e("TEST", "testMagicAttackInitWithZero failed");
    }

    fun run(){
        testMagicAttackInit()
        testMagicAttackInitWithZero()
        testPokemonAttackInit()
        testPokemonAttackInitWithZero()
    }
}