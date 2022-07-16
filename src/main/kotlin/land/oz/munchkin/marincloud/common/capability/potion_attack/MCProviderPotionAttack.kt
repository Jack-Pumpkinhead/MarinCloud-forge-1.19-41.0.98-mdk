package land.oz.munchkin.marincloud.common.capability.potion_attack

import net.minecraft.core.Direction
import net.minecraft.nbt.CompoundTag
import net.minecraft.nbt.ListTag
import net.minecraft.world.effect.MobEffectInstance
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityManager
import net.minecraftforge.common.capabilities.CapabilityToken
import net.minecraftforge.common.capabilities.ICapabilitySerializable
import net.minecraftforge.common.util.LazyOptional

/**
 * Created by CowardlyLion at 2021/9/10 10:51
 */
class MCProviderPotionAttack : ICapabilitySerializable<ListTag> {

    companion object {
        @JvmStatic
        val POTION_ATTACK_CAPABILITY: Capability<MCCapabilityPotionAttack> = CapabilityManager.get(object : CapabilityToken<MCCapabilityPotionAttack>() {})
    }

    val potionAttack: MCCapabilityPotionAttack = MCCapabilityPotionAttack()


    override fun <T : Any> getCapability(cap: Capability<T>, side: Direction?): LazyOptional<T> {
        return if (cap == POTION_ATTACK_CAPABILITY) {
            LazyOptional.of { potionAttack as T }
        } else LazyOptional.empty()
    }

    override fun serializeNBT(): ListTag {
        val listNBT = ListTag()
        for (effect in potionAttack.effects) {
            val effectNBT = effect.effectInstance.save(CompoundTag())
            effectNBT.putFloat("Radius", effect.radius)
            effectNBT.putFloat("Chance", effect.chance)
            effectNBT.putInt("MaxEntity", effect.maxEntity)
            listNBT.add(effectNBT)
        }
        return listNBT
    }

    override fun deserializeNBT(nbt: ListTag) {
        potionAttack.effects.clear()
        nbt.forEach { effectNBT ->
            potionAttack.effects += EffectPotionAttack(MobEffectInstance.load(effectNBT as CompoundTag)!!, effectNBT.getFloat("Radius"), effectNBT.getFloat("Chance"), effectNBT.getInt("MaxEntity"))
        }
    }

}