package lambda.demo;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 关于，调用类的非静态方法，要用BiFunction函数的演示
 * @date 2022/1/18 10:14
 */
public final class A {

    public  int replace(String name){
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
        shaWu(A::replace);

    }
    //String 参数类型  Integer返回值类型
    public void shaWu(BiFunction<A,String, Integer> function){
        Integer i = (Integer) function.apply(this,"小ming");
        System.out.println(i);
    }

}
