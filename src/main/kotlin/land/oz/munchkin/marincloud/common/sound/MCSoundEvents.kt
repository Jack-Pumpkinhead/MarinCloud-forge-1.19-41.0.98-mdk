package land.oz.munchkin.marincloud.common.sound

import land.oz.munchkin.marincloud.MCRegistry
import land.oz.munchkin.marincloud.MarinCloud
import land.oz.munchkin.marincloud.resourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

/**
 * Created by CowardlyLion at 2021/6/22 22:16
 *
 * 增加声音文件：
 *      sounds.json
 *      SoundNames
 *      MCSoundEvents
 *      lang/
 */
object MCSoundEvents : MCRegistry<SoundEvent> {

    override val deferredRegister = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MarinCloud.ID)

    val CatchSun = (SoundNames.CatchSun).register { MCSoundEvent(resourceLocation(SoundNames.CatchSun)) }
    val DiamondSpawn = (SoundNames.DiamondSpawn).register { MCSoundEvent(resourceLocation(SoundNames.DiamondSpawn)) }
    val chomp = (SoundNames.chomp).register { MCSoundEvent(resourceLocation(SoundNames.chomp)) }
    val chomp2 = (SoundNames.chomp2).register { MCSoundEvent(resourceLocation(SoundNames.chomp2)) }
    val chompSoft = (SoundNames.chompsoft).register { MCSoundEvent(resourceLocation(SoundNames.chompsoft)) }
    val coin = (SoundNames.coin).register { MCSoundEvent(resourceLocation(SoundNames.coin)) }
    val crazydaveshort1 = (SoundNames.crazydaveshort1).register { MCSoundEvent(resourceLocation(SoundNames.crazydaveshort1)) }
    val crazydaveshort2 = (SoundNames.crazydaveshort2).register { MCSoundEvent(resourceLocation(SoundNames.crazydaveshort2)) }
    val crazydaveshort3 = (SoundNames.crazydaveshort3).register { MCSoundEvent(resourceLocation(SoundNames.crazydaveshort3)) }
    val diamond = (SoundNames.diamond).register { MCSoundEvent(resourceLocation(SoundNames.diamond)) }

}