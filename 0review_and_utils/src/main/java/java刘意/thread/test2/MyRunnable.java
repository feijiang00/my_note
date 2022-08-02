package java刘意.thread.test2;

/**
 * @date 2021/12/6 9:08
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {

        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}
