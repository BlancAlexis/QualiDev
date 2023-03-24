package fr.ablanc.qualidev.model.pokemon

import kotlin.math.cos

class Attack(var cost: Int, var damage : Int, var condition: String) {
    fun getCost() : Int{
        return cost;
    }

    fun getDamage() : Int{
        return damage;
    }

    fun getCondition() : String{
        return condition;
    }

    override fun toString(): String {
        return "Attack(cost=$cost, damage=$damage, condition='$condition')"
    }

}