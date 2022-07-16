package land.oz.munchkin.marincloud.client.screen

import com.mojang.blaze3d.vertex.PoseStack
import land.oz.munchkin.marincloud.client.config.MCGUIConfig
import land.oz.munchkin.marincloud.util.clampedRandomChange
import land.oz.munchkin.marincloud.util.color.ARGBMutable
import net.minecraft.client.Minecraft
import net.minecraft.client.OptionInstance
import net.minecraft.client.gui.components.Button
import net.minecraft.client.gui.components.OptionsList
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component
import net.minecraftforge.client.ConfigScreenHandler
import net.minecraftforge.fml.ModLoadingContext
import kotlin.random.Random

/**
 * Created by CowardlyLion at 2021/12/11 0:04
 */
class MCConfigScreen(minecraft: Minecraft, val parent: Screen?) : Screen(Component.translatable("config.screen.title")) {

    init {
        this.minecraft = minecraft
    }

    companion object {

        fun registerExtensionPoint() {
            ModLoadingContext.get().registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory::class.java
            ) {
                ConfigScreenHandler.ConfigScreenFactory { minecraft, screen ->
                    MCConfigScreen(minecraft, screen)
                }
            }
        }
    }

    lateinit var optionsList: OptionsList
    lateinit var toggleWorldBorderIndicatorOption: OptionInstance<Boolean>
    lateinit var button: Button

    override fun init() {
        val topOffset = 24
        val bottomOffset = height - 32
        val itemHeight = 25
        optionsList = OptionsList(minecraft!!, width, height, topOffset, bottomOffset, itemHeight)
        addWidget(optionsList)
        toggleWorldBorderIndicatorOption = OptionInstance.createBoolean(
            "config.screen.worldborder_indicator.toggle",
            OptionInstance.cachedConstantTooltip(Component.translatable("config.screen.worldborder_indicator.toggle.tooltip")),
            MCGUIConfig.worldBorderIndicatorEnabled   //initial value
        ) {
            MCGUIConfig.worldBorderIndicatorEnabled = it
        }
        optionsList.addBig(toggleWorldBorderIndicatorOption)

        val buttonWidth = 200
        val buttonHeight = 20
        val buttonTopOffset = 26
        button = Button(
            (width - buttonWidth) / 2,
            height - buttonTopOffset,
            buttonWidth,
            buttonHeight,
            Component.translatable("config.screen.done")
        ) { button ->
            onClose()
        }
        addWidget(button)
    }

    var color = ARGBMutable(255.0, 255.0, 255.0, 255.0)

    override fun render(pStack: PoseStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        renderBackground(pStack)
        optionsList.render(pStack, mouseX, mouseY, partialTicks)
        color.clampedRandomChange(Random)
        drawCenteredString(pStack, font, title, width / 2, 8, color.toInt())
        button.render(pStack, mouseX, mouseY, partialTicks)
        super.render(pStack, mouseX, mouseY, partialTicks)
    }

    override fun onClose() {
        MCGUIConfig.saveConfig()
        if (parent != null) {
            minecraft!!.setScreen(parent)
        } else {
            super.onClose()
        }
    }
}