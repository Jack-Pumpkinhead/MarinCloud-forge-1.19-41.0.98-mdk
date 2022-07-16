package land.oz.munchkin.marincloud.config

import net.minecraftforge.common.ForgeConfigSpec

/**
 * Created by CowardlyLion at 2021/9/14 10:51
 */
object MCConfig {

    val builder = ForgeConfigSpec.Builder()
    val spec: ForgeConfigSpec

    object ExtendWorldBorder {

        val enabled: ForgeConfigSpec.ConfigValue<Boolean>
        val radiusIncreasedPerAdvancement: ForgeConfigSpec.ConfigValue<Double>
        val radiusIncreasedPerRecipe: ForgeConfigSpec.ConfigValue<Double>
        val increaseWorldBorderDelay: ForgeConfigSpec.ConfigValue<Long>

        init {
            builder.push("ExtendWorldBorder")
            enabled = builder.define("enabled", false)
            radiusIncreasedPerAdvancement = builder.comment("Determine size of radius to extended when player got a (non-recipe) advancement").define("radiusIncreasedPerAdvancement", 1.0)
            radiusIncreasedPerRecipe = builder.comment("Determine size of radius to extended when player unlocked a recipe").define("radiusIncreasedPerRecipe", 0.1)
            increaseWorldBorderDelay = builder.comment("Time consumption to extend world border in milliseconds").define("increaseWorldBorderDelay", 2000L)
            builder.pop()
        }
    }

    object DisplayWorldBorder {
        val enabled: ForgeConfigSpec.ConfigValue<Boolean>
        val relativeWidth: ForgeConfigSpec.ConfigValue<Double>
        val relativeHeight: ForgeConfigSpec.ConfigValue<Double>
        val scale: ForgeConfigSpec.ConfigValue<Double>
        val urgentColor: ForgeConfigSpec.ConfigValue<Long>
        val middleColor: ForgeConfigSpec.ConfigValue<Long>
        val peaceColor: ForgeConfigSpec.ConfigValue<Long>
        val middleDistance: ForgeConfigSpec.ConfigValue<Double>
        val peaceDistanceMultiple: ForgeConfigSpec.ConfigValue<Double>

        init {
            builder.push("DisplayWorldBorder")
            enabled = builder.define("enabled", false)
            relativeWidth = builder.comment("relative position on screen 0.0~1.0").define("relativeWidth", 0.8)
            relativeHeight = builder.comment("relative position on screen 0.0~1.0").define("relativeHeight", 0.7)
            scale = builder.comment("text size").define("scale", 1.8)
            urgentColor = builder.comment("color when close to world border (ARGB)").define("urgentColor", 0xFFFF0000)
            middleColor = builder.comment("color when distance from world border in between (ARGB)").define("middleColor", 0xFF0000FF)
            peaceColor = builder.comment("color when distant from world border (ARGB)").define("peaceColor", 0xFF00FF00)
            middleDistance = builder.comment("distance when display middle color").define("middleDistance", 100.0)
            peaceDistanceMultiple = builder.comment("multiple of 'middleDistance' when display peace color").define("peaceDistanceMultiple", 10.0)
            builder.pop()
        }
    }

    init {
        ExtendWorldBorder
        DisplayWorldBorder
        spec = builder.build()
    }

}