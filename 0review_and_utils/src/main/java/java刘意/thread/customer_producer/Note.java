package java刘意.thread.customer_producer;

/**
 * @date 2021/12/6 11:30
 */
public class Note {
    /**
     * 不加变量状态s会出现这样情况：
     * 喝奶的拿到第1: 奶
     * 喝奶的拿到第1: 奶
     * 喝奶的拿到第1: 奶
     * 喝奶的拿到第1: 奶
     * 喝奶的拿到第1: 奶
     * 喝奶的拿到第1: 奶
     * 喝奶的拿到第1: 奶
     * 喝奶的拿到第1: 奶
     * 喝奶的拿到第1: 奶
     * 喝奶的拿到第1: 奶
     * 喝奶的拿到第1: 奶
     * 喝奶的拿到第1: 奶
     * 送奶工将第1: 奶放入
     * 送奶工将第2: 奶放入
     * 送奶工将第3: 奶放入
     * 送奶工将第4: 奶放入
     * 送奶工将第5: 奶放入
     * 送奶工将第6: 奶放入
     * 送奶工将第7: 奶放入
     * 喝奶的拿到第1: 奶
     * 送奶工将第8: 奶放入
     * 送奶工将第9: 奶放入
     * 喝奶的拿到第8: 奶
     * 送奶工将第10: 奶放入
     * 喝奶的拿到第10: 奶
     * 喝奶的拿到第10: 奶
     *
     * 喝奶的一直喝，一直拿，因为线程是随机抢占的，也不管奶箱有没有，喝奶的就去拿，肯定是不对的
     *
     *
     *
     * 这个时候需要一个变量state来帮忙：private boolean state = false;
     *
     * 并且在使用wait的方法内，需要加上synchronized关键字
     *
     * 使用wait后的情况：
     * 送奶工将第1: 奶放入
     * 喝奶的拿到第1: 奶
     *
     * 为什么？因为没有唤醒,加上notifyAll();
     *
     * 最终效果：
     * E:\jdk\bin\java.exe "-javaagent:E:\Developement\IntelliJ IDEA 2021.1\lib\idea_rt.jar=11080:E:\Developement\IntelliJ IDEA 2021.1\bin" -Dfile.encoding=UTF-8 -classpath D:\00NoteBook\java\一次java培训的纪实\代码笔记\out\production\java复习;C:\Users\江野\.m2\repository\junit\junit\4.13.1\junit-4.13.1.jar;C:\Users\江野\.m2\repository\org\hamcrest\hamcrest-core\1.3\hamcrest-core-1.3.jar;D:\00NoteBook\java\一次java培训的纪实\代码笔记\lib\junit-4.13.1.jar;D:\00NoteBook\java\一次java培训的纪实\代码笔记\lib\hamcrest-core-1.3.jar java刘意.thread.customer_producer.Main
     * 送奶工将第1: 奶放入
     * 喝奶的拿到第1: 奶
     * 送奶工将第2: 奶放入
     * 喝奶的拿到第2: 奶
     * 送奶工将第3: 奶放入
     * 喝奶的拿到第3: 奶
     * 送奶工将第4: 奶放入
     * 喝奶的拿到第4: 奶
     * 送奶工将第5: 奶放入
     * 喝奶的拿到第5: 奶
     * 送奶工将第6: 奶放入
     * 喝奶的拿到第6: 奶
     * 送奶工将第7: 奶放入
     * 喝奶的拿到第7: 奶
     * 送奶工将第8: 奶放入
     * 喝奶的拿到第8: 奶
     * 送奶工将第9: 奶放入
     * 喝奶的拿到第9: 奶
     * 送奶工将第10: 奶放入
     * 喝奶的拿到第10: 奶
     *
     */
}
