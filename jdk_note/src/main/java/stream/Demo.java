package stream;

import javafx.scene.effect.SepiaTone;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @date 2022/1/18 9:19
 */
public class Demo {

    ArrayList<String> list = new ArrayList<>();

    @Test
    public void test1() {
        Collections.addAll(list, "张羽泉", "张叶晨", "张强", "陆凯琪", "是金龙");
        //输出姓张的，名字三个数的人
        /*
        public interface Predicate<T> {
     *
     * boolean test(T t);
     */

        /**
         * 如果你不能理解下面这段代码，理解一下这个
         *
         * 我们正处第一段代码这里，第二段代码就是stream的filter过滤器自己写的，并且它使用了内置函数
         *     public void test1(){
         *         //使用内置的函数式接口替换ShaWu接口
         *         shaWu((String name)->{
         *             System.out.println("shawu->"+name);
         *             return 6;
         *         });
         *
         *     }
         *
         *     //String 参数类型  Integer返回值类型
         *     public void shaWu(Function<String, Integer> function){
         *         Integer i = (Integer) function.apply("王庭江");
         *         System.out.println(i);
         *     }
         */
        list.stream()
                .filter((String name)->{
                    //startsWith,表示name如果是以xx开头，返回真
                    return name.startsWith("张");
                })
                .filter((name)->{
                    return name.length() == 3;
                })
                .forEach(System.out::println);

        //测试stream流中的count终结方法
        long count = list.stream()
                .filter((String name)->{
                    //startsWith,表示name如果是以xx开头，返回真
                    return name.startsWith("张");
                })
                .filter((name)->{
                    return name.length() == 3;
                })
                .count();
        System.out.println(count);

        //测试stream中的collect方法,收集
        Set<String> set = list.stream()
                .filter((String name)->{
                    //startsWith,表示name如果是以xx开头，返回真
                    return name.startsWith("张");
                })
                .filter((name)->{
                    return name.length() == 3;
                })
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

    }

}