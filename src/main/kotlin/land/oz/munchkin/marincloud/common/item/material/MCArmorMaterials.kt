package land.oz.munchkin.marincloud.common.item.material

import land.oz.munchkin.marincloud.path
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Ingredient

/**
 * Created by CowardlyLion at 2022/7/15 22:04
 */
object MCArmorMaterials {

    fun defaultArmor(name: String) = MCArmorMaterial(
        name_ = path(name),
        healthPerSlot = intArrayOf(13, 15, 16, 11),
        durabilityMultiplier = 33,
        slotProtections = intArrayOf(3, 6, 8, 3),
        enchantmentValue_ = 10,
        sound = SoundEvents.ARMOR_EQUIP_DIAMOND,
        toughness_ = 2.0f,
        knockbackResistance_ = 0.0f,
        repairIngredient_ = Ingredient.of(Items.DIAMOND)
    )

    val armor1 = defaultArmor("armor1")
    val armor2 = defaultArmor("armor2")
    val armor3 = defaultArmor("armor3")
    val armor4 = defaultArmor("armor4")
    val armor5 = defaultArmor("armor5")
    val armor6 = defaultArmor("armor6")
    val armor7 = defaultArmor("armor7")
    val armor8 = defaultArmor("armor8")
    val armor9 = defaultArmor("armor9")



}