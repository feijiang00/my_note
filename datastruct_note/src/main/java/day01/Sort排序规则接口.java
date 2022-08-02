package day01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 测试Comparable接口
 * @date 2022/1/21 10:16
 */
public class Sort排序规则接口 {


    @Test
    public void test1(){
        List<People> list = new ArrayList<>();
        People people = new People();
        people.setName("叶晨");
        people.setAge(18);
        list.add(people);
        People people1 = new People();
        people1.setName("陆强");
        people1.setAge(50);
        list.add(people1);
        People people2 = new People();
        people2.setName("陆凯琪");
        people2.setAge(3);
        list.add(people2);

        /*
        我还是喜欢lambda表达式
         */
        list.sort((People o1,People o2)->{
            return o1.getAge() - o2.getAge();
        });

        /*
        简化1：省略参数声明的类型
        简化2：如果就一条语句，省略大括号以及return语句，酷毙了
        此外，lambda发生在类加载器阶段
         */
        list.sort((o1,o2)-> o1.getAge() - o2.getAge());

//        list.sort(new Comparator<People>() {
//            @Override
//            public int compare(People o1, People o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });

        System.out.println(list);
    }
}
