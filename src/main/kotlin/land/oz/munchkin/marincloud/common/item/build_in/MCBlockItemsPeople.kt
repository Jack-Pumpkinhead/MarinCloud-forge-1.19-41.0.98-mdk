package land.oz.munchkin.marincloud.common.item.build_in

import land.oz.munchkin.marincloud.MCRegistry
import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.block.build_in.BlockNames
import land.oz.munchkin.marincloud.common.block.build_in.MCBlocksPeople
import land.oz.munchkin.marincloud.common.item.MCBlockItem
import land.oz.munchkin.marincloud.common.item.creative_tab.MCTabPeople
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

/**
 * Created by CowardlyLion at 2022/7/16 17:33
 */
object MCBlockItemsPeople : MCRegistry<Item> {

    override val deferredRegister = DeferredRegister.create(ForgeRegistries.ITEMS, MarinCloud.ID)

    
    val Creamily_231 = (BlockNames.Creamily_231).register { MCBlockItem(MCBlocksPeople.Creamily_231.get(), Item.Properties().tab(MCTabPeople)) }
    val skymc7 = (BlockNames.skymc7).register { MCBlockItem(MCBlocksPeople.skymc7.get(), Item.Properties().tab(MCTabPeople)) }
    val abc = (BlockNames.abc).register { MCBlockItem(MCBlocksPeople.abc.get(), Item.Properties().tab(MCTabPeople)) }
    val DOYO = (BlockNames.DOYO).register { MCBlockItem(MCBlocksPeople.DOYO.get(), Item.Properties().tab(MCTabPeople)) }
    val HOND330 = (BlockNames.HOND330).register { MCBlockItem(MCBlocksPeople.HOND330.get(), Item.Properties().tab(MCTabPeople)) }
    val yuking = (BlockNames.yuking).register { MCBlockItem(MCBlocksPeople.yuking.get(), Item.Properties().tab(MCTabPeople)) }

}