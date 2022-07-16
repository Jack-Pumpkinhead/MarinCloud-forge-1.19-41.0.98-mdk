package land.oz.munchkin.marincloud.common.event

import land.oz.munchkin.marincloud.common.item.MCItemBrush
import land.oz.munchkin.marincloud.common.item.MCItemCrazyDave
import land.oz.munchkin.marincloud.common.item.MCItemDiamond
import land.oz.munchkin.marincloud.common.item.build_in.MCItems
import land.oz.munchkin.marincloud.common.sound.MCSoundEvents
import land.oz.munchkin.marincloud.config.MCConfig
import land.oz.munchkin.marincloud.util.randomPitch
import land.oz.munchkin.marincloud.util.randomizeEvent
import net.minecraft.network.chat.Component
import net.minecraft.sounds.SoundSource
import net.minecraft.world.entity.item.ItemEntity
import net.minecraftforge.event.entity.EntityJoinLevelEvent
import net.minecraftforge.event.entity.player.AdvancementEvent
import net.minecraftforge.event.entity.player.PlayerEvent
import net.minecraftforge.event.entity.player.PlayerInteractEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import kotlin.math.min

/**
 * Created by CowardlyLion at 2021/6/23 13:35
 */

object MCEvents {

    @SubscribeEvent
    fun onPlayerItemPickup(event: PlayerEvent.ItemPickupEvent) {
        val player = event.entity
        if (player.level.isClientSide.not()) {
            when (event.stack.item) {
                MCItems.pvz_Sun.get() -> {
                    player.level.playSound(null, player.x, player.y, player.z, MCSoundEvents.CatchSun.get(), SoundSource.PLAYERS, 0.3F, player.random.randomPitch())
                }
                is MCItemDiamond      -> {
                    player.random.randomizeEvent(3F, 1F, {
                        player.level.playSound(null, player.x, player.y, player.z, MCSoundEvents.coin.get(), SoundSource.PLAYERS, 0.3F, player.random.randomPitch())
                    }, {
                        player.level.playSound(null, player.x, player.y, player.z, MCSoundEvents.diamond.get(), SoundSource.PLAYERS, 0.3F, player.random.randomPitch())
                    })
                }
            }
        }
    }

    @SubscribeEvent
    fun onDiamondJoinWorld(event: EntityJoinLevelEvent) {
        val entity = event.entity
        if (event.level.isClientSide.not()) {
            if (event.isCanceled.not() && entity is ItemEntity && entity.item.item is MCItemDiamond) {
                entity.level.playSound(null, entity.x, entity.y, entity.z, MCSoundEvents.DiamondSpawn.get(), SoundSource.AMBIENT, 0.3F, entity.level.random.randomPitch())
            }
        }
    }

    @SubscribeEvent
    fun onPlayerRightClick(event: PlayerInteractEvent.RightClickItem) {
        val player = event.entity
        if (player.level.isClientSide.not()) {

            val mainHandItem = player.mainHandItem.item
            val offhandItem = player.offhandItem

            when (mainHandItem) {
                is MCItemBrush     -> {
                    mainHandItem.handleBrushUsing(player, offhandItem)
                }
                is MCItemCrazyDave -> {
                    mainHandItem.playsound(player)
                }
            }

        }
    }

    @SubscribeEvent
    fun onPlayerGetAdvancement(event: AdvancementEvent) {
        if (MCConfig.ExtendWorldBorder.enabled.get().not()) return

        val player = event.entity
        val level = player.level
        if (level.isClientSide.not()) {
            if (event.advancement.id.path.startsWith("recipes")) {
                val increaseRadius = MCConfig.ExtendWorldBorder.radiusIncreasedPerRecipe.get()
                if (increaseRadius != 0.0) {
                    val worldBorder = level.worldBorder
                    val size = min(worldBorder.size + increaseRadius * 2, 6.0E7)
                    val delay = MCConfig.ExtendWorldBorder.increaseWorldBorderDelay.get()
                    worldBorder.lerpSizeBetween(worldBorder.size, size, delay)
                    level.players().forEach { player1 ->

                        val recipes = event.advancement.rewards.serializeToJson().asJsonObject.get("recipes").asJsonArray.joinToString(", ", "[", "]") { it.asString }
                        player1.sendSystemMessage(Component.translatable("event.advancement.worldborder.recipes", player.displayName.string, recipes, worldBorder.size / 2.0, size / 2.0, delay))
                    }
                }
            } else {
                val increaseRadius = MCConfig.ExtendWorldBorder.radiusIncreasedPerAdvancement.get()
                if (increaseRadius != 0.0) {
                    val worldBorder = level.worldBorder
                    val size = min(worldBorder.size + increaseRadius * 2, 6.0E7)
                    val delay = MCConfig.ExtendWorldBorder.increaseWorldBorderDelay.get()
                    worldBorder.lerpSizeBetween(worldBorder.size, size, delay)
                    level.players().forEach { player1 ->
                        player1.sendSystemMessage(Component.translatable("event.advancement.worldborder.normal", worldBorder.size / 2.0, size / 2.0, delay))
                    }
                }
            }
        }
    }


}