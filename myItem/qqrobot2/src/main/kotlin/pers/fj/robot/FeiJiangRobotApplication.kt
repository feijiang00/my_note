package pers.fj.robot

import love.forte.simboot.spring.autoconfigure.EnableSimbot
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Author:feijiang
 * Date: 2022/10/14 9:18
 */
@EnableSimbot
@SpringBootApplication
class FeiJiangRobotApplication
fun main(args: Array<String>){
    runApplication<FeiJiangRobotApplication>(*args)
}