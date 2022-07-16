package land.oz.munchkin.marincloud.common.block.state

import net.minecraft.core.Direction
import net.minecraft.world.level.block.state.properties.DirectionProperty

/**
 * Created by CowardlyLion at 2022/7/15 22:26
 */
object MCBlockStates {

    val facing = DirectionProperty.create("facing", *Direction.values())

}