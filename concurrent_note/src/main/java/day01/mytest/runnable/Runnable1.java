package day01.mytest.runnable;

import lombok.extern.slf4j.Slf4j;

/**
 * @date 2022/1/15 14:12
 */
@Slf4j(topic = "c.Runnable1")
public class Runnable1 implements Runnable{
    //实现了这个接口，就需要按照他的规则
    @Override
    public void run() {
      log.info("hihihi");
    }
}
