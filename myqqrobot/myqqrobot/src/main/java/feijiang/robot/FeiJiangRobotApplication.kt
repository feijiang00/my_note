package feijiang.robot

import love.forte.simboot.spring.autoconfigure.EnableSimbot
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableSimbot
@SpringBootApplication
class FeiJiangRobotApplication {
}

fun main(args: Array<String>){
    runApplication<FeiJiangRobotApplication>(*args)
}