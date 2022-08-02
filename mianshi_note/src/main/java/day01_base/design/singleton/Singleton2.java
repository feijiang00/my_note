package day01_base.design.singleton;

/**
 * 枚举饿汉式
 * @date 2021/12/21 16:39
 */
public enum Singleton2 {
    singleton2;
    private Singleton2(){}

    public static Singleton2 getInstance(){return singleton2;}
}
