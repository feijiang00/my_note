package java刘意.collection;

/**
 * @Author: feiJiang
 * @Date: 2021/05/10/16:59
 * @Description:
 */

/**
 * 当使用treeset来存储对象的时候，需要重写CompareTo方法
 *
 */
public class Student implements Comparable<Student>{
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student s) {

        int num = this.age-s.age;

        int num2 = num==0 ? this.name.compareTo(s.name):num;
        return num2;

//        return -1;表示后面的元素小于前面的元素，是倒叙
//        return 1;表示后面的元素大于前面的元素，是正序
//        return 0;//表示元素重复，不插入
    }



}
