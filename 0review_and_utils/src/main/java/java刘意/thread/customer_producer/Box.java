package java刘意.thread.customer_producer;

/**
 * @date 2021/12/6 10:59
 */
public class Box {
    //牛奶箱
    private int milk;

    //加入变量，奶箱状态
    private boolean state = false;
    //生成者放牛奶
    public synchronized void inputMilk(int milk){
        //如果有牛奶，就进入wait状态
        if(state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有牛奶，就生产牛奶
        this.milk = milk;
        System.out.println("送奶工将第" + this.milk +": 奶放入");
        //生成完成后，修改奶箱子状态
        state = true;
        notifyAll();
    }

    //消费者拿牛奶
    public synchronized void getMilk(){
        //如果没有牛奶，那怎么办，不拿！等待
        if(!state){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //有牛奶，肯定拿呗
        System.out.println("喝奶的拿到第"+ this.milk + ": 奶");
        state = false;
        notifyAll();
    }
}
