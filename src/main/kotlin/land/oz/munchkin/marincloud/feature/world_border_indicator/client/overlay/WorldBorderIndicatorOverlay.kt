package land.oz.munchkin.marincloud.feature.world_border_indicator.client.overlay

import com.mojang.blaze3d.systems.RenderSystem
import com.mojang.blaze3d.vertex.PoseStack
import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.client.config.MCGUIConfig
import land.oz.munchkin.marincloud.config.MCConfig
import land.oz.munchkin.marincloud.util.color.interpolateColor
import land.oz.munchkin.marincloud.util.color.toARGB
import land.oz.munchkin.marincloud.util.resolveDirection2D
import net.minecraft.core.Direction
import net.minecraft.network.chat.Component
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent
import net.minecraftforge.client.gui.overlay.ForgeGui
import net.minecraftforge.eventbus.api.SubscribeEvent
import kotlin.math.ln

/**
 * Created by CowardlyLion at 2021/12/10 18:25
 */

object WorldBorderIndicatorOverlay {

    @SubscribeEvent
    fun onRegisterGuiOverlay(event: RegisterGuiOverlaysEvent) {
        event.registerAboveAll("world_border_indicator") { gui: ForgeGui, pStack: PoseStack, partialTicks: Float, screenWidth: Int, screenHeight: Int ->

            if (MCGUIConfig.worldBorderIndicatorEnabled) {
                val minecraft = gui.minecraft
                minecraft.profiler.push("WorldBorderIndicatorDisplay")
                pStack.pushPose()
                pStack.translate(screenWidth * MCConfig.DisplayWorldBorder.relativeWidth.get(), screenHeight * MCConfig.DisplayWorldBorder.relativeHeight.get(), 0.0)
                RenderSystem.enableBlend()
                RenderSystem.defaultBlendFunc()
                pStack.pushPose()
                val scale = MCConfig.DisplayWorldBorder.scale.get().toFloat()
                pStack.scale(scale, scale, scale)

                val player = minecraft.player
                if (player != null) {
                    val worldBorder = player.level.worldBorder
                    val distance: Double
                    val direction: Direction

                    val x1 = player.x - worldBorder.minX
                    val x2 = worldBorder.maxX - player.x
                    val z1 = player.z - worldBorder.minZ
                    val z2 = worldBorder.maxZ - player.z

                    if (x1 <= x2 && x1 <= z1 && x1 <= z2) {
                        distance = x1
                        direction = Direction.WEST
                    } else if (x2 <= z1 && x2 <= z2) {
                        distance = x2
                        direction = Direction.EAST
                    } else if (z1 <= z2) {
                        distance = z1
                        direction = Direction.NORTH
                    } else {
                        distance = z2
                        direction = Direction.SOUTH
                    }

                    val text = Component.translatable("overlay.text.worldborder.distance", distance.toInt())
                    val urgentColor = toARGB(MCConfig.DisplayWorldBorder.urgentColor.get())
                    val peaceColor = toARGB(MCConfig.DisplayWorldBorder.peaceColor.get())

                    val color = if (distance <= 0) {
                        urgentColor.toInt()
                    } else {
                        text.append(resolveDirection2D(player.direction, direction))

                        val middleDistance = MCConfig.DisplayWorldBorder.middleDistance.get().coerceAtLeast(0.0)
                        val middleColor = toARGB(MCConfig.DisplayWorldBorder.middleColor.get())
                        val multiple = MCConfig.DisplayWorldBorder.peaceDistanceMultiple.get().coerceAtLeast(1.0)

                        if (distance < middleDistance) {
                            interpolateColor(0.0, middleDistance, distance, urgentColor, middleColor).toInt()
                        } else if (distance >= distance * multiple) {
                            peaceColor.toInt()
                        } else {
                            val d0 = ln(middleDistance)
                            val d1 = ln(distance)
                            val d2 = ln(distance * multiple)
                            interpolateColor(d0, d2, d1, middleColor, peaceColor).toInt()
                        }
                    }
                    minecraft.font.drawShadow(pStack, text.visualOrderText, (-minecraft.font.width(text) / 2).toFloat(), -10.0f, color)

                    pStack.popPose()
                    RenderSystem.disableBlend()
                    pStack.popPose()
                    minecraft.profiler.pop()
                }
            }
        }
        MarinCloud.logger.info("${MarinCloud.NAME} RegisterGuiOverlays ok.")
    }

}
