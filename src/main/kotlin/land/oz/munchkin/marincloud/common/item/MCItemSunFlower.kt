package land.oz.munchkin.marincloud.common.item

import land.oz.munchkin.marincloud.common.item.build_in.MCItems
import land.oz.munchkin.marincloud.common.sound.MCSoundEvents
import land.oz.munchkin.marincloud.util.randomizeEvents
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import kotlin.random.Random

/**
 * Created by CowardlyLion at 2021/6/22 21:29
 */
class MCItemSunFlower(properties: Properties) : MCItem(properties) {

//    override fun onUseTick(p_219972_1_: World, p_219972_2_: LivingEntity, p_219972_3_: ItemStack, p_219972_4_: Int) {
//    }

    override fun getEatingSound(): SoundEvent {

        return Random.randomizeEvents(floatArrayOf(1F, 1F, 1F),
            { MCSoundEvents.chomp.get() },
            { MCSoundEvents.chomp2.get() },
            { MCSoundEvents.chompSoft.get() })
    }

    override fun onUsingTick(stack: ItemStack?, player: LivingEntity?, count: Int) {
        if (player is Player) {
            if (player.level.isClientSide.not()) {
                val i = player.useItemRemainingTicks
                if (i <= player.useItem.useDuration - 7 && i % 4 == 0) {
                    val sun = ItemStack(MCItems.pvz_Sun.get())
                    val standingEyeHeight = player.getStandingEyeHeight(player.pose, player.getDimensions(player.pose))
                    val itemEntity = ItemEntity(player.level, player.x, player.y + (standingEyeHeight * 0.8), player.z, sun)
                    itemEntity.deltaMovement = player.forward.multiply(0.3, 0.3, 0.3)
                    itemEntity.setDefaultPickUpDelay()
                    player.level.addFreshEntity(itemEntity)
                }
            }
        }
    }
}