package chapter04.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * 转账，多线程模拟
 * 这里转账和之前的i++，i--不一样，他需要锁两个对象，this和target，也就是例子中的a和b
 * 因此，这里写synchronized（this）是不管用的，这就相当于线程八锁（之前的练习）中，锁了两个对象一样，或者是只对一个加锁一样
 * 这里需要给Account加锁，但是效率很低，后面会有更好的方法，这里flag一下。
 *
 *
 */
@Slf4j(topic = "c.ExerciseTransfer")
public class ExerciseTransfer {
    public static void main(String[] args) throws InterruptedException {
        Account a = new Account(1000);
        Account b = new Account(1000);
        Thread t1 = new Thread(() -> {
            //类似之前学的两个线程对i进行++或者--的操作呗
            for (int i = 0; i < 1000; i++) {
                a.transfer(b, randomAmount());
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                b.transfer(a, randomAmount());
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        // 查看转账2000次后的总金额
        log.debug("total:{}", (a.getMoney() + b.getMoney()));
    }

    // Random 为线程安全
    static Random random = new Random();

    // 随机 1~100
    public static int randomAmount() {
        return random.nextInt(100) + 1;
    }
}

// 账户
class Account {
    private int money;

    public Account(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    // 转账
    public void transfer(Account target, int amount) {
        synchronized(Account.class) {
            if (this.money >= amount) {
                this.setMoney(this.getMoney() - amount);
                target.setMoney(target.getMoney() + amount);
            }
        }
    }
}
