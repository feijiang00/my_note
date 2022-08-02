package day01;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 实现futureTask接口
 * 和Runnable比起来，futureTask拥有返回值，并且其返回值会阻塞调用它的主线程。
 * @date 2021/12/13 11:08
 */
@Slf4j(topic = "c.FutureTaskDemo")
public class FutureTaskDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

       FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
           @Override
           public Integer call() throws Exception {
               log.info("running");
               Thread.sleep(2000);
               return 100;
           }
       });

       Thread t1 = new Thread(futureTask);
       t1.start();

       //这里阻塞主线程，必须等到该方法返回值拿到
       log.info("{}",futureTask.get());

    }
}
