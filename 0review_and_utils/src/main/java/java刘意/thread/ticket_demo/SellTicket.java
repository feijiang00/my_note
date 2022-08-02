package java刘意.thread.ticket_demo;

/**
 * @date 2021/12/6 9:28
 */
public class SellTicket implements Runnable{
    public static int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while(true) {
            synchronized (obj){
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：第" + ticket + "票");
                    ticket--;
                }

            }
        }
    }
}
