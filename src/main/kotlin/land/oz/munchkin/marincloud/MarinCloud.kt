package land.oz.munchkin.marincloud

import land.oz.munchkin.marincloud.client.key_binding.MCKeyBinding
import land.oz.munchkin.marincloud.common.block.build_in.MCBlocks
import land.oz.munchkin.marincloud.common.block.build_in.MCBlocksPeople
import land.oz.munchkin.marincloud.common.capability.potion_attack.MCCapabilityPotionAttack
import land.oz.munchkin.marincloud.common.entity.build_in.MCEntities
import land.oz.munchkin.marincloud.common.event.MCEvents
import land.oz.munchkin.marincloud.common.item.build_in.*
import land.oz.munchkin.marincloud.common.sound.MCSoundEvents
import land.oz.munchkin.marincloud.config.MCConfig
import land.oz.munchkin.marincloud.feature.potion_attack.common.event.MCCommandPotionAttack
import land.oz.munchkin.marincloud.feature.potion_attack.common.event.PotionAttackEvents
import land.oz.munchkin.marincloud.feature.unbreakable.common.command.MCCommandUnbreakable
import land.oz.munchkin.marincloud.feature.world_border_indicator.client.overlay.WorldBorderIndicatorOverlay
import net.minecraft.world.entity.animal.Cat
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent
import net.minecraftforge.event.entity.EntityAttributeCreationEvent
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.event.server.ServerStoppingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.loading.FMLEnvironment
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS

/**
 * Created by CowardlyLion at 2021/6/22 16:25
 */
@Mod(MarinCloud.ID)
object MarinCloud {

    const val ID = "marincloud"
    const val NAME = "MarinCloud"

    val logger: Logger = LogManager.getLogger()


    init {
        MOD_BUS.register(this)
        FORGE_BUS.addListener(::onServerStarting)
        FORGE_BUS.addListener(::onServerStopping)
        if (FMLEnvironment.dist == Dist.CLIENT) {
            MOD_BUS.register(MarinCloudClient)
            MOD_BUS.register(WorldBorderIndicatorOverlay)
            FORGE_BUS.register(MCKeyBinding)
        }


        MOD_BUS.registered(MCBlocks, MCBlocksPeople)
        MOD_BUS.registered(MCItems, MCItemsSword, MCItemsArmor, MCItemsWeapon, MCBlockItems, MCBlockItemsPeople)
        MOD_BUS.registered(MCSoundEvents)
        MOD_BUS.registered(MCEntities)

        FORGE_BUS.register(MCEvents)
        FORGE_BUS.register(PotionAttackEvents)
        FORGE_BUS.register(MCCommandPotionAttack)
        FORGE_BUS.register(MCCommandUnbreakable)

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MCConfig.spec)  //default file name

        logger.info("$NAME init ok.")
    }

    //--------------FORGE_BUS--------------
    fun onServerStarting(event: ServerStartingEvent) {
        logger.info("$NAME onServerStarting")
    }

    var stop = false

    fun onServerStopping(event: ServerStoppingEvent) {
        logger.info("$NAME onServerStopping")
        stop = true
    }


    //--------------MOD_BUS---------------
    @SubscribeEvent
    fun setup(event: FMLCommonSetupEvent) {

        logger.info("$NAME FMLCommonSetup ok.")
    }

    @SubscribeEvent
    fun registerCapabilities(event: RegisterCapabilitiesEvent) {
        event.register(MCCapabilityPotionAttack::class.java)
        logger.info("$NAME RegisterCapabilities ok.")
    }

    @SubscribeEvent
    fun registerAttributes(event: EntityAttributeCreationEvent) {
        event.put(MCEntities.testEntity.get(), Cat.createAttributes().build())
        logger.info("$NAME EntityAttributeCreation ok.")
    }


}