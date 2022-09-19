package feijiang.robot.entertainment.listener

import love.forte.simboot.annotation.Filter
import love.forte.simboot.annotation.TargetFilter
import love.forte.simbot.event.GroupMessageEvent
import org.springframework.stereotype.Component
import feijiang.robot.core.annotation.RobotListen
import feijiang.robot.core.common.send
import feijiang.robot.core.util.MessageUtil.authorId
import feijiang.robot.core.util.MessageUtil.getAtSet
import feijiang.robot.core.util.TianApiTool

/**
 * @author feijiang
 * @date 2022/3/15 17:35
 */
@Component
class ChatListener(val tianApiTool: TianApiTool) {

    @RobotListen(isBoot = true)
    @Filter(target = TargetFilter(atBot = true))
    suspend fun GroupMessageEvent.chat() {
        getAtSet().let {
            if (it.size == 1 && it.contains(bot.id)) {
                send(tianApiTool.chatApi(messageContent.plainText.trim(), authorId()))
            }
        }
    }
}