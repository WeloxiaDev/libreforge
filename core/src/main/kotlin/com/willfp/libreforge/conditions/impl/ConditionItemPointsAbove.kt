package com.willfp.libreforge.conditions.impl

import com.willfp.eco.core.config.interfaces.Config
import com.willfp.libreforge.NoCompileData
import com.willfp.libreforge.ProvidedHolder
import com.willfp.libreforge.arguments
import com.willfp.libreforge.conditions.Condition
import com.willfp.libreforge.points
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object ConditionItemPointsAbove : Condition<NoCompileData>("item_points_above") {
    override val arguments = arguments {
        require("type", "You must specify the type of points to check for!")
        require("amount", "You must specify minimum amount of points!")
    }

    override fun isMet(player: Player, config: Config, holder: ProvidedHolder, compileData: NoCompileData): Boolean {
        val item = holder.provider as? ItemStack ?: return false
        val type = config.getString("type")
        val amount = config.getDoubleFromExpression("type", player)

        return item.points[type] >= amount
    }
}
