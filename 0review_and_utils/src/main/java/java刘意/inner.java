package java刘意;

import org.junit.Test;

/**
 * @author FeiJiang00
 * @date 2021/11/11 20:30
 */
public class inner {
    /**
     * 内部类笔记
     *
     * 定义：内部类就是在一个类的内部创建的类
     * 声明：直接在一个类的内部进行声明，如果不是在函数中则是成员内部类，如果在函数中则是局部内部类
     * 实例化：外部类.内部类 变量名 = 外部类对象.new  内部类
     * 作用：内部类一般都是private的，这样外部则不能去实例化你的内部类，也就用不了方法，只能你自己去调用
     */


    @Test
    public void test(){
        Outer.Inner inner = new Outer().new Inner();
        inner.print();
    }

}

class Outer{

    int num = 10;

    public class Inner{
        public void print(){
            System.out.println("num="+num);
        }
    }
}
