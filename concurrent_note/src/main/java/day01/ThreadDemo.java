package day01;

import lombok.extern.slf4j.Slf4j;

/**
 * @date 2021/12/13 10:43
 */
@Slf4j(topic = "c.Thread")
public class ThreadDemo {
    public static void main(String[] args) {

        Thread t = new Thread(){

            @Override
            public void run(){
                log.debug("running");
            }
        };

        t.start();

        log.debug("running");
    }
}
