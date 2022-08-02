package java刘意.IO.ObjectStream;

import org.junit.Test;

import java.io.*;

/**
 * 对象序列化流，用户将java对象序列化实现文件的持久存储，如果是网络套接字流则可以进行传输，在另一主机重构对象
 * 序列化需要注意是被序列化的对象需要实现一共serializable接口
 * 1.对象被序列化后，如果修改原本的类，再次被反序列化的时候会出现问题.
 * 原理：修改了类后，修改了该类的序列化id。解决：不使用默认的序列化id，自己写一个serialVersionUID
 *
 * 不想被被序列化，加上transient关键案字修饰，修饰变量则该变量不会被序列化，修饰类则类不会被序列化
 *
 * 为什么需要序列化：盲猜，安全，数据传输的可靠
 * @date 2021/12/3 11:11
 */
public class Output {
    @Test
    public void Out() throws IOException {

        File file = new File("D:\\00NoteBook\\java\\一次java培训的纪实\\代码笔记\\java复习\\src\\ObjectOutputStream.txt");
        OutputStream outputStream = new FileOutputStream(file);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            objectOutputStream.writeObject("a");
        }
    }
    //序列成功后是一串乱码，这时反序列能读懂
    @Test
    public void In() throws IOException, ClassNotFoundException {
        File file = new File("D:\\00NoteBook\\java\\一次java培训的纪实\\代码笔记\\java复习\\src\\ObjectOutputStream.txt");
        InputStream inputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        String s= (String) objectInputStream.readObject();
        System.out.println(s);
    }
}
