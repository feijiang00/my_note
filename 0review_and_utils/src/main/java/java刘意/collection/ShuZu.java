package java刘意.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @date 2021/12/3 17:06
 */
public class ShuZu {

    @Test
    public void test(){
        int a[] = {1,2,3,4,5};

        for(int i =0;i<=4;i++){
            if(a[i] == 3)
                a[i]=4;
            System.out.println(a[i]);
        }

    }

    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for(int i=0;i<6;i++){
            if(list.get(i).equals(2)){
                System.out.println("xx");
                list.add(6);
            }
            System.out.println(list.get(i));
        }
    }
}
