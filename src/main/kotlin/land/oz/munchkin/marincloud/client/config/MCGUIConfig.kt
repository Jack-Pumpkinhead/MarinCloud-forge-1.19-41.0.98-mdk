package land.oz.munchkin.marincloud.client.config

import land.oz.munchkin.marincloud.config.MCConfig

/**
 * Created by CowardlyLion at 2021/12/11 17:01
 */
object MCGUIConfig {

    @Volatile
    var worldBorderIndicatorEnabled: Boolean = false

    fun reloadConfig() {
        worldBorderIndicatorEnabled = MCConfig.DisplayWorldBorder.enabled.get()
    }

    fun saveConfig() {
        MCConfig.DisplayWorldBorder.enabled.set(worldBorderIndicatorEnabled)
        MCConfig.DisplayWorldBorder.enabled.save()
    }

}