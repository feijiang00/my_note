package myself_test;

/**
 * 想要写死锁，就得先分析，死锁的产生，两个线程抢夺两个资源，互不放手
 * @date 2022/3/4 8:16
 */
public class 死锁 {

    public static void main(String[] args) throws InterruptedException {
        Object object1 = new Object();
        Object object2 = new Object();
        Thread thread = new Thread(() ->{
           synchronized (object1){
               System.out.println("t1->拿到锁1");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               synchronized (object2){
                   System.out.println("t1->争夺锁2");
               }
           }
        });
        Thread thread1 = new Thread(()->{
            synchronized (object2){
                System.out.println("t2->拿到锁2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1){
                    System.out.println("t2->争夺锁1");
                }
            }
        });

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }
}
