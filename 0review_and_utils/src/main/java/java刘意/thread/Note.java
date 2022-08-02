package java刘意.thread;

/**
 * @date 2021/12/3 16:16
 */
public class Note {
    /**
     * 相比继承Thread，实现Runnable的接口的好处：
     *      避免了java单继承的局限性
     *      适合多个相同程序的代码去处理同一个资源的情况，把线程和程序的代码，数据有效分离，较好的体现了面向对象的设计思想
     *
     */



    /**
     * 多线程第一种实现方式：
     *      继承Thread类，并且重写run方法
     *      run()，封装线程执行的代码， 直接调用，相当于普通方法的调用
     *      start()，启动线程，然后由jvm调用此线程的run()方法
     * 线程调度：
     *      线程调用，java中采用抢占式调度模型
     *      getPriority() 返回此线程的优先级
     *      setPriority() 更改此线程的优先级
     *
     * 线程控制：
     *      sleep() 让当前的线程停留指定的毫秒数,比较好实现三足鼎立
     *      join() 等待这个线程死亡，只有这个线程死亡后，其他线程才可以开始运作
     *      setDaemon() 标记为守护线程，当这个线程死亡时，其他线程统统死亡
     */


    /**
     * 同步代码块，同步方法，加上关键字synchronized
     *      同步方法，加上synchronized，锁的对象是this
     *      同步静态方法，的锁对象是类名.class
     *
     *
     * lock锁
     *      lock锁是接口不能直接实例化，这里采用它的实现类ReentrantLock来实例化
     *      一般用法：
     *
     *      Lock lock = new ReentrantLock();
     *
     *      try{
     *          lock.lock();
     *          xxx
     *      }finally{
     *          lock.unlock();
     *      }
     *      这样做的好处就是，即使xxx中的业务代码出现了异常，也不影响lock锁的释放
     */

}
