package day01_base.design.singleton;

/**
 * 饿汉式
 * @date 2021/12/21 16:28
 */
public class Singleton1 {

    private static final  Singleton1 singleton1 = new Singleton1();
    private Singleton1(){
        if(singleton1 != null){
            throw new RuntimeException("单例对象不能重复被创建");
        }
    };
    Singleton1 getSingleton1(){
        return singleton1;
    }

    //防止序列化破坏单例模式
    public Object readResolve(){
        return singleton1;
    }
}
