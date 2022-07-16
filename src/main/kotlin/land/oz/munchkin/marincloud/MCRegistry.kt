package land.oz.munchkin.marincloud

import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.RegistryObject
import java.util.function.Supplier

/**
 * Created by CowardlyLion at 2022/7/16 11:18
 */
interface MCRegistry<A> {

    val deferredRegister: DeferredRegister<A>
    fun <I : A> String.register(sup: Supplier<out I>): RegistryObject<I> = deferredRegister.register(this, sup)

}