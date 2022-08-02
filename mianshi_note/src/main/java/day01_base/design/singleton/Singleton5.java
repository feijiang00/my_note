package day01_base.design.singleton;

/**
 * 内部类创建,利用静态内部类的“无私奉献”的精神
 * @date 2021/12/22 10:09
 */
public class Singleton5 {

    private static class Holder{
        static Singleton5 singleton5 = new Singleton5();
    }

    public static Singleton5 getInstance(){
        return Holder.singleton5;
    }
}
