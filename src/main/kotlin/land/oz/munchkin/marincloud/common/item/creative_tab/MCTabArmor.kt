package land.oz.munchkin.marincloud.common.item.creative_tab

import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.item.build_in.MCItemsArmor
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

/**
 * Created by CowardlyLion at 2022/6/25 12:30
 */
object MCTabArmor : CreativeModeTab("${MarinCloud.ID}.armor") {

    override fun makeIcon(): ItemStack {
        return ItemStack(MCItemsArmor.helmet_1.get())
    }

}