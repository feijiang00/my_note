package day01;

import lombok.Data;

/**
 * @date 2022/1/21 10:16
 */
@Data
public class People implements Comparable<People>{
    private String name;
    private Integer age;

//    public boolean void Comp
    /**
     * 这里我想去重写Comparable方法，实现排序规则，发现重写不了，
     * 为什么？
     * 你没有实现接口？这是接口的第几个作用，抽象出功能
     * 当你实现了这个接口的实现，你就能够自动重写这个方法
     */
    @Override
    public int compareTo(People o) {
        return this.age = o.getAge();
    }
}
