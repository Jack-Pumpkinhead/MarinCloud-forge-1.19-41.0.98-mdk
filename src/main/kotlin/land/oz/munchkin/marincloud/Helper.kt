package land.oz.munchkin.marincloud

import net.minecraft.resources.ResourceLocation
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister

/**
 * Created by CowardlyLion at 2022/7/15 20:10
 */
fun resourceLocation(name: String) = ResourceLocation(MarinCloud.ID, name)
fun path(name: String) = "${MarinCloud.ID}:$name"

fun <A> IEventBus.registered(vararg registers: DeferredRegister<A>) {
    for (register in registers) {
        register.register(this)
    }
}

fun <A> IEventBus.registered(vararg registries: MCRegistry<A>) {
    for (registry in registries) {
        registry.deferredRegister.register(this)
    }
}
