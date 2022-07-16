package land.oz.munchkin.marincloud.common.block.build_in

import land.oz.munchkin.marincloud.MCRegistry
import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.block.MCBlockCake
import land.oz.munchkin.marincloud.common.block.MCBlockDirectional
import land.oz.munchkin.marincloud.common.block.property.MCBlockProperties.lightGlass
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.Material
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

/**
 * Created by CowardlyLion at 2021/6/22 21:08
 * 新建方块：
 *   MCBlocks
 *   MCBlockItems
 *   assets/./blockstates/
 *   assets/./models/block/
 *   assets/./models/item/
 *   --assets/./textures/items/
 *   assets/./textures/blocks/
 *   lang
 *
 */
object MCBlocks : MCRegistry<Block> {

    override val deferredRegister = DeferredRegister.create(ForgeRegistries.BLOCKS, MarinCloud.ID)


    val wkfg = (BlockNames.Suwako).register { MCBlockDirectional(lightGlass) }
    val Koishi_0 = (BlockNames.Koishi_0).register { MCBlockDirectional(lightGlass) }
    val Koishi_1 = (BlockNames.Koishi_1).register { MCBlockDirectional(lightGlass) }

    val sistine_fibel = BlockNames.sistine_fibel.register { MCBlockDirectional(lightGlass) }
    val Diana = BlockNames.Diana.register { MCBlockDirectional(lightGlass) }
    val v50 = BlockNames.v50.register { MCBlockDirectional(lightGlass) }
    val greatest_works_of_art = BlockNames.greatest_works_of_art.register { MCBlockDirectional(lightGlass) }
    val southern_ring_nebula = BlockNames.southern_ring_nebula.register { MCBlockDirectional(lightGlass) }
    val rick_astley = BlockNames.rick_astley.register { MCBlockDirectional(lightGlass) }

    val cake_blue = BlockNames.cake_blue.register { MCBlockCake(BlockBehaviour.Properties.of(Material.CAKE).strength(0.5F).sound(SoundType.WOOL)) }

}