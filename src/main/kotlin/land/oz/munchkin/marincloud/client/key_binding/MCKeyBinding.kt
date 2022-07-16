package land.oz.munchkin.marincloud.client.key_binding

import land.oz.munchkin.marincloud.client.screen.MCConfigScreen
import net.minecraft.client.Minecraft
import net.minecraftforge.client.event.InputEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import org.lwjgl.glfw.GLFW

/**
 * Created by CowardlyLion at 2021/12/11 16:02
 */
object MCKeyBinding {

    @SubscribeEvent
    fun onKeyInput(event: InputEvent.Key) {
        val minecraft = Minecraft.getInstance()
        if (minecraft.screen == null) {
            if (event.key == GLFW.GLFW_KEY_9 && event.modifiers and GLFW.GLFW_MOD_CONTROL != 0) {
                minecraft.setScreen(MCConfigScreen(minecraft, null))
            }
        }
    }

}