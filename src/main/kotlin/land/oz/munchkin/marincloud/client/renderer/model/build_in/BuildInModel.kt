package land.oz.munchkin.marincloud.client.renderer.model.build_in

import net.minecraft.client.model.geom.PartPose
import net.minecraft.client.model.geom.builders.CubeDeformation
import net.minecraft.client.model.geom.builders.CubeListBuilder
import net.minecraft.client.model.geom.builders.LayerDefinition
import net.minecraft.client.model.geom.builders.MeshDefinition

/**
 * Created by CowardlyLion at 2022/4/16 19:50
 */

//y向下，
//生物原点在世界坐标y +24F
fun bodyLayer1(): LayerDefinition {
    val mesh = MeshDefinition()
    mesh.root.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.ZERO)
//        .addOrReplaceChild("sub1", CubeListBuilder.create().texOffs(0, 0).addBox(0F, 0.0F, 0F, 64.0F, -64F, 64.0F, CubeDeformation(0.0F)), PartPose.offset(-32F, 24.0F, -32F))
        .addOrReplaceChild("sub1", CubeListBuilder.create().texOffs(0, 0).addBox(0F, 0.0F, 0F, 64.0F, 64F, 64.0F, CubeDeformation(0.0F)), PartPose.offset(-32F, -32.0F, -32F))

//    mesh.root.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0).addBox(0F, 0.0F, 0F, 64.0F, -64F, 64.0F, CubeDeformation(0.0F)), PartPose.offset(-32F, 24.0F, -32F))

    return LayerDefinition.create(mesh, 64, 64)
}