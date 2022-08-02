package lambda.demo;

import org.junit.Test;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 演示lambda表达式的使用
 * @date 2022/1/17 11:07
 */
public class Demo {

    @Test
    public void test1(){
        //接口的第二种功能，抽象出功能
        Thread_1 thread_1 = new Thread_1();
        thread_1.start();

        //匿名内部类写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("用匿名内部类，就方便一点");
            }
        }).start();

        //lambda
        new Thread(() -> {
            System.out.println("让你见识见识什么叫最方便");
        }).start();
    }

    /**
     * 自己写一个带参数的lambda,
     * 遇到问题，不会写不太清晰了：
     *      先思考一下，lambda是解决什么问题的，只要从接口抽象出功能说起，
     *      我之前总结了接口抽象出功能，传递的参数是一个实现类，典型的就是Runnable
     *      在Thread中传入Runnable接口的实现类，Runnable存在的意义在于抽象出线程运行的方法
     *
     *      lambda，有一个方法需要一个接口作为参数的时候i，lambda就可以替代匿名内部类实现更简单的语法
     *      lambda实现函数内具体内容。参数，返回值交给调用函数的人实现’
     *
     *      那个蜜蜂又是什么情况呢？他是给这个整个接口的实现类封装了起来
     *
     */
    @Test
    public void test2(){
        shaWuLove(new ShaWu() {
            @Override
            public int love(String name) {
                System.out.println("shawu->"+name);
                return 6;
            }
        });

        //lambda
        shaWuLove((String name)->{
            System.out.println("shawu->"+name);
            return 6;
        });
    }

    public static void shaWuLove(ShaWu shaWu){
        int i = shaWu.love("王庭江");
        System.out.println("返回值:"+i);
    }


    @Test
    public void test3(){
        ArrayList<People> arrayList = new ArrayList<>();
        arrayList.add(new People("纱雾",13));
        arrayList.add((new People("02",18)));
        arrayList.add(new People("玲玲",9));

        System.out.println(arrayList);
        arrayList.sort((People p1, People p2) -> {
            return p1.getAge() - p2.getAge();
        });
        System.out.println(arrayList);

        //lambda的缺省格式
        arrayList.sort((p1,p2)->p1.getAge()-p2.getAge());
    }

}
