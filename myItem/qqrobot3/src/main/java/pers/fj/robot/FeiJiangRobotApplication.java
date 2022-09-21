package pers.fj.robot;

import love.forte.simbot.spring.autoconfigure.EnableSimbot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Author:feijiang
 * Date: 2022/9/19 14:23
 */
@EnableSimbot
@SpringBootApplication
public class FeiJiangRobotApplication {
    public static void main(String[] args) {
        SpringApplication.run(FeiJiangRobotApplication.class,args);
    }
}
