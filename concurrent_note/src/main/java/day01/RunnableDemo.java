package day01;

import lombok.extern.slf4j.Slf4j;

/**
 * @date 2021/12/13 10:53
 */
@Slf4j(topic = "c.RunnableDemo")
public class RunnableDemo {

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            log.info("running");
        }
    };

    public static void main(String[] args) {

        RunnableDemo runnableDemo = new RunnableDemo();

        Thread t = new Thread(runnableDemo.runnable,"T2");
        t.start();
    }
}
