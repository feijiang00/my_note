package myitem;

/**
 * 活锁 ：
 *  活锁出现在两个线程互相改变对方的结束条件，后谁也无法结束
 *  这里它们同时对一个变量进行自增和自减，并且都是sleep（200），因此
 */
public class 活锁 {
    static volatile int count = 10;
    static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (count > 0) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println("count:" + count);
            }
        }, "t1").start();

        new Thread(() -> {
            while (count < 20) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println("count:" + count);
            }
            } ,"t2").start();
    }
}

