package land.oz.munchkin.marincloud.common.item.build_in

import land.oz.munchkin.marincloud.MCRegistry
import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.block.build_in.BlockNames
import land.oz.munchkin.marincloud.common.block.build_in.MCBlocks
import land.oz.munchkin.marincloud.common.item.creative_tab.MCTabBlock
import land.oz.munchkin.marincloud.common.item.MCBlockItem
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

/**
 * Created by CowardlyLion at 2021/6/23 13:45
 */
object MCBlockItems : MCRegistry<Item> {

    override val deferredRegister = DeferredRegister.create(ForgeRegistries.ITEMS, MarinCloud.ID)


    val suwako = (BlockNames.Suwako).register { MCBlockItem(MCBlocks.wkfg.get(), Item.Properties().tab(MCTabBlock)) }
    val Koishi_0 = (BlockNames.Koishi_0).register { MCBlockItem(MCBlocks.Koishi_0.get(), Item.Properties().tab(MCTabBlock)) }
    val Koishi_1 = (BlockNames.Koishi_1).register { MCBlockItem(MCBlocks.Koishi_1.get(), Item.Properties().tab(MCTabBlock)) }

    val sistine_fibel = (BlockNames.sistine_fibel).register { MCBlockItem(MCBlocks.sistine_fibel.get(), Item.Properties().tab(MCTabBlock)) }
    val Diana = (BlockNames.Diana).register { MCBlockItem(MCBlocks.Diana.get(), Item.Properties().tab(MCTabBlock)) }
    val v50 = (BlockNames.v50).register { MCBlockItem(MCBlocks.v50.get(), Item.Properties().tab(MCTabBlock)) }
    val greatest_works_of_art = (BlockNames.greatest_works_of_art).register { MCBlockItem(MCBlocks.greatest_works_of_art.get(), Item.Properties().tab(MCTabBlock)) }
    val southern_ring_nebula = (BlockNames.southern_ring_nebula).register { MCBlockItem(MCBlocks.southern_ring_nebula.get(), Item.Properties().tab(MCTabBlock)) }
    val rick_astley = (BlockNames.rick_astley).register { MCBlockItem(MCBlocks.rick_astley.get(), Item.Properties().tab(MCTabBlock)) }

    val cake_blue = (BlockNames.cake_blue).register { MCBlockItem(MCBlocks.cake_blue.get(), Item.Properties().tab(MCTabBlock)) }

}