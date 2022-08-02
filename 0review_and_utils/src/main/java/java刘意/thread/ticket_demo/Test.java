package java刘意.thread.ticket_demo;

/**
 * @date 2021/12/6 9:31
 */
public class Test {

    public static void main(String[] args) {

        SellTicket s1 = new SellTicket();

        //三个线程去执行同一个资源,如果声明三个s1，则是三个线程分别执行三个资源
        Thread t1 = new Thread(s1,"一号窗口");
        Thread t2 = new Thread(s1,"二号窗口");
        Thread t3 = new Thread(s1,"三号窗口");

        t1.start();
        t2.start();
        t3.start();

    }
}
