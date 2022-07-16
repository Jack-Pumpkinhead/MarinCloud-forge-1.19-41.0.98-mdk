package land.oz.munchkin.marincloud.common.item.build_in

import land.oz.munchkin.marincloud.MCRegistry
import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.item.MCItemArmor
import land.oz.munchkin.marincloud.common.item.creative_tab.MCTabArmor
import land.oz.munchkin.marincloud.common.item.material.MCArmorMaterials
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

/**
 * Created by CowardlyLion at 2022/7/15 21:54
 */
object MCItemsArmor : MCRegistry<Item> {

    override val deferredRegister = DeferredRegister.create(ForgeRegistries.ITEMS, MarinCloud.ID)

    val helmet_1 = (ItemNamesArmor.helmet_1).register { MCItemArmor(MCArmorMaterials.armor1, EquipmentSlot.HEAD, Item.Properties().tab(MCTabArmor)) }
    val helmet_2 = (ItemNamesArmor.helmet_2).register { MCItemArmor(MCArmorMaterials.armor2, EquipmentSlot.HEAD, Item.Properties().tab(MCTabArmor)) }
    val helmet_3 = (ItemNamesArmor.helmet_3).register { MCItemArmor(MCArmorMaterials.armor3, EquipmentSlot.HEAD, Item.Properties().tab(MCTabArmor)) }
    val helmet_4 = (ItemNamesArmor.helmet_4).register { MCItemArmor(MCArmorMaterials.armor4, EquipmentSlot.HEAD, Item.Properties().tab(MCTabArmor)) }
    val helmet_5 = (ItemNamesArmor.helmet_5).register { MCItemArmor(MCArmorMaterials.armor5, EquipmentSlot.HEAD, Item.Properties().tab(MCTabArmor)) }
    val helmet_6 = (ItemNamesArmor.helmet_6).register { MCItemArmor(MCArmorMaterials.armor6, EquipmentSlot.HEAD, Item.Properties().tab(MCTabArmor)) }
    val helmet_7 = (ItemNamesArmor.helmet_7).register { MCItemArmor(MCArmorMaterials.armor7, EquipmentSlot.HEAD, Item.Properties().tab(MCTabArmor)) }
    val helmet_8 = (ItemNamesArmor.helmet_8).register { MCItemArmor(MCArmorMaterials.armor8, EquipmentSlot.HEAD, Item.Properties().tab(MCTabArmor)) }
    val helmet_9 = (ItemNamesArmor.helmet_9).register { MCItemArmor(MCArmorMaterials.armor9, EquipmentSlot.HEAD, Item.Properties().tab(MCTabArmor)) }
    val chestplate_1 = (ItemNamesArmor.chestplate_1).register { MCItemArmor(MCArmorMaterials.armor1, EquipmentSlot.CHEST, Item.Properties().tab(MCTabArmor)) }
    val chestplate_2 = (ItemNamesArmor.chestplate_2).register { MCItemArmor(MCArmorMaterials.armor2, EquipmentSlot.CHEST, Item.Properties().tab(MCTabArmor)) }
    val chestplate_3 = (ItemNamesArmor.chestplate_3).register { MCItemArmor(MCArmorMaterials.armor3, EquipmentSlot.CHEST, Item.Properties().tab(MCTabArmor)) }
    val chestplate_4 = (ItemNamesArmor.chestplate_4).register { MCItemArmor(MCArmorMaterials.armor4, EquipmentSlot.CHEST, Item.Properties().tab(MCTabArmor)) }
    val chestplate_5 = (ItemNamesArmor.chestplate_5).register { MCItemArmor(MCArmorMaterials.armor5, EquipmentSlot.CHEST, Item.Properties().tab(MCTabArmor)) }
    val chestplate_6 = (ItemNamesArmor.chestplate_6).register { MCItemArmor(MCArmorMaterials.armor6, EquipmentSlot.CHEST, Item.Properties().tab(MCTabArmor)) }
    val chestplate_7 = (ItemNamesArmor.chestplate_7).register { MCItemArmor(MCArmorMaterials.armor7, EquipmentSlot.CHEST, Item.Properties().tab(MCTabArmor)) }
    val chestplate_8 = (ItemNamesArmor.chestplate_8).register { MCItemArmor(MCArmorMaterials.armor8, EquipmentSlot.CHEST, Item.Properties().tab(MCTabArmor)) }
    val chestplate_9 = (ItemNamesArmor.chestplate_9).register { MCItemArmor(MCArmorMaterials.armor9, EquipmentSlot.CHEST, Item.Properties().tab(MCTabArmor)) }
    val leggings_1 = (ItemNamesArmor.leggings_1).register { MCItemArmor(MCArmorMaterials.armor1, EquipmentSlot.LEGS, Item.Properties().tab(MCTabArmor)) }
    val leggings_2 = (ItemNamesArmor.leggings_2).register { MCItemArmor(MCArmorMaterials.armor2, EquipmentSlot.LEGS, Item.Properties().tab(MCTabArmor)) }
    val leggings_3 = (ItemNamesArmor.leggings_3).register { MCItemArmor(MCArmorMaterials.armor3, EquipmentSlot.LEGS, Item.Properties().tab(MCTabArmor)) }
    val leggings_4 = (ItemNamesArmor.leggings_4).register { MCItemArmor(MCArmorMaterials.armor4, EquipmentSlot.LEGS, Item.Properties().tab(MCTabArmor)) }
    val leggings_5 = (ItemNamesArmor.leggings_5).register { MCItemArmor(MCArmorMaterials.armor5, EquipmentSlot.LEGS, Item.Properties().tab(MCTabArmor)) }
    val leggings_6 = (ItemNamesArmor.leggings_6).register { MCItemArmor(MCArmorMaterials.armor6, EquipmentSlot.LEGS, Item.Properties().tab(MCTabArmor)) }
    val leggings_7 = (ItemNamesArmor.leggings_7).register { MCItemArmor(MCArmorMaterials.armor7, EquipmentSlot.LEGS, Item.Properties().tab(MCTabArmor)) }
    val leggings_8 = (ItemNamesArmor.leggings_8).register { MCItemArmor(MCArmorMaterials.armor8, EquipmentSlot.LEGS, Item.Properties().tab(MCTabArmor)) }
    val leggings_9 = (ItemNamesArmor.leggings_9).register { MCItemArmor(MCArmorMaterials.armor9, EquipmentSlot.LEGS, Item.Properties().tab(MCTabArmor)) }
    val boots_1 = (ItemNamesArmor.boots_1).register { MCItemArmor(MCArmorMaterials.armor1, EquipmentSlot.FEET, Item.Properties().tab(MCTabArmor)) }
    val boots_2 = (ItemNamesArmor.boots_2).register { MCItemArmor(MCArmorMaterials.armor2, EquipmentSlot.FEET, Item.Properties().tab(MCTabArmor)) }
    val boots_3 = (ItemNamesArmor.boots_3).register { MCItemArmor(MCArmorMaterials.armor3, EquipmentSlot.FEET, Item.Properties().tab(MCTabArmor)) }
    val boots_4 = (ItemNamesArmor.boots_4).register { MCItemArmor(MCArmorMaterials.armor4, EquipmentSlot.FEET, Item.Properties().tab(MCTabArmor)) }
    val boots_5 = (ItemNamesArmor.boots_5).register { MCItemArmor(MCArmorMaterials.armor5, EquipmentSlot.FEET, Item.Properties().tab(MCTabArmor)) }
    val boots_6 = (ItemNamesArmor.boots_6).register { MCItemArmor(MCArmorMaterials.armor6, EquipmentSlot.FEET, Item.Properties().tab(MCTabArmor)) }
    val boots_7 = (ItemNamesArmor.boots_7).register { MCItemArmor(MCArmorMaterials.armor7, EquipmentSlot.FEET, Item.Properties().tab(MCTabArmor)) }
    val boots_8 = (ItemNamesArmor.boots_8).register { MCItemArmor(MCArmorMaterials.armor8, EquipmentSlot.FEET, Item.Properties().tab(MCTabArmor)) }
    val boots_9 = (ItemNamesArmor.boots_9).register { MCItemArmor(MCArmorMaterials.armor9, EquipmentSlot.FEET, Item.Properties().tab(MCTabArmor)) }


}