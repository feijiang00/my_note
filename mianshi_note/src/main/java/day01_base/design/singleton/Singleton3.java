package day01_base.design.singleton;

/**
 * 懒汉式
 * @date 2021/12/22 9:17
 */
public class Singleton3 {

    private static Singleton3 singleton3 = null;

    //多线程环境下需要加上synchronized关键字
    public static synchronized Singleton3 getInstance(){
        if(singleton3 == null){
            singleton3 = new Singleton3();
        }
        return singleton3;
    }

    /**
     * 思考下，多线程加了synchronized关键字，确确实实保证了多线程，但优缺点吗？
     *      答案是有的：因为我们只需要在第一次的时候进行加锁，第二次都不为null了，肯定不用加锁了
     *      那么，这种该如何实现？
     *      请看下面的dcl双检锁
     */
}
