package atguigu.first.singleton;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

/**
 * @date 2022/1/14 21:22
 */
public class 单例设计 {
    /*
    懒汉式，
    饿汉式
    饿汉式 双检锁 dcl
    枚举类
    内部类
     */


}

/**
 * 懒汉式
 */
class Singleton{
    private Singleton(){};//构造器私有化
    private static final Singleton instance = new Singleton();
    public static Singleton getInstance() {
        return instance;
    }
}

/**
 * 饿汉式
 * 1.饿汉式是不能加final的，和懒汉式对比记忆
 * 2.理解饿汉式和懒汉式的区别，会写懒汉式，饿汉式也就很容易写出来了
 * 3.思考下，这种饿汉式多线程是不安全的，的加上synchronized关键字
 */
class Singleton3{
    //不就是声明之前为null吗，自信起来了吗？啊？？？这不好记吗？？？我不理解啊？？？
    private static Singleton3 instance = null;//饿汉式不能加final，对比记忆吧
    private Singleton3(){};
    public synchronized static Singleton3 getInstance(){
        if(instance==null)
            instance = new Singleton3();
        return instance;
    }
}

/**
 * 静态内部类,利用静态内部类的无私的特点
 */
class Singleton4{
    private static class S{
        public static final S instance = new S();
    }

    public S getInstance(){
        return S.instance;
    }
}

/**
 * dcl双检锁饿汉式
 * 之前的饿汉式的缺点：我们加了synchronized，那么每次都会进行判断
 * 其实，真正需要进行判断也就是只有一次，就是初始的时候需要进行判断，为null的时候
 * 为什么？因为，后序不为null的时候直接返回了啊。初始的时候判断是因为，防止线程在进行判断的时候切换，导致结果不正确
 *
 * 多理解一下吧，不太好记。
 */
class Singleton5{
    private static volatile Singleton5 instance = null;
    public static Singleton5 getInstance(){
        if(instance == null) {
            synchronized (Singleton5.class) {
                //synchronized移动位置，只需要对if判断锁住
                if (instance == null)
                    instance = new Singleton5();
            }
        }
        return instance;
    }
}
