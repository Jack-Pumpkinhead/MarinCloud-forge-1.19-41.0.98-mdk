package land.oz.munchkin.marincloud.common.item

import net.minecraft.world.item.SwordItem
import net.minecraft.world.item.Tier

/**
 * Created by CowardlyLion at 2021/11/1 19:55
 */
class MCItemSword(
    tier: Tier,
    attackDamageBase: Int,
    attackSpeedBase: Float,
    properties: Properties
) : SwordItem(tier, attackDamageBase, attackSpeedBase, properties) {

}