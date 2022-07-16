package land.oz.munchkin.marincloud.client.renderer

import land.oz.munchkin.marincloud.client.renderer.model.CustomModel1
import land.oz.munchkin.marincloud.client.renderer.model.MCModelLayerLocations
import land.oz.munchkin.marincloud.common.entity.MCCat
import land.oz.munchkin.marincloud.resourceLocation
import net.minecraft.client.renderer.entity.EntityRendererProvider
import net.minecraft.client.renderer.entity.LivingEntityRenderer
import net.minecraft.resources.ResourceLocation

/**
 * Created by CowardlyLion at 2022/4/16 20:13
 */
class CustomRenderer(context: EntityRendererProvider.Context) : LivingEntityRenderer<MCCat, CustomModel1<MCCat>>(context, CustomModel1(context.bakeLayer(MCModelLayerLocations.customModel1)), 1F) {

    override fun getTextureLocation(p_114482_: MCCat): ResourceLocation = resourceLocation("textures/entity/custom_model_1.png")

}