package feijiang.robot.basic.message;

import love.forte.di.annotation.Beans;
import love.forte.simboot.annotation.Listener;
import love.forte.simbot.event.FriendMessageEvent;

@Beans
public class MyListener {

    @Listener
    public void listen(FriendMessageEvent event) {
        // do...
        System.out.println(event.getId()+"发来了消息");
    }
}
