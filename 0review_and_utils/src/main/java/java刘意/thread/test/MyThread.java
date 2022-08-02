package java刘意.thread.test;

/**
 * @date 2021/12/3 16:20
 */
public class MyThread extends Thread{

    public MyThread(){

    }
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i= 0;i<100;i++){
            System.out.println(getName()+i);
        }
    }
}
