package day01;

import java.util.TreeMap;

/**
 * 演示堆内存的诊断工具的使用
 * @date 2022/1/2 21:34
 */
public class Heap1 {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("1......");
        Thread.sleep(30000);
        byte[] array = new byte[1024 * 1024 * 10];//10mb
        System.out.println("2.......");
        Thread.sleep(30000);
        array = null;
        System.gc();//调用垃圾回收器回收
        System.out.println("3......");
        Thread.sleep(1000000);
    }
}
