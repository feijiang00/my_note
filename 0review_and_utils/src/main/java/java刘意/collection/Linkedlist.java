package java刘意.collection;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @author FeiJiang00
 * @date 2021/12/2 15:26
 */
public class Linkedlist {

    @Test
    public void test(){
        LinkedList linkedList = new LinkedList();

        linkedList.addFirst("1");
        linkedList.addFirst("2");
        linkedList.addLast("3");
        linkedList.addLast("4");
        for (Object o : linkedList) {
            System.out.println(o);
        }
    }
}
