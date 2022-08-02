package java刘意.thread.customer_producer;

/**
 * @date 2021/12/6 11:20
 */
public class Main {
    public static void main(String[] args) {

        //共享内存区域，奶箱
        Box box = new Box();

        //创建生产者，即送奶工
        Produec produec = new Produec(box);

        //创建消费者，即我
        Customer customer = new Customer(box);

        Thread t1 = new Thread(produec);
        Thread t2 = new Thread(customer);

        t1.start();
        t2.start();

    }
}
