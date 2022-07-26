package feijiang.robot.entertainment.listener

import com.alibaba.fastjson2.JSONObject
import kotlinx.coroutines.delay
import love.forte.simboot.annotation.Filter
import love.forte.simbot.ID
import love.forte.simbot.component.mirai.message.MiraiShare
import love.forte.simbot.event.GroupMessageEvent
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import feijiang.robot.core.annotation.RobotListen
import feijiang.robot.core.common.send
import feijiang.robot.core.util.TianApiTool
import java.util.*

/**
 * @author feijiang
 * @date 2022/2/19 0:06
 */
@Component
class LookListener(private val tianApiTool: TianApiTool) {
    @Value("\${robot.ip-host}")
    private val host: String = ""

    private val lookMap: MutableMap<ID, TreeSet<String>> = HashMap()
    private val ipMap: MutableMap<String, String> = HashMap()
    private val ipv4Length = 4
    fun addIp(ip: String, group: ID) {
        if (lookMap[group] == null) {
            return
        }
        lookMap[group]?.add(ip)
        val ipDetail = getIpDetail(ip)
        ipMap[ip] = ipDetail
    }

    @Suppress("OPT_IN_USAGE")
    @RobotListen(desc = "窥屏检测", isBoot = true)
    @Filter("窥屏检测")
    suspend fun GroupMessageEvent.look() {
        if (lookMap.containsKey(group().id)) {
            return
        }
        lookMap[group().id] = TreeSet()
        val msg = MiraiShare("", "窥屏检测中...", "电脑端窥屏暂时无法检测...", "${host}look?group=${group().id}")
        send(msg)
        delay(10000L)
        val list = ArrayList<String>()
        lookMap[group().id]?.let {
            list.add("检测结束, 有${it.size}人窥屏")
            it.forEach { ip ->
                list.add(getIpDetail(ip))
            }
        }
        if (list.size > 0) {
            send(list, "\n")
        }
        lookMap.remove(group().id)

    }

    private fun getIpDetail(ip: String): String {
        val newslist: JSONObject = tianApiTool.getIpDetailApi(ip) ?: return ""
        val province: String = newslist.getString("province")
        val city: String = newslist.getString("city")
        return "${encryptIp(ip)}  ${if (province == city) province else "$province  $city"}\n"
    }

    private fun encryptIp(ip: String): String {
        val split = ip.split(".")
        return if (split.size == ipv4Length) listOf(split[0], split[1], "xxx", "xxx").joinToString(".")
        else ip
    }
}