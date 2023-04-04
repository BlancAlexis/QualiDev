package fr.ablanc.qualidev.model.magic


class Attack(private var cost: Int, private var damage: Int, private var condition: String) {
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