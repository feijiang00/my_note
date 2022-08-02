package lambda.demo;

import org.junit.Test;

import java.util.function.Function;

/**
 * 方法的引用，
 *  目的，简化lambda表达式
 *  前提，需要方法中的参数化和返回值和lambda接口中的方法的参数和返回值对应起来
 * @date 2022/1/18 9:03
 */
public class 方法引用 {
    public static int replace(String name){
        System.out.println("shawu->"+name);
        return 6;
    }
    @Test
    public void test1(){
        //使用内置的函数式接口替换ShaWu接口
//        shaWu((String name)->{
//            System.out.println("shawu->"+name);
//            return 6;
//        });

        /*改成方法的引用*/
        shaWu(方法引用::replace);

    }
    //String 参数类型  Integer返回值类型
    public void shaWu(Function<String, Integer> function){
        Integer i = (Integer) function.apply("小明");
        System.out.println(i);
    }
}
