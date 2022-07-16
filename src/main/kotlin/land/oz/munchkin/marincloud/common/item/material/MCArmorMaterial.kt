package land.oz.munchkin.marincloud.common.item.material

import net.minecraft.sounds.SoundEvent
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.crafting.Ingredient

/**
 * Created by CowardlyLion at 2021/9/15 18:15
 */
class MCArmorMaterial(
    val name_: String,
    val healthPerSlot: IntArray,
    val durabilityMultiplier: Int,
    val slotProtections: IntArray,
    val enchantmentValue_: Int,
    val sound: SoundEvent,
    val toughness_: Float,
    val knockbackResistance_: Float,
    val repairIngredient_: Ingredient
) : ArmorMaterial {

    override fun getDurabilityForSlot(slot: EquipmentSlot): Int {
        return healthPerSlot[slot.index] * this.durabilityMultiplier
    }

    override fun getDefenseForSlot(slot: EquipmentSlot): Int {
        return slotProtections[slot.index]
    }

    override fun getEnchantmentValue(): Int {
        return this.enchantmentValue_
    }

    override fun getEquipSound(): SoundEvent {
        return sound
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient_
    }

    override fun getName(): String {
        return this.name_
    }

    override fun getToughness(): Float {
        return this.toughness_
    }

    override fun getKnockbackResistance(): Float {
        return this.knockbackResistance_
    }

}