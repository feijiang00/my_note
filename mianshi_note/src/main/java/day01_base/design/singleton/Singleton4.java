package day01_base.design.singleton;

/**
 * DCL懒汉式 双检锁
 * @date 2021/12/22 9:23
 */
public class Singleton4 {
    /**
     * 首先这玩意怎么写出来？很好记就是在多线程下的懒汉式上加个if判断
     */
    //这里为什么需要volatile？
    //这里用到了volatile的解决指令重排序的功能
    //底层中，一个线程创建单例，经过以下：
    //1.new Singleton4 2.调用构造方法Singleton4（） 3.赋值singleton4 = 对象
    //但是这些指令可以会颠倒，如果先是3.赋值singleton4 = 对象 那么另一个线程判断不等于null直接返回了，
    //这时就会出现问题，因为2.调用构造方法Singleton4（）还没执行
    private static volatile Singleton4 singleton4 = null;

    public static Singleton4 getInstance(){

        if(singleton4 == null){
            synchronized (Singleton4.class){
                //这里如果，没有第二次检查的话，线程1创建后，退出synchronized代码块，线程2如果恰巧是从synchronized上一行过来
                //也就是已经判断了singleton4 == null ，这时不管三七二十一，线程2又创建了一个singleton4
                if(singleton4 == null){
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
