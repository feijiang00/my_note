package java刘意.thread.test;

/**
 * @date 2021/12/3 16:19
 */
public class Test {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("火车");
        MyThread myThread2 = new MyThread("飞机");

        //设置线程的优先级
        myThread1.setPriority(1);
        myThread2.setPriority(10);

        myThread1.start();
        myThread2.start();
    }
}

