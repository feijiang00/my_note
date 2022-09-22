package myself_test.super关键字;

/**
 * Author:feijiang
 * Date: 2022/9/22 11:36
 */
public class Test {
    C c = new C();

    /**
     * 测试多继承情况下的super关键字
     */
    @org.junit.Test
    public void test(){
        /**
         * 不使用super关键字：默认情况下c调用自己的，自己没有去找上一个父类，上一个父类没有再找上一个
         *
         * 再使用super关键字：和上面一样的，去找最近的父类，最近的父类没有找上一个，还没有报错
         */
        c.print();

        c.print2();

    }
}
