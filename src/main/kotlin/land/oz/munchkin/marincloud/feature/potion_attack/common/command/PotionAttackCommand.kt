package land.oz.munchkin.marincloud.feature.potion_attack.common.command

import com.mojang.brigadier.exceptions.SimpleCommandExceptionType
import land.oz.munchkin.marincloud.common.capability.potion_attack.EffectPotionAttack
import land.oz.munchkin.marincloud.common.capability.potion_attack.MCProviderPotionAttack
import net.minecraft.commands.CommandSourceStack
import net.minecraft.network.chat.Component
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity

/**
 * Created by CowardlyLion at 2021/9/10 11:11
 */
object PotionAttackCommand {


    /*val ERROR_NOT_LIVING_ENTITY = DynamicCommandExceptionType { obj: Any? ->
        TranslationTextComponent("commands.potionattack.failed.entity", obj)
    }*/
    /*val ERROR_NO_ITEM = DynamicCommandExceptionType { obj: Any? ->
        TranslationTextComponent("commands.potionattack.failed.itemless", obj)
    }*/

    val ERROR_GIVE_FAILED = SimpleCommandExceptionType(Component.translatable("commands.potionattack.failed"))

    fun clearPotionAttackEffects(source: CommandSourceStack, entities: Collection<Entity>): Int {
        var successCount = 0
        entities.forEach { entity ->
            if (entity is LivingEntity) {
                val mainHandItem = entity.mainHandItem
                if (mainHandItem.isEmpty.not()) {
                    mainHandItem.getCapability(MCProviderPotionAttack.POTION_ATTACK_CAPABILITY, null).ifPresent { capability ->
                        capability.effects.clear()
                        successCount++
                    }
                }
            }
        }
        if (successCount == 1) {
            source.sendSuccess(Component.translatable("commands.potionattack.clear.success.single", entities.first().displayName), true)
        } else {
            source.sendSuccess(Component.translatable("commands.potionattack.clear.success.multiple", successCount), true)
        }
        return successCount
    }

    fun clearPotionAttackEffect(source: CommandSourceStack, entities: Collection<Entity>, effect: MobEffect): Int {
        var successCount = 0
        val successList = mutableListOf<LivingEntity>()
        entities.forEach { entity ->
            if (entity is LivingEntity) {
                val mainHandItem = entity.mainHandItem
                if (mainHandItem.isEmpty.not()) {
                    mainHandItem.getCapability(MCProviderPotionAttack.POTION_ATTACK_CAPABILITY, null).ifPresent { capability ->
                        val hasRemoved = capability.effects.removeIf {
                            it.effectInstance.effect == effect
                        }
                        if (hasRemoved) {
                            successCount++
                            successList += entity
                        }
                    }
                }
            }
        }
        if (successCount == 1) {
            source.sendSuccess(Component.translatable("commands.potionattack.clear.effect.success.single", entities.first().displayName, effect.displayName), true)
        } else {
            source.sendSuccess(Component.translatable("commands.potionattack.clear.effect.success.multiple", successCount, effect.displayName), true)
        }
        return successCount
    }

    fun givePotionAttackEffects(source: CommandSourceStack, entities: Collection<Entity>, effect: MobEffect, radius: Float, chance: Float, maxEntity: Int, seconds: Int, amplifier: Int, hideParticles: Boolean): Int {
        val ticks = if (seconds != 0) {
            if (effect.isInstantenous) seconds else seconds * 20
        } else if (effect.isInstantenous) 1 else 600

        val effectInstance = MobEffectInstance(effect, ticks, amplifier, false, hideParticles)

        var successCount = 0
        val successList = mutableListOf<LivingEntity>()
        entities.forEach { entity ->
            if (entity is LivingEntity) {
                val mainHandItem = entity.mainHandItem
                if (mainHandItem.isEmpty.not()) {
                    mainHandItem.getCapability(MCProviderPotionAttack.POTION_ATTACK_CAPABILITY, null).ifPresent { capability ->
                        capability.effects += EffectPotionAttack(effectInstance, radius, chance, maxEntity)
                        successCount++
                        successList += entity
                    }
                }
            }
        }
        if (successCount == 0) {
            throw ERROR_GIVE_FAILED.create()
        } else {
            if (successCount == 1) {
                source.sendSuccess(Component.translatable("commands.potionattack.give.success.single", effect.displayName, ticks, successList[0].displayName), true)
            } else {
                source.sendSuccess(Component.translatable("commands.potionattack.give.success.multiple", effect.displayName, ticks, successCount), true)
            }
            return successCount
        }
    }

}