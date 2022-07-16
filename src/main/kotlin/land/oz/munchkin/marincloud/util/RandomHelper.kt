package land.oz.munchkin.marincloud.util

import land.oz.munchkin.marincloud.util.color.ARGBMutable
import net.minecraft.util.RandomSource
import kotlin.random.Random

/**
 * Created by CowardlyLion at 2022/7/15 20:38
 */
fun Random.randomPitch(): Float {
    return (nextFloat() - nextFloat()) * 0.2f + 1.0f
}

fun Random.rollCoin(probability: Float): Boolean {
    return nextFloat() < probability
}

fun <T> Random.randomizeEvent(weight1: Float, weight2: Float, function1: () -> T, function2: () -> T): T {
    return randomizeEvents(floatArrayOf(weight1, weight2), function1, function2)
}

fun <T> Random.randomizeEvents(weights: FloatArray, vararg functions: () -> T): T {
    val value = nextFloat() * weights.sum()
    var sum = 0F
    for ((i, w) in weights.withIndex()) {
        if (w != 0F) {
            sum += w
            if (sum >= value) {
                return functions[i]()
            }
        }
    }
    return functions.last()()
}

fun ARGBMutable.clampedRandomChange(random: Random) {
    a = (a + random.nextDouble(-3.0, 3.0)).coerceIn(0.0, 255.0)
    r = (r + random.nextDouble(-3.0, 3.0)).coerceIn(0.0, 255.0)
    g = (g + random.nextDouble(-3.0, 3.0)).coerceIn(0.0, 255.0)
    b = (b + random.nextDouble(-3.0, 3.0)).coerceIn(0.0, 255.0)
}

fun RandomSource.rollCoin(probability: Float): Boolean {
    return nextFloat() < probability
}

fun <T> RandomSource.randomizeEvent(weight1: Float, weight2: Float, function1: () -> T, function2: () -> T): T {
    return randomizeEvents(floatArrayOf(weight1, weight2), function1, function2)
}

fun <T> RandomSource.randomizeEvents(weights: FloatArray, vararg functions: () -> T): T {
    val value = nextFloat() * weights.sum()
    var sum = 0F
    for ((i, w) in weights.withIndex()) {
        if (w != 0F) {
            sum += w
            if (sum >= value) {
                return functions[i]()
            }
        }
    }
    return functions.last()()
}

fun RandomSource.randomPitch(): Float {
    return (nextFloat() - nextFloat()) * 0.2f + 1.0f
}