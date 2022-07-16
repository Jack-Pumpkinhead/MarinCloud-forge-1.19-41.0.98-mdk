package land.oz.munchkin.marincloud.common.item

import land.oz.munchkin.marincloud.common.sound.MCSoundEvents
import land.oz.munchkin.marincloud.util.randomPitch
import land.oz.munchkin.marincloud.util.randomizeEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.entity.player.Player

/**
 * Created by CowardlyLion at 2021/12/28 22:11
 */
class MCItemCrazyDave(val soundProbabilities: FloatArray, properties: Properties) : MCItem(properties) {

    init {
        assert(soundProbabilities.size == 3)
    }

    fun playsound(player: Player) {
        player.random.randomizeEvents(soundProbabilities, {
            player.level.playSound(null, player.x, player.y, player.z, MCSoundEvents.crazydaveshort1.get(), SoundSource.NEUTRAL, 1.0F, player.random.randomPitch())
        }, {
            player.level.playSound(null, player.x, player.y, player.z, MCSoundEvents.crazydaveshort2.get(), SoundSource.NEUTRAL, 1.0F, player.random.randomPitch())
        }, {
            player.level.playSound(null, player.x, player.y, player.z, MCSoundEvents.crazydaveshort3.get(), SoundSource.NEUTRAL, 1.0F, player.random.randomPitch())
        })
    }

}