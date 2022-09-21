package myself_test.接口回调和多态;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Author:feijiang
 * Date: 2022/9/20 19:47
 */

public class 回调的一个测试 {

    public void print(int a){
        System.out.println("我是主线程");
    }


    /**
     * 接口转型测试
     * 类转型测试
     */
    @Test
    public void test_inf(){
        /*
        ----------------------接口---------------------------
         */
        //接口的”向上转型“中，接口是不能调用子对象的方法，
        ABC abc = new AB();
        abc.callback();

        AB ab =new AB();
        ab.callback();
        ab.callback2();

        //结果：转型要有继承，而不是接口

        List<String> list = new ArrayList<>();
        list = new LinkedList<>();
        ArrayList<String> list1 =new ArrayList<>();


    }

    @Test
    public void test() {

    }

    @Test
    public void test2(){

    }

    @Test
    public void test3(){

    }


    public void printA() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("a");
    }

    public void printB(){
        System.out.println("b");
    }
    @Test
    public void test4() throws InterruptedException {
        printA();
        printB();
    }


}
