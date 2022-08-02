package myitem;

/**
 * 面试题：
 *
 * 实现一个多线程类，并用该线程类实例化3个线程A,B,C；A线程打印字符A,B线程打印字符B，C线程打印字符C；启动这3个线程，要求启动线程的顺序为C线程->B线程->A线程，并且最后输出内容为：
 * A
 * B
 * C
 * 不能用sleep函数，注意考虑线程安全问题。
 * 按顺序启动三个线程，但却需要彼此停留
 * @date 2022/1/10 15:27
 */
public class Main extends Thread {
    private static Object LOCK = new Object();
    private static int flag = 1;
    public static void main(String[] args) throws InterruptedException {
        Main A = new Main() {
            public void run() {
                synchronized (LOCK) {
                    //当flag为1的时候才会执行
                    while (flag != 1) {
                        LOCK.notifyAll();
                        try {
                            LOCK.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("A");
                    flag = 2;
                    LOCK.notifyAll();
                }
            }
        };
        Main B = new Main() {
            public void run() {
                synchronized (LOCK) {
                    while (flag != 2) {
                        LOCK.notifyAll();
                        try {
                            LOCK.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("B");
                    flag = 3;
                    LOCK.notifyAll();
                }
            }
        };
        Main C = new Main() {
            public void run() {
                synchronized (LOCK) {
                    while (flag != 3) {
                        LOCK.notifyAll();
                        try {
                            LOCK.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("C");
                    flag = 1;
                    LOCK.notifyAll();
                }
            }
        };
        C.setName("C");
        B.setName("B");
        A.setName("A");
        C.start();
        B.start();
        A.start();
    }
}
