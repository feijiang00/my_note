package day04;

/**
 * 原因：
 *  因为频繁的对run进入读写，那么jit即时编译器则会将其主内存的run变量将其放入高速缓存中，接下来，
 *  程序中主线程将run改成了false，只是主内存中的。高速缓存中的还是true，因此程序不会停下来。
 *  volatile则保证了可见性。
 *
 * @date 2022/2/24 7:29
 */
public class 可见性 {

    static volatile boolean run = true;//加上volatile则可以了

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() ->{
           while (run){

           }
        });

        t.start();
        Thread.sleep(1000);
        run=false;//线程t不会如预期想的停下来

    }
}
