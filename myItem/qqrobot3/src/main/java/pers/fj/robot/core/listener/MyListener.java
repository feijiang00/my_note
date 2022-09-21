package pers.fj.robot.core.listener;

import love.forte.simbot.annotation.OnPrivate;
import love.forte.simbot.api.message.events.PrivateMsg;
import love.forte.simbot.api.sender.MsgSender;
import org.springframework.stereotype.Component;

@Component
public class MyListener {

    /**
     * 监听并且复读
     * @param privateMsg
     * @param msgSender
     */
    @OnPrivate
    public void onEvent(PrivateMsg privateMsg, MsgSender msgSender) {
        // do...
        msgSender.SENDER.sendPrivateMsg(privateMsg,privateMsg.getMsgContent());
    }

}