package land.oz.munchkin.marincloud.common.item.build_in

import land.oz.munchkin.marincloud.MCRegistry
import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.item.MCItemAxe
import land.oz.munchkin.marincloud.common.item.MCItemPickaxe
import land.oz.munchkin.marincloud.common.item.MCItemShield
import land.oz.munchkin.marincloud.common.item.MCItemSword
import land.oz.munchkin.marincloud.common.item.creative_tab.MCTabWeapon
import net.minecraft.world.item.Item
import net.minecraft.world.item.Tiers
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

/**
 * Created by CowardlyLion at 2022/7/15 22:18
 */
object MCItemsWeapon : MCRegistry<Item> {

    override val deferredRegister = DeferredRegister.create(ForgeRegistries.ITEMS, MarinCloud.ID)

    val shield_1 = (ItemNamesWeapon.shield_1).register { MCItemShield(Item.Properties().durability(336).tab(MCTabWeapon)) }
    val shield_2 = (ItemNamesWeapon.shield_2).register { MCItemShield(Item.Properties().durability(336).tab(MCTabWeapon)) }
    val axe_1 = (ItemNamesWeapon.axe_1).register { MCItemAxe(Tiers.DIAMOND, 5.0F, -3.0F, Item.Properties().tab(MCTabWeapon)) }
    val axe_2 = (ItemNamesWeapon.axe_2).register { MCItemAxe(Tiers.DIAMOND, 5.0F, -3.0F, Item.Properties().tab(MCTabWeapon)) }

    val huge_sword = (ItemNamesWeapon.huge_sword).register { MCItemSword(Tiers.STONE, 15, -4.0F, Item.Properties().tab(MCTabWeapon)) }
    val huge_pickaxe = (ItemNamesWeapon.huge_pickaxe).register { MCItemPickaxe(Tiers.STONE, 15, -4.0F, Item.Properties().tab(MCTabWeapon)) }

}