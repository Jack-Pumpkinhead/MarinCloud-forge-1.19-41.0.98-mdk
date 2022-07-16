package land.oz.munchkin.marincloud.common.capability.potion_attack

import net.minecraft.world.effect.MobEffectInstance

/**
 * Created by CowardlyLion at 2021/9/10 15:08
 */
class EffectPotionAttack(
    val effectInstance: MobEffectInstance,
    var radius: Float,
    var chance: Float,
    var maxEntity: Int
) {


}