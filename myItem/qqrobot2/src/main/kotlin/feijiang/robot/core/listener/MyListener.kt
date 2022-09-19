package feijiang.robot.core.listener


import love.forte.simboot.annotation.Listener
import love.forte.simbot.event.FriendMessageEvent
import org.springframework.stereotype.Component


@Component
class MyListener {

    @Listener
    suspend fun FriendMessageEvent.onEvent() {
        // do..
        println("xxx")
    }
}