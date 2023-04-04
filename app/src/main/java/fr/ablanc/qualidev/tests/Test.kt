package fr.ablanc.qualidev.tests

import android.util.Log
import fr.ablanc.qualidev.model.magic.Attack

class Test {
    fun testMagicAttackInit(){
        val attack : Attack = Attack(10,15,"condition")
        assert(attack.getCost() == 10)
        assert(attack.getDamage() == 15)
        assert(attack.getCondition() == "condition")
        Log.d("TEST", "testMagicAttackInit done");
    }

    fun testMagicAttackInitWithZero(){
        val attackWithZeroParams : Attack = Attack(0,0,"")
        assert(attackWithZeroParams.getCost() == 0)
        assert(attackWithZeroParams.getDamage() == 0)
        assert(attackWithZeroParams.getCondition() == "")
        Log.d("TEST", "testMagicAttackInitWithZero done");
    }

    fun run(){
        testMagicAttackInit()
        testMagicAttackInitWithZero()
    }
}