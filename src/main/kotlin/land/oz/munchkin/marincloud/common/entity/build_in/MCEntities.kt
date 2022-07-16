package land.oz.munchkin.marincloud.common.entity.build_in

import land.oz.munchkin.marincloud.MCRegistry
import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.entity.MCCat
import land.oz.munchkin.marincloud.common.entity.MCEntity
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import java.util.function.Supplier

/**
 * Created by CowardlyLion at 2022/6/21 21:56
 *
 * entity name(resource location) should lived in [a-z0-9/._-]
 */
object MCEntities : MCRegistry<EntityType<*>> {

    override val deferredRegister = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MarinCloud.ID)

    fun <T : Entity, I : EntityType<T>> register(name: String, sup: Supplier<out I>) = MCEntity(name, deferredRegister.register(name, sup))
    fun <T : Entity> register(name: String, constructor: EntityType.EntityFactory<T>, mobCategory: MobCategory, builderExtra: EntityType.Builder<T>.() -> Unit): MCEntity<T> {
        return register(name) {
            val builder = EntityType.Builder.of(constructor, mobCategory)
            builderExtra(builder)
            builder.build(name)
        }
    }


    val testEntity = register("test_entity", ::MCCat, MobCategory.CREATURE) {
        sized(1F, 1F)
        clientTrackingRange(8)
    }


}