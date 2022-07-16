package land.oz.munchkin.marincloud.feature.potion_attack.common.event

import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.capability.potion_attack.MCProviderPotionAttack
import land.oz.munchkin.marincloud.util.rollCoin
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.ai.targeting.TargetingConditions
import net.minecraft.world.item.ItemStack
import net.minecraftforge.event.AttachCapabilitiesEvent
import net.minecraftforge.event.entity.player.AttackEntityEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import kotlin.math.min

/**
 * Created by CowardlyLion at 2022/7/16 17:11
 */
object PotionAttackEvents {

    @SubscribeEvent
    fun onAttachCapability(event: AttachCapabilitiesEvent<ItemStack>) {
        if (event.`object`.isEnchantable) {
            event.addCapability(ResourceLocation(MarinCloud.ID, "potion_attack_capability"), MCProviderPotionAttack())
        }
    }

    @SubscribeEvent
    fun onAttackEntity(event: AttackEntityEvent) {
        val player = event.entity
        val level = player.level
        if (level.isClientSide.not()) {

            val mainHandItem = player.mainHandItem
            mainHandItem.getCapability(MCProviderPotionAttack.POTION_ATTACK_CAPABILITY, null).ifPresent { potionAttack ->
                if (potionAttack.effects.isEmpty()) return@ifPresent

                val target = event.target
                if (target is LivingEntity) {
                    for (effect in potionAttack.effects) {
                        val predicate = TargetingConditions.forCombat().range(effect.radius.toDouble()).selector { it != player }
                        val nearbyEntities = target.level.getNearbyEntities(LivingEntity::class.java, predicate, target, target.boundingBox.inflate(effect.radius.toDouble()))
                        nearbyEntities += target
                        val count = min(nearbyEntities.size, effect.maxEntity)
                        for (i in 0 until count) {
                            val entity = nearbyEntities[i]
                            if (level.random.rollCoin(effect.chance)) {
                                entity.addEffect(MobEffectInstance(effect.effectInstance))
                            }
                        }
                    }
                }
            }
        }
    }

}