package land.oz.munchkin.marincloud

import land.oz.munchkin.marincloud.client.config.MCGUIConfig
import land.oz.munchkin.marincloud.client.renderer.CustomRenderer
import land.oz.munchkin.marincloud.client.renderer.model.MCModelLayerLocations
import land.oz.munchkin.marincloud.client.renderer.model.build_in.bodyLayer1
import land.oz.munchkin.marincloud.client.screen.MCConfigScreen
import land.oz.munchkin.marincloud.common.entity.build_in.MCEntities
import land.oz.munchkin.marincloud.common.item.build_in.MCItemsWeapon
import land.oz.munchkin.marincloud.common.item.property.ShieldPropertyFunction
import net.minecraft.client.renderer.item.ItemProperties
import net.minecraft.client.renderer.texture.TextureAtlas
import net.minecraftforge.client.event.EntityRenderersEvent
import net.minecraftforge.client.event.TextureStitchEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent

/**
 * Created by CowardlyLion at 2022/7/15 20:12
 */
object MarinCloudClient {

    @SubscribeEvent
    fun clientSetup(event: FMLClientSetupEvent) {
        event.enqueueWork {
            ItemProperties.register(MCItemsWeapon.shield_1.get(), resourceLocation("blocking"), ShieldPropertyFunction)
            ItemProperties.register(MCItemsWeapon.shield_2.get(), resourceLocation("blocking"), ShieldPropertyFunction)
        }

        //   FMLJavaModLoadingContext.get().modEventBus

        MCConfigScreen.registerExtensionPoint()
        MCGUIConfig.reloadConfig()

        MarinCloud.logger.info("${MarinCloud.NAME} ClientSetup ok.")
    }

    @SubscribeEvent
    fun onTextureStitch(event: TextureStitchEvent.Pre) {
        if (event.atlas.location() == TextureAtlas.LOCATION_BLOCKS) {
            event.addSprite(resourceLocation("items/longhuang"))
            event.addSprite(resourceLocation("entity/shield_base"))
            event.addSprite(resourceLocation("entity/shield_base_nopattern"))
//            event.addSprite(res("entity/custom_model_1"))
            MarinCloud.logger.info("${MarinCloud.NAME} texture stitched in LOCATION_BLOCKS ok.")
        }
    }

    @SubscribeEvent
    fun onRegisterEntityRenderer(event: EntityRenderersEvent.RegisterRenderers) {
        event.registerEntityRenderer(MCEntities.testEntity.get()) { CustomRenderer(it) }
        MarinCloud.logger.info("${MarinCloud.NAME} RegisterRenderers ok.")
    }

    @SubscribeEvent
    fun onRegisterLayerDefinition(event: EntityRenderersEvent.RegisterLayerDefinitions) {
        event.registerLayerDefinition(MCModelLayerLocations.customModel1) { bodyLayer1() }
        MarinCloud.logger.info("${MarinCloud.NAME} RegisterLayerDefinitions ok.")
    }

    //ModelEvent


}