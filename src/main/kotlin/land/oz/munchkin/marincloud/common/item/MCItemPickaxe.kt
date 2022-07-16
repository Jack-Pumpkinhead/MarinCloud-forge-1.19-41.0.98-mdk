package land.oz.munchkin.marincloud.common.item

import net.minecraft.world.item.PickaxeItem
import net.minecraft.world.item.Tier

/**
 * Created by CowardlyLion at 2021/6/22 21:21
 */
class MCItemPickaxe(
    itemTier: Tier,
    damage: Int,
    attackSpeed: Float,
    properties: Properties
) : PickaxeItem(itemTier, damage, attackSpeed, properties) {



}