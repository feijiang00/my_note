package java刘意.thread.customer_producer;

/**
 * @date 2021/12/6 11:16
 */
public class Produec implements Runnable{
    private  Box b;

    public Produec(Box b){
        this.b = b;
    }

    @Override
    public void run() {
        //生产者开始投奶
        for(int i=1;i<=10;i++){
            b.inputMilk(i);
        }
    }
}
