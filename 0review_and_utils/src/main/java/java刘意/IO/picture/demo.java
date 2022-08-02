package java刘意.IO.picture;

import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @date 2021/12/3 10:22
 */
public class demo {

    @Test
    public void test(){
        System.getProperty("user.dir");
    }

    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        File file = new File("D:\\00NoteBook\\java\\一次java培训的纪实\\代码笔记\\java复习\\src\\demo.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        System.out.println(bufferedOutputStream);
        fileOutputStream.write(97);
        fileOutputStream.write(98);
        fileOutputStream.write(99);
//        bufferedOutputStream.write("hello\r\n".getBytes());
//        bufferedOutputStream.write("hello\r\n".getBytes());
//        bufferedOutputStream.write("hello\r\n".getBytes());


    }
}
