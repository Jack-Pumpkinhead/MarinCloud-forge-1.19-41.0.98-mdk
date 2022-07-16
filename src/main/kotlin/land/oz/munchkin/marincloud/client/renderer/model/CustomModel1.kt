package land.oz.munchkin.marincloud.client.renderer.model

import com.mojang.blaze3d.vertex.PoseStack
import com.mojang.blaze3d.vertex.VertexConsumer
import net.minecraft.client.model.EntityModel
import net.minecraft.client.model.geom.ModelPart
import net.minecraft.world.entity.Entity

/**
 * Created by CowardlyLion at 2022/4/16 19:42
 */
class CustomModel1<T : Entity>(val root: ModelPart) : EntityModel<T>() {

    val main = root.getChild("main")
    val sub1 = main.getChild("sub1")


    override fun renderToBuffer(poseStack: PoseStack, buffer: VertexConsumer, packedLight: Int, packedOverlay: Int, red: Float, green: Float, blue: Float, alpha: Float) {
        poseStack.pushPose()
        poseStack.scale(0.3F, 0.3F, 0.3F)
        root.render(poseStack, buffer, packedLight, packedOverlay)
        poseStack.popPose()
    }

    override fun setupAnim(entity: T, limbSwing: Float, limbSwingAmount: Float, ageInTicks: Float, netHeadYaw: Float, headPitch: Float) {
        main.zRot = ageInTicks
    }


}