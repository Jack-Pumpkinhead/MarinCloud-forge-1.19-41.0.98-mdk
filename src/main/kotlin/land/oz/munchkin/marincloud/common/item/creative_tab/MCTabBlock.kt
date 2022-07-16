package land.oz.munchkin.marincloud.common.item.creative_tab

import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.block.build_in.MCBlocks
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

/**
 * Created by CowardlyLion at 2021/6/22 21:44
 */
object MCTabBlock : CreativeModeTab("${MarinCloud.ID}.block") {

    override fun makeIcon(): ItemStack {
        return ItemStack(MCBlocks.Diana.get())
    }


}