package fr.ablanc.qualidev.model.magic

import fr.ablanc.qualidev.utils.InitWithZeroException
import kotlin.math.cos


class Attack(private var cost: Int, private var damage: Int, private var condition: String) {

    init {
        if(cost == 0 || damage == 0){
            throw InitWithZeroException("Trying to init the attack with value 0")
        }
    }

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