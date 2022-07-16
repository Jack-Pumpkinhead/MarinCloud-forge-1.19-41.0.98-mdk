package land.oz.munchkin.marincloud.util

import net.minecraft.core.Direction

/**
 * Created by CowardlyLion at 2021/6/23 13:55
 */
fun resolveDirection2D(player: Direction, dir: Direction): String {
    var result = 0
    var p = player
    while (p != dir) {
        p = p.clockWise
        result++
        if (result > 3) {
            error("wrong direction: $player, $dir")
        }
    }
    return when (result) {
        0    -> "↑"
        1    -> "→"
        2    -> "↓"
        3    -> "←"
        else -> error("wrong direction: $player, $dir")
    }
}

