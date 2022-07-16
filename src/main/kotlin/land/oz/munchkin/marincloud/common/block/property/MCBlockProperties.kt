package land.oz.munchkin.marincloud.common.block.property

import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material

/**
 * Created by CowardlyLion at 2021/6/23 13:28
 */
object MCBlockProperties {

    val lightGlass = BlockBehaviour.Properties
        .of(Material.GLASS)
        .strength(0.3F)
        .sound(SoundType.GLASS)
        .noOcclusion()
        .lightLevel { 7 }
        .isValidSpawn { _, _, _, _ -> false }
        .isRedstoneConductor { _, _, _ -> false }
        .isSuffocating { _, _, _ -> false }
        .isViewBlocking { _, _, _ -> false }


}