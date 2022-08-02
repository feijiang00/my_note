package day04;

/**
 * @date 2022/2/24 7:15
 */
public class 使用synchronized保证原子性 {

    private static int i = 0;
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() ->{
           synchronized (obj){
                for(int j=0;j<5000;j++) {
                    i++;
                }
           }
        });

        Thread t2 =new Thread(() ->{
            synchronized (obj){
                for (int j=0;j<5000;j++){
                    i--;
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }

}
