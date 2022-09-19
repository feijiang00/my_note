package feijiang.robot.core.listener

import love.forte.di.annotation.Beans
import love.forte.simboot.annotation.Listener
import love.forte.simbot.event.FriendMessageEvent

@Beans
class MyListener {

    @Listener
    suspend fun FriendMessageEvent.onEvent() {
        // do..
        println("我是小红")
    }
}