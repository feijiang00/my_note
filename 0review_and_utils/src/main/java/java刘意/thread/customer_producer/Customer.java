package java刘意.thread.customer_producer;

/**
 * @date 2021/12/6 11:11
 */
public class Customer implements Runnable{
    Box box ;
    Customer(){

    }
    Customer(Box box){
        this.box = box;
    }
    //消费者拿的必须是送奶工送的这个奶箱子啊
    @Override
    public void run() {
        while(true){
            box.getMilk();
        }
    }
}
