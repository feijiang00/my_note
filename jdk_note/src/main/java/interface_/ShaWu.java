package interface_;

/**
 *
 * @date 2022/1/17 14:49
 */
public interface ShaWu {
    //jdk1.8之前，接口中只有抽象方法,public abstract可以省略
    public abstract void a();

    //jdk1.8新增了静态方法和默认方法
    //默认方法需要带上方法体
    public default void b(){};

    //并且新增了静态方法
    public static void c(){};
}
