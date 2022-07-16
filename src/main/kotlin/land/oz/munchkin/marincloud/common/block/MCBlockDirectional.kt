package land.oz.munchkin.marincloud.common.block

import land.oz.munchkin.marincloud.common.block.state.MCBlockStates.facing
import net.minecraft.core.Direction
import net.minecraft.world.item.context.BlockPlaceContext
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.block.state.StateDefinition

/**
 * Created by CowardlyLion at 2021/6/22 20:00
 */
class MCBlockDirectional(properties: Properties) : MCBlock(properties) {

    init {
        registerDefaultState(
            getStateDefinition().any()
                .setValue(facing, Direction.NORTH)
        )
    }

    override fun createBlockStateDefinition(builder: StateDefinition.Builder<Block, BlockState>) {
        builder.add(facing)
    }

    override fun getStateForPlacement(context: BlockPlaceContext): BlockState? {
        return defaultBlockState().setValue(facing, context.nearestLookingDirection.opposite)
    }

}