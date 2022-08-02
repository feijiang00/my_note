package java成神之路;

/**
 * @author FeiJiang00
 * @date 2021/11/11 15:29
 */
public class Volatile {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getSingleton();

    }
}

/**
 * 单例模式，使用volatile来实现
 */
class Singleton{
    private volatile static Singleton singleton;
    private Singleton(){}

    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton==null)
                    singleton=new Singleton();
            }
        }
        return singleton;
    }
}
