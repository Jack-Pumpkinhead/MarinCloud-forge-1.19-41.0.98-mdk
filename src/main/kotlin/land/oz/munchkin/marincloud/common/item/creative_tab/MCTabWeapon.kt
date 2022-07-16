package land.oz.munchkin.marincloud.common.item.creative_tab

import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.common.item.build_in.MCItemsSword
import land.oz.munchkin.marincloud.common.item.build_in.MCItemsWeapon
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack

/**
 * Created by CowardlyLion at 2022/6/25 12:30
 */
object MCTabWeapon : CreativeModeTab("${MarinCloud.ID}.weapon") {

    override fun makeIcon(): ItemStack {
        return ItemStack(MCItemsWeapon.axe_1.get())
    }

}