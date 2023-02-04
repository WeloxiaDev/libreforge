package com.willfp.libreforge.effects.impl

import com.willfp.eco.core.integrations.shop.ShopSellEvent
import com.willfp.libreforge.effects.GenericMultiplierEffect
import org.bukkit.event.EventHandler

class EffectSellMultiplier : GenericMultiplierEffect("sell_multiplier") {
    @EventHandler
    fun handle(event: ShopSellEvent) {
        event.multiplier *= getMultiplier(event.player)
    }
}
