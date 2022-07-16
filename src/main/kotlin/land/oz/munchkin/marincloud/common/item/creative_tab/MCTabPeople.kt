package land.oz.munchkin.marincloud.common.item.creative_tab

import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.item.build_in.MCBlockItemsPeople
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

/**
 * Created by CowardlyLion at 2021/6/22 21:44
 */
object MCTabPeople : CreativeModeTab("${MarinCloud.ID}.people") {

    override fun makeIcon(): ItemStack {
        return ItemStack(MCBlockItemsPeople.skymc7.get())
    }


}