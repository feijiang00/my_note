package lambda.demo;

import org.junit.Test;

import java.util.function.Function;

/**
 * @date 2022/1/17 15:00
 */
public class 函数式接口 {
    /**
     * 什么是函数式接口？  就是那些只有一个方法，能用lambda表达式来实现的接口
     *
     * 因此，jdk提供了我们不少函数式接口，例如我这里的ShaWu接口就可以被替换掉,
     *
     *      1.supplier提供接口
     *      2.Consumer消费接口
     *      3.Function函数接口
     *      4.predicate判断接口
     */

    @Test
    public void test1(){
        //使用内置的函数式接口替换ShaWu接口
        shaWu((String name)->{
            System.out.println("shawu->"+name);
            return 6;
        });

    }

    //String 参数类型  Integer返回值类型
    public void shaWu(Function<String, Integer> function){
        Integer i = (Integer) function.apply("王庭江");
        System.out.println(i);
    }
}
