package land.oz.munchkin.marincloud.util.color

import net.minecraft.util.FastColor

/**
 * Created by CowardlyLion at 2022/7/15 20:36
 */
interface IARGB {

    val a: Double
    val r: Double
    val g: Double
    val b: Double

    fun toInt(): Int = FastColor.ARGB32.color(clampToIntColor(a), clampToIntColor(r), clampToIntColor(g), clampToIntColor(b))

    operator fun plus(x: IARGB): IARGB = ARGBImpl(a + x.a, r + x.r, g + x.g, b + x.b)
    operator fun minus(x: IARGB): IARGB = ARGBImpl(a - x.a, r - x.r, g - x.g, b - x.b)
    operator fun times(x: Double): IARGB = ARGBImpl(a * x, r * x, g * x, b * x)

}