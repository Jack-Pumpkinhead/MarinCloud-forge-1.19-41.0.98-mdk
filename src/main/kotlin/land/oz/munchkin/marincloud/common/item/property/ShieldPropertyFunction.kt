package land.oz.munchkin.marincloud.common.item.property

import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.item.ItemStack

/**
 * Created by CowardlyLion at 2021/12/9 16:50
 */
object ShieldPropertyFunction : ClampedItemPropertyFunction {

    override fun unclampedCall(itemStack: ItemStack, clientLevel: ClientLevel?, livingEntity: LivingEntity?, p_174567_: Int): Float {
        return if (livingEntity != null && livingEntity.isUsingItem && livingEntity.useItem == itemStack) 1.0F else 0.0F
    }

}