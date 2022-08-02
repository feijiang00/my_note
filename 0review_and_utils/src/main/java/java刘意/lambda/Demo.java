package java刘意.lambda;

/**
 * @date 2021/12/7 15:19
 */
public class Demo {
    public static void main(String[] args) {

        //如果想写一个线程,方式一
//        Thread t1 = new MyThread();
//        t1.start();

        //方式二，匿名内部类
        //还是很麻烦
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("多线程启动了...");
//            }
//        }).start();


        //方式三，lambda表达式
        new Thread(() ->{
            System.out.println("多线程启动了");
        }).start();
        //非常的简洁啊~


        /**
         * lambda表达式标准格式:
         *      (形式参数) -> {代码块}
         *      形式参数：如果有多个参数，参数之间用逗号隔开，如果没有参数，留空即可
         *      ->：固定写法，代表动作
         *      代码块:写方法体的内容
         *
         * 使用前提：**有一个接口，接口中有且仅有一个抽象方法**
         */


    }
}
