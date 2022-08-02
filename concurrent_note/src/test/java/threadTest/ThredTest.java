package threadTest;

import org.junit.Test;

import javax.security.sasl.SaslServer;
import java.util.concurrent.CountDownLatch;

/**
 * @date 2021/12/13 13:40
 */
public class ThredTest {

    public  static  final  Long N = 10000000000L;

    @Test
    public void test1() throws InterruptedException {
        long a = System.currentTimeMillis();
        System.out.println("开始:"+a);
        for(long i=0;i<N;i++){

        }
//        Thread.sleep(2000);
        long b = System.currentTimeMillis();
        System.out.println("结束:"+b);
        System.out.println(b-a);
    }

    @Test
    public void test2() throws InterruptedException {
        long a = System.currentTimeMillis();

        CountDownLatch countDownLatch = new CountDownLatch(1);
        System.out.println("开始:"+a);
        Thread t1 = new Thread(){
            public void run(){
                for(long i=0;i<N/2;i++){

                }
            }
        };
        Thread t2 = new Thread(){
            public void run(){
                for(long i=N/2;i<N;i++){

                }
            }
        };
        t1.start();
        t2.start();
        System.out.println("主进程结束");
        t1.join();
        t2.join();

        long b = System.currentTimeMillis();
        System.out.println("结束:"+b);
        System.out.println(b-a);
    }

}
