package land.oz.munchkin.marincloud.common.item

import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.HitResult

/**
 * Created by CowardlyLion at 2021/6/23 18:49
 */
class MCItemBrush(properties: Properties, val radius: Float) : MCItem(properties) {

    fun handleBrushUsing(player: Player, offhandItem: ItemStack) {
        val blockItem = offhandItem.item
        if (blockItem is BlockItem && offhandItem.isEmpty.not()) {
            val pick = player.pick(100.0, 0F, false)
            if (pick.type == HitResult.Type.BLOCK && pick is BlockHitResult) {
                if (radius < 0.9F) {
                    val blockstate = player.level.getBlockState(pick.blockPos)
                    if (blockstate.block != blockItem.block) {
                        if (player.isCreative.not()) {
                            offhandItem.shrink(1)
                        }
                        player.level.setBlock(pick.blockPos, blockItem.block.defaultBlockState(), 2)
                    }
                } else {
                    val r = radius.toInt()
                    for (i in -r..r) {
                        for (j in -r..r) {
                            for (k in -r..r) {
                                if (i * i + j * j + k * k < radius * radius) {
                                    val pos = pick.blockPos.offset(i, j, k)
                                    val blockstate = player.level.getBlockState(pos)
                                    if (blockstate.isAir.not() && blockstate.block != blockItem.block) {
                                        player.level.setBlock(pos, blockItem.block.defaultBlockState(), 2)
                                        if (player.isCreative.not()) {
                                            offhandItem.shrink(1)
                                            if (offhandItem.isEmpty) return
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


}