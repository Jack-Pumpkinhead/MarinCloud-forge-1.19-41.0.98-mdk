package land.oz.munchkin.marincloud.common.block.build_in

import land.oz.munchkin.marincloud.MCRegistry
import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.block.MCBlockDirectional
import land.oz.munchkin.marincloud.common.block.property.MCBlockProperties
import net.minecraft.world.level.block.Block
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

/**
 * Created by CowardlyLion at 2022/7/16 22:43
 */
object MCBlocksPeople : MCRegistry<Block> {

    override val deferredRegister = DeferredRegister.create(ForgeRegistries.BLOCKS, MarinCloud.ID)


    val Creamily_231 = (BlockNames.Creamily_231).register { MCBlockDirectional(MCBlockProperties.lightGlass) }
    val skymc7 = (BlockNames.skymc7).register { MCBlockDirectional(MCBlockProperties.lightGlass) }
    val abc = (BlockNames.abc).register { MCBlockDirectional(MCBlockProperties.lightGlass) }
    val DOYO = (BlockNames.DOYO).register { MCBlockDirectional(MCBlockProperties.lightGlass) }
    val HOND330 = (BlockNames.HOND330).register { MCBlockDirectional(MCBlockProperties.lightGlass) }
    val yuking = (BlockNames.yuking).register { MCBlockDirectional(MCBlockProperties.lightGlass) }

}