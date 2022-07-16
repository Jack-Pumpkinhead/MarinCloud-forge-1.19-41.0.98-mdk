package land.oz.munchkin.marincloud.feature.unbreakable.common

import com.mojang.brigadier.exceptions.SimpleCommandExceptionType
import net.minecraft.commands.CommandSourceStack
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity

/**
 * Created by CowardlyLion at 2021/12/10 16:09
 */
object Unbreakable {

    val FAILED_Exception = SimpleCommandExceptionType(Component.translatable("commands.unbreakable.failed"))

    fun setUnbreakable(source: CommandSourceStack, entities: Collection<Entity>, bool: Boolean): Int {
        val successList = mutableListOf<LivingEntity>()
        entities.forEach { entity ->
            if (entity is LivingEntity) {
                val mainHandItem = entity.mainHandItem
                if (mainHandItem.isEmpty.not()) {
                    mainHandItem.getOrCreateTag().putBoolean("Unbreakable", bool)
                    successList += entity
                }
            }
        }
        if (successList.isEmpty()) {
            throw FAILED_Exception.create()
        } else {
            if (successList.size == 1) {
                source.sendSuccess(Component.translatable("commands.unbreakable.set.success.single", entities.first().displayName, bool), true)
            } else {
                source.sendSuccess(Component.translatable("commands.unbreakable.set.success.multiple", successList.size, bool), true)
            }
            return successList.size
        }
    }

    fun toggleUnbreakable(source: CommandSourceStack, entities: Collection<Entity>): Int {
        val successList = mutableListOf<LivingEntity>()
        var unbreakable = false
        entities.forEach { entity ->
            if (entity is LivingEntity) {
                val mainHandItem = entity.mainHandItem
                if (mainHandItem.isEmpty.not()) {
                    if (mainHandItem.hasTag().not() || mainHandItem.tag!!.contains("Unbreakable").not()) {
                        mainHandItem.getOrCreateTag().putBoolean("Unbreakable", true)
                    } else {
                        val tag = mainHandItem.getOrCreateTag()
                        tag.putBoolean("Unbreakable", tag.getBoolean("Unbreakable").not())
                    }
                    if (successList.isEmpty()) {
                        unbreakable = mainHandItem.getOrCreateTag().getBoolean("Unbreakable")
                    }
                    successList += entity
                }
            }
        }
        if (successList.isEmpty()) {
            throw FAILED_Exception.create()
        } else {
            if (successList.size == 1) {
                source.sendSuccess(Component.translatable("commands.unbreakable.toggle.success.single", entities.first().displayName, unbreakable), true)
            } else {
                source.sendSuccess(Component.translatable("commands.unbreakable.toggle.success.multiple", successList.size), true)
            }
            return successList.size
        }
    }


}