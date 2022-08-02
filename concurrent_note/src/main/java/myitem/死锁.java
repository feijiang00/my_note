package myitem;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程A首先获得对象A的锁后sleep 1s，同时线程B获得对象B的锁后 sleep 1s
 * 此时，线程A想要获取对象B的锁，线程B想要获取对象A的锁，
 * 但是，双方都没有获得想要的锁，因此都无法释放锁，于是就产生了死锁的现象！
 *
 */
@Slf4j(topic = "c.test02")
public class 死锁 {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                log.debug("lock A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    log.debug("lock B");
                    log.debug("t1 操作");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (B) {
                log.debug("lock B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A) {
                    log.debug("lock A");
                    log.debug("t2 操作");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
