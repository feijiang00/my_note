package feijiang.robot.core.listener

import feijiang.robot.core.annotation.RobotListen
import love.forte.simboot.annotation.Filter
import love.forte.simbot.event.GroupMessageEvent
import org.ktorm.database.Database
import org.ktorm.dsl.eq
import org.ktorm.entity.Entity
import org.ktorm.entity.add
import org.ktorm.entity.find
import org.springframework.stereotype.Component
import feijiang.robot.core.common.RobotCore
import feijiang.robot.core.common.logger
import feijiang.robot.core.common.send
import feijiang.robot.core.entity.GroupBootState
import feijiang.robot.core.entity.GroupBootStates
import feijiang.robot.core.entity.groupBootStates
import feijiang.robot.core.enums.RobotPermission
import feijiang.robot.core.util.MessageUtil.getAtSet
import feijiang.robot.core.util.MessageUtil.groupId

/**
 * 监听群开关机
 *
 * @author feijiang
 */
@Component
class BootListener(private val database: Database) {
    @RobotListen(permission = RobotPermission.ADMINISTRATOR)
    @Filter("开机")
    suspend fun GroupMessageEvent.boot() {
        val atSet = getAtSet()
        if (atSet.isEmpty() || atSet.contains(bot.id)) {
            val groupCode = groupId()
            logger { "群${groupCode}开机" }
            if (!RobotCore.BOOT_MAP.getOrDefault(groupCode, false)) {
                bootOrDown(groupCode, true)
            }
            send("已开机")
        }
    }

    @RobotListen(permission = RobotPermission.ADMINISTRATOR, isBoot = true)
    @Filter("关机")
    suspend fun GroupMessageEvent.down() {
        val atSet = getAtSet()
        if (atSet.isEmpty() || atSet.contains(bot.id)) {
            val groupCode = groupId()
            logger { "群${groupCode}关机" }
            bootOrDown(groupCode, false)
            send("已关机")
        }
    }

    private fun bootOrDown(groupCode: String, state: Boolean) {
        RobotCore.BOOT_MAP[groupCode] = state
        val groupBootState = database.groupBootStates.find { GroupBootStates.groupCode eq groupCode }
        if (groupBootState == null) {
            database.groupBootStates.add(Entity.create<GroupBootState>().also {
                it.groupCode = groupCode
                it.state = state
            })
        } else {
            groupBootState.state = state
            groupBootState.flushChanges()
        }
    }
}