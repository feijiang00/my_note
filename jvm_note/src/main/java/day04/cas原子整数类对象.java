package day04;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * juc中提供了线程安全的操作，例如AtomicInteger，他们的底层原理就是采用CAS技术 + volatile来实现的
 * @date 2022/2/24 6:59
 */
public class cas原子整数类对象 {

    private static AtomicInteger i = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread( () -> {
            for (int j=0;j<5000;j++){
                i.getAndIncrement();//获取并且自增 i++
            }
        });

        Thread t2 = new Thread( () ->{
            for(int j=0;j<5000;j++){
                i.getAndDecrement();//获取并且自减 i--
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
