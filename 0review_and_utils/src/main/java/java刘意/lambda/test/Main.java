package java刘意.lambda.test;

import org.junit.Test;

/**
 * @date 2021/12/8 10:34
 */
public class Main {

    @Test
    public void test(){
        useDemo(() ->{
            System.out.println("你好啊！lambda");
        });
    }

    /**
     * 从这里应该能理解，lambda改变的函数体的形式，算法。不变的是参数
     */
    @Test
    public void test2(){
        useDemo2((int x,int y) ->{
            return x - y;
        });
    }

    private static void useDemo(Demo d){
        d.test();
    }

    private static void useDemo2(Demo2 demo2){
        int sum = demo2.sum(10,20);
        System.out.println(sum);
    }
}
