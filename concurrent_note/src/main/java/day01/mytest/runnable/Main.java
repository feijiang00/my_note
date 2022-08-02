package day01.mytest.runnable;

/**
 * 测试Runnable接口的作用，抽象出功能，
 * @date 2022/1/15 14:14
 */
public class Main {

    public static void main(String[] args) {
        Runnable1 runnable1 = new Runnable1();
        Thread thread = new Thread(runnable1);
        thread.start();
    }
}
