package chapter04;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @date 2022/1/19 8:21
 */
@Slf4j(topic = "c.Thread")
public class Demo {
    /*
    测试并发问题
    可以看到最后i的值不是0，这就是多线程共享问题
    i++这个可以拆分为四个语句
    拿到静态i
    准备常量i
    常量i自增
    写入静态i

    术语：临界区，线程中的代码块如果是对共享资源的读写，那这块区叫临界区
         竞态条件，多个线程在临界区内执行，由于代码的执行序列不同而导致结果无法预测，称之为发生了竞态条件

    解决办法：synchronized关键字，上锁
            原理：利用对象锁保证了临界区中代码的原子性

    线程安全分析:
            《那你说说，线程安全怎么分析，如果是一个变量？》
            静态变量和成员变量：判断是否被共享，如果被共享，判断是否发生了读写操作。如果是的话，那么线程不安全
            局部变量：线程安全，但是如果是引用，那要具体分析，看引用的对象是否是共享，是否有读写
            《那你说说，你知道的常见的线程安全的类？》
            String，Integer，Vector，StringTable，Random，



     */
    static int i =0;
    @Test
    public void test1() throws InterruptedException {
        Object room = new Object();
       Thread t1 = new Thread(()->{
            for(int j=0;j<5000;j++){
                synchronized (room) {
                    i++;
                }
            }
        },"t1");
        Thread t2 = new Thread(()->{
            for(int j=0;j<5000;j++){
                synchronized (room) {
                    i--;
                }
            }
        },"t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        //输出i的值
        log.debug("{}",i);//08:36:30 [main] c.Thread - -1752
    }
}
