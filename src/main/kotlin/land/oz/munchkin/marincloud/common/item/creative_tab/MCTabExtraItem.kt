package land.oz.munchkin.marincloud.common.item.creative_tab

import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.item.build_in.MCItemsSword
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

/**
 * Created by CowardlyLion at 2022/7/15 22:16
 */
object MCTabExtraItem : CreativeModeTab("${MarinCloud.ID}.extra_item") {

    override fun makeIcon(): ItemStack {
        return ItemStack(MCItemsSword.sword_9.get())
    }

}