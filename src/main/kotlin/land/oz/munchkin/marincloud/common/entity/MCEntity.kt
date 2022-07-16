package land.oz.munchkin.marincloud.common.entity

import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraftforge.registries.RegistryObject

/**
 * Created by CowardlyLion at 2022/6/21 22:22
 */
class MCEntity<T : Entity>(val name: String, val instance: RegistryObject<EntityType<T>>) {

    fun get() = instance.get()

}