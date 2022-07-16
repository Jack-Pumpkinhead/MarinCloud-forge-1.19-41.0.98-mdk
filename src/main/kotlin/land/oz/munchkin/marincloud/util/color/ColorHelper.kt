package land.oz.munchkin.marincloud.util.color

/**
 * Created by CowardlyLion at 2022/7/15 20:41
 */
fun toARGB(x: Long): IARGB {
    if (x <= 0) return ARGBImpl(0.0, 0.0, 0.0, 0.0)
    var y = x
    val b = y and 255
    y = y.shr(8)
    val g = y and 255
    y = y.shr(8)
    val r = y and 255
    y = y.shr(8)
    val a = y and 255
    return ARGBImpl(a.toDouble(), r.toDouble(), g.toDouble(), b.toDouble())
}

fun interpolateColor(min: Double, max: Double, a: Double, minColor: IARGB, maxColor: IARGB): IARGB {
    return if (a <= min) {
        minColor
    } else if (a >= max) {
        maxColor
    } else {
        minColor + ((maxColor - minColor) * ((a - min) / (max - min)))
    }
}

fun clampToIntColor(a: Double): Int {
    val x = a.toInt()
    return if (x <= 0) 0
    else if (x > 255) 255
    else x
}