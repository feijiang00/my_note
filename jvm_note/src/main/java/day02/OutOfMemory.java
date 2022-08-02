package day02;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2022/1/9 18:26
 */
public class OutOfMemory {
    public static void main(String[] args) throws InterruptedException {

        List<StringBuilder> list = new ArrayList<>();
        StringBuilder tmp = new StringBuilder(new String("a"));
        int i=0;
        while (true){
            tmp.append(tmp);
            list.add(tmp);
            System.out.println(i++);
            Thread.sleep(100);
        }

    }
}
