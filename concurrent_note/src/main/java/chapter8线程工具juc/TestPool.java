package chapter8线程工具juc;

import javafx.concurrent.Worker;
import org.omg.PortableServer.ThreadPolicy;

import java.sql.Connection;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程池的实现
 * @date 2022/3/1 15:52
 */
public class TestPool {

}

class ThreadPool{
    //任务队列
    private BlockingQueue<Runnable> taskQueue;

    //线程集合
    private HashSet<Worker> workers = new HashSet<>();

    //核心线程数
    private int coreSize;

    //获取任务的超时时间
    private long timeout;

    private TimeUnit timeUnit;

    //执行任务
    public void execute(Runnable task){
        //当任务书没用超过coreSize时，直接交给worke对象执行
        //当任务数超过了coreSize时，加入任务队列暂时存着
        synchronized (workers){
            if(workers.size()<coreSize){
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();
            }else {
                taskQueue.put(task);
            }
        }
    }

    public ThreadPool(int coreSize,long timeout,TimeUnit timeUnit,int queueCapcity){
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.taskQueue = new BlockingQueue<>(queueCapcity);
    }

    class Worker extends Thread{
        private Runnable task;

        public Worker(Runnable task){
            this.task = task;
        }


        public void run(){
            //执行任务
            //1.当task不为空，执行任务
            //2.当task执行完毕，再接着从任务队列获取任务并执行

            while (task != null){
                try{
                    task.run();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

    }

}

class BlockingQueue<T>{
    //任务队列
    private Deque<T>  deque = new ArrayDeque<>();

    //锁，
    private ReentrantLock lock = new ReentrantLock();

    //生产者条件变量
    private Condition fullWaitSet = lock.newCondition();

    //消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();

    //容量
    private int capcity;


    public BlockingQueue(int capcity) {
        this.capcity = capcity;
    }

    //带超时的阻塞获取
    public T poll(long timeout, TimeUnit unit){
        lock.lock();
        try{
            //将timeout统一转化为纳秒
            long nanos = unit.toNanos(timeout);
            while (deque.isEmpty()){
                try{
                    //返回的是剩余的时间
                    if(nanos<=0){
                        return null;
                    }
                    nanos = emptyWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = deque.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

    //阻塞获取
    public T take(){
        lock.lock();
        try{
            while (deque.isEmpty()){
                try{
                    emptyWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T t = deque.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

    //阻塞添加
    public void put(T element){
        lock.lock();
        try{
            while (deque.size() == capcity){
                try{
                    fullWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            deque.addLast(element);
            emptyWaitSet.signal();
        }finally {
            lock.unlock();
        }
    }

    //获取大小
    public int size(){
        lock.lock();
        try{
            return deque.size();
        }finally {
            lock.unlock();
        }
    }


}
