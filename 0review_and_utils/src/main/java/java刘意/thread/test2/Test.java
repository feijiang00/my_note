package java刘意.thread.test2;

/**
 * @date 2021/12/6 9:09
 */
public class Test {
    public static void main(String[] args) {

        MyRunnable r1 = new MyRunnable();
        MyRunnable r2 = new MyRunnable();

        Thread thread1 = new Thread(r1,"小明");
        Thread thread2 = new Thread(r2,"小红");

        thread1.start();
        thread2.start();

    }
}
