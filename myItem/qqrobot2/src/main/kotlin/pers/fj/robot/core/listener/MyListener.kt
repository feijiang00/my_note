package pers.fj.robot.core.listener

import love.forte.di.annotation.Beans
import love.forte.simboot.annotation.Listener
import love.forte.simbot.action.SendSupport
import love.forte.simbot.action.sendIfSupport
import love.forte.simbot.definition.Friend
import love.forte.simbot.event.Event
import love.forte.simbot.event.FriendMessageEvent
import love.forte.simbot.event.MessageEvent
import love.forte.simbot.message.Message
import love.forte.simbot.message.MessageReceipt
import love.forte.simbot.message.Messages
import love.forte.simbot.message.MessagesBuilder
import org.springframework.core.NestedExceptionUtils.buildMessage

/**
 * Author:feijiang
 * Date: 2022/9/28 15:46
 */
@Beans
class MyListener {

//    /**
//     * 发送消息
//     * @param event 消息对象
//     * @param messages 要发送的消息
//     * @param separator [messages]是数组或列表时的消息分隔符
//     */
//    suspend fun send(
//        event: String,
//        messages: Any,
//        separator: String = "",
//    ): MessageReceipt? {
//        if (messages.toString().isEmpty()) return null
//        return when (event) {
//            is SendSupport -> event.send(buildMessage(messages, separator))
//            is MessageEvent -> event.source().sendIfSupport(buildMessage(messages, separator))
//            else -> null
//        }
//    }
//
//    /**
//     * 根据[messages]和[separator]构建一条消息
//     * @param messages 要构建的消息
//     * @param separator [messages]是数组或列表时的消息分隔符
//     */
//    private fun buildMessage(
//        messages: Any,
//        separator: String = "",
//    ): Messages = MessagesBuilder().apply {
//        when (messages) {
//            is Array<*> -> {
//                messages.forEachIndexed { index, it ->
//                    when (it) {
//                        is Message.Element<*> -> append(it)
//                        else -> append(it.toString())
//                    }
//                    if (index != messages.size - 1) {
//                        append(separator)
//                    }
//                }
//            }
//            is Iterable<*> -> {
//                messages.forEachIndexed { index, it ->
//                    when (it) {
//                        is Message.Element<*> -> append(it)
//                        else -> append(it.toString())
//                    }
//                    if (index != messages.count() - 1) {
//                        append(separator)
//                    }
//                }
//            }
//            is Message.Element<*> -> append(messages)
//            else -> append(messages.toString())
//        }
//    }.build()

    @Listener
    suspend fun FriendMessageEvent.onEvent(event: MessageEvent) {
        // do..
        reply("你也好")
        println("我是小红")
        var id = event.source.id
        println(id)

    }
}