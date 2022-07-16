package land.oz.munchkin.marincloud.common.item.build_in

import land.oz.munchkin.marincloud.MCRegistry
import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.item.creative_tab.MCTabMain
import land.oz.munchkin.marincloud.common.item.*
import land.oz.munchkin.marincloud.common.item.property.food1
import land.oz.munchkin.marincloud.common.item.property.food2
import net.minecraft.world.item.Item
import net.minecraft.world.item.Tiers
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

/**
 * Created by CowardlyLion at 2021/6/22 21:53
 *
 * 新建物品：
 *      MCItems
 *      models/item
 *      textures/items
 *      lang/
 *
 */
object MCItems : MCRegistry<Item> {

    override val deferredRegister = DeferredRegister.create(ForgeRegistries.ITEMS, MarinCloud.ID)

    val pvz_Sun = (ItemNames.pvz_Sun).register { MCItem(Item.Properties().tab(MCTabMain)) }
    val pvz_sunflower = (ItemNames.pvz_sunflower).register { MCItemSunFlower(Item.Properties().tab(MCTabMain).food(food1)) }
    val pvz_TwinSunflower = (ItemNames.pvz_TwinSunflower).register { MCItemSunFlower(Item.Properties().tab(MCTabMain).food(food2)) }

    val crazy_dave_pvz_1 = (ItemNames.crazy_dave_pvz_1).register { MCItemCrazyDave(floatArrayOf(1F, 0F, 0F), Item.Properties().tab(MCTabMain)) }
    val crazy_dave_pvz_2 = (ItemNames.crazy_dave_pvz_2).register { MCItemCrazyDave(floatArrayOf(0F, 1F, 0F), Item.Properties().tab(MCTabMain)) }
    val crazy_dave_pvz_3 = (ItemNames.crazy_dave_pvz_3).register { MCItemCrazyDave(floatArrayOf(0F, 0F, 1F), Item.Properties().tab(MCTabMain)) }


    val pvz_Diamond = (ItemNames.pvz_Diamond).register { MCItemDiamond(Item.Properties().tab(MCTabMain)) }
    val diamond_blue = (ItemNames.diamond_blue).register { MCItemDiamond(Item.Properties().tab(MCTabMain)) }
    val diamond_green = (ItemNames.diamond_green).register { MCItemDiamond(Item.Properties().tab(MCTabMain)) }
    val diamond_pink = (ItemNames.diamond_pink).register { MCItemDiamond(Item.Properties().tab(MCTabMain)) }
    val diamond_purple = (ItemNames.diamond_purple).register { MCItemDiamond(Item.Properties().tab(MCTabMain)) }
    val diamond_red = (ItemNames.diamond_red).register { MCItemDiamond(Item.Properties().tab(MCTabMain)) }

    val brush_1 = (ItemNames.brush_1).register { MCItemBrush(Item.Properties().tab(MCTabMain), 0.5F) }
    val brush_2 = (ItemNames.brush_2).register { MCItemBrush(Item.Properties().tab(MCTabMain), 1.1F) }
    val brush_3 = (ItemNames.brush_3).register { MCItemBrush(Item.Properties().tab(MCTabMain), 1.9F) }
    val brush_4 = (ItemNames.brush_4).register { MCItemBrush(Item.Properties().tab(MCTabMain), 3.1F) }

    val crystal_big = (ItemNames.crystal_big).register { MCItemSword(Tiers.DIAMOND, 10, -2.4F, Item.Properties().tab(MCTabMain)) }

}