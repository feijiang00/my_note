package java刘意.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @Author: feiJiang
 * @Date: 2021/05/10/14:35
 * @Description:
 */

/**
 * 今天项目开发，需要通过两个条件去查询数据库数据，同时只要满足一个条件就可以取出这个对象。所以通过取出的数据肯定会有重复，所以要去掉重复项。
 *
 *  如果用list集合接收两次的返回对象，那么肯定是有重复对象在list集合中，一开始我想到的是TreeSet，但知道TreeSet存放对象，
 *
 *  一定要重写compareto方法，进行排序规则。
 *
 * 而我仅仅是去重，并不需要排序。 所以我就用了HashSet，下面也就缕一缕有关set集合的一些知识点。
 *
 *
 *  LinkedHashSet在迭代访问Set中的全部元素时，性能比HashSet好，但是插入时性能稍微逊色于HashSet。
 *
 */
public class day06 { 
    /**
     * 哈希值：
     *  是jdk中根据对象的地址或者字符串或者数字算出来的int类型的数值
     *
     *  object类中有一个方法可以获取对象的哈希值
     *      hashCode()返回对象的哈希码值
     *      通过类中的方法重写，可以返回我们指定的哈希值
     *
     */

    @Test
    public void hashSet(){
        /**
         * HashSet集合特点：
         *      1.底层数据结构是哈希表
         *      2.对集合的迭代顺序不做任何保证，
         *      3.没有带索引的方法，
         *      4.是set集合，不包含重复元素
         *
         *
         */
        HashSet<String> hs = new HashSet<>();
        hs.add("yechen");
        hs.add("xiaoming");
        hs.add("xiaohong");
        for (String h : hs) {
            System.out.println(h);
        }
    }

    @Test
    public void linkedhashset(){

        //创建集合对象
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("yechen");
        linkedHashSet.add("syq");
        linkedHashSet.add("lq");

        for (String s : linkedHashSet) {
            System.out.println(s);
        }
    }

    @Test
    public void treeSet(){
        /**
         * treeset的元素有序，可以按照一定的规则进行排序，具体发排序方式取决于构造方法
         *  使用compareTo来自定义排序规则
         *
         *  compareTo是自然排序规则，是使用类继承机制来实现
         *  comparator则是比较器规则，可以在生成对象的时候指定
         */
//        TreeSet<Integer> t = new TreeSet<>();
//
//        t.add(1);
//        t.add(4);
//        t.add(3);
//        for (Integer integer : t) {
//            System.out.println(integer);
//        }

        TreeSet<Student> treeSet = new TreeSet<>();
        Student s1 = new Student("yechen",20);
        Student s2 = new Student("siyuquan",23);
        Student s3 = new Student("luqiang",22);
        Student s4 = new Student("kaiqi",22);

        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        treeSet.add(s4);

        TreeSet<Student> treeSet1 = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                int num = s2.getAge() - s1.getAge();
                return num==0?s1.getName().compareTo(s2.getName()):num;
            }
        });

        for (Student student : treeSet) {
            System.out.println(student);
        }

    }

    @Test
    public void generic(){
        /**
         * 泛型类：
         *      定义格式；修饰符 class 类名<类型></>
         *      public class Generic<T></>
         *
         *      就是声明类后，在类名后面加上<T></>
         *
         * 泛型方法：
         *      public<T></> void show(T t){}
         *
         * 泛型接口：
         *      public interface Generic<T></>
         *
         * 类型通配符 <></>></>
         * List<?></>
         * 类型通配符的上限
         * List<? extends Number></>
         * 类型通配符的下限
         * List<? super Number></>
         *
         *
         * 可变参数
         * public static int sum(int ...a){   }
         *
         *
         *
         *
         */
    }

}
