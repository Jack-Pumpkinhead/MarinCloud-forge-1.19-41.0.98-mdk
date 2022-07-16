package land.oz.munchkin.marincloud.feature.unbreakable.common.command

import com.mojang.brigadier.arguments.BoolArgumentType
import land.oz.munchkin.marincloud.feature.unbreakable.common.Unbreakable
import net.minecraft.commands.Commands
import net.minecraft.commands.arguments.EntityArgument
import net.minecraftforge.event.RegisterCommandsEvent
import net.minecraftforge.eventbus.api.SubscribeEvent

/**
 * Created by CowardlyLion at 2021/12/10 15:49
 */
object MCCommandUnbreakable {

    val SET = "set"
    val TARGET = "targets"
    val BOOL = "boolean"

    @SubscribeEvent
    fun onRegisterCommand(event: RegisterCommandsEvent) {
        event.dispatcher.register(
            Commands.literal("unbreakable")
                .requires { it.hasPermission(2) }
                .then(
                    Commands.literal(SET)
                        .then(
                            Commands.argument(TARGET, EntityArgument.entities())
                                .then(
                                    Commands.argument(BOOL, BoolArgumentType.bool()).executes {
                                        Unbreakable.setUnbreakable(it.source, EntityArgument.getEntities(it, TARGET), BoolArgumentType.getBool(it, BOOL))
                                    }
                                )
                        )
                )
        )
        event.dispatcher.register(
            Commands.literal("unbreakableToggle")
                .requires { it.hasPermission(2) }
                .executes {
                    Unbreakable.toggleUnbreakable(it.source, listOf(it.source.entityOrException))
                }.then(
                    Commands.argument(TARGET, EntityArgument.entities()).executes {
                        Unbreakable.toggleUnbreakable(it.source, EntityArgument.getEntities(it, TARGET))
                    }
                ))

    }


}