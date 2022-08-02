package java刘意.lambda;

/**
 * @date 2021/12/7 15:20
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        //我是蜜蜂，我不要昆虫的攻击，我要自己的攻击
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
    }
}
