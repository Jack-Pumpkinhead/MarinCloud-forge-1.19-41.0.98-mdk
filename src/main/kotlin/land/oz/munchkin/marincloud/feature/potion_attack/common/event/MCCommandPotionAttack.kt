package land.oz.munchkin.marincloud.feature.potion_attack.common.event

import com.mojang.brigadier.arguments.BoolArgumentType
import com.mojang.brigadier.arguments.FloatArgumentType
import com.mojang.brigadier.arguments.IntegerArgumentType
import land.oz.munchkin.marincloud.feature.potion_attack.common.command.PotionAttackCommand
import net.minecraft.commands.Commands
import net.minecraft.commands.arguments.EntityArgument
import net.minecraft.commands.arguments.MobEffectArgument
import net.minecraftforge.event.RegisterCommandsEvent
import net.minecraftforge.eventbus.api.SubscribeEvent

/**
 * Created by CowardlyLion at 2021/9/10 14:59
 */
object MCCommandPotionAttack {

    val CLEAR = "clear"
    val GIVE = "give"
    val TARGET = "targets"
    val EFFECT = "effect"
    val RADIUS = "radius"
    val CHANCE = "chance"
    val maxEntity = "maxEntity"

    val SECONDS = "seconds"
    val AMPLIFIER = "amplifier"
    val hideParticles = "hideParticles"

    @SubscribeEvent
    fun onRegisterCommand(event: RegisterCommandsEvent) {
        event.dispatcher.register(
            Commands.literal("potionattack")
                .requires { it.hasPermission(2) }
                .then(
                    Commands.literal(CLEAR).executes {
                        PotionAttackCommand.clearPotionAttackEffects(it.source, listOf(it.source.entityOrException))
                    }.then(
                        Commands.argument(TARGET, EntityArgument.entities()).executes {
                            PotionAttackCommand.clearPotionAttackEffects(it.source, EntityArgument.getEntities(it, TARGET))
                        }.then(
                            Commands.argument(EFFECT, MobEffectArgument.effect()).executes {
                                PotionAttackCommand.clearPotionAttackEffect(it.source, EntityArgument.getEntities(it, TARGET), MobEffectArgument.getEffect(it, EFFECT))
                            }
                        )
                    )
                )
                .then(
                    Commands.literal(GIVE)
                        .then(
                            Commands.argument(TARGET, EntityArgument.entities())
                                .then(
                                    Commands.argument(EFFECT, MobEffectArgument.effect()).executes {
                                        PotionAttackCommand.givePotionAttackEffects(it.source, EntityArgument.getEntities(it, TARGET), MobEffectArgument.getEffect(it, EFFECT), 5F, 1F, 1000, 0, 0, false)
                                    }.then(
                                        Commands.argument(RADIUS, FloatArgumentType.floatArg(0F, 231F)).executes {
                                            PotionAttackCommand.givePotionAttackEffects(it.source, EntityArgument.getEntities(it, TARGET), MobEffectArgument.getEffect(it, EFFECT), FloatArgumentType.getFloat(it, RADIUS), 1F, 1000, 0, 0, false)
                                        }.then(
                                            Commands.argument(CHANCE, FloatArgumentType.floatArg(0F, 1F)).executes {
                                                PotionAttackCommand.givePotionAttackEffects(it.source, EntityArgument.getEntities(it, TARGET), MobEffectArgument.getEffect(it, EFFECT), FloatArgumentType.getFloat(it, RADIUS), FloatArgumentType.getFloat(it, CHANCE), 1000, 0, 0, false)
                                            }.then(
                                                Commands.argument(maxEntity, IntegerArgumentType.integer(0, 1000)).executes {
                                                    PotionAttackCommand.givePotionAttackEffects(it.source, EntityArgument.getEntities(it, TARGET), MobEffectArgument.getEffect(it, EFFECT), FloatArgumentType.getFloat(it, RADIUS), FloatArgumentType.getFloat(it, CHANCE), IntegerArgumentType.getInteger(it, maxEntity), 0, 0, false)
                                                }.then(
                                                    Commands.argument(SECONDS, IntegerArgumentType.integer(1, 1000000)).executes {
                                                        PotionAttackCommand.givePotionAttackEffects(it.source, EntityArgument.getEntities(it, TARGET), MobEffectArgument.getEffect(it, EFFECT), FloatArgumentType.getFloat(it, RADIUS), FloatArgumentType.getFloat(it, CHANCE), IntegerArgumentType.getInteger(it, maxEntity), IntegerArgumentType.getInteger(it, SECONDS), 0, false)
                                                    }.then(
                                                        Commands.argument(AMPLIFIER, IntegerArgumentType.integer(0, 255)).executes {
                                                            PotionAttackCommand.givePotionAttackEffects(it.source, EntityArgument.getEntities(it, TARGET), MobEffectArgument.getEffect(it, EFFECT), FloatArgumentType.getFloat(it, RADIUS), FloatArgumentType.getFloat(it, CHANCE), IntegerArgumentType.getInteger(it, maxEntity), IntegerArgumentType.getInteger(it, SECONDS), IntegerArgumentType.getInteger(it, AMPLIFIER), false)
                                                        }.then(
                                                            Commands.argument(hideParticles, BoolArgumentType.bool()).executes {
                                                                PotionAttackCommand.givePotionAttackEffects(it.source, EntityArgument.getEntities(it, TARGET), MobEffectArgument.getEffect(it, EFFECT), FloatArgumentType.getFloat(it, RADIUS), FloatArgumentType.getFloat(it, CHANCE), IntegerArgumentType.getInteger(it, maxEntity), IntegerArgumentType.getInteger(it, SECONDS), IntegerArgumentType.getInteger(it, AMPLIFIER), BoolArgumentType.getBool(it, hideParticles))
                                                            }
                                                        )
                                                    )
                                                )
                                            )
                                        )
                                    )
                                )
                        )
                )
        )
    }


}