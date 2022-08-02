package java刘意.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author FeiJiang00
 * @date 2021/11/14 15:04
 *
 */
public class Collection {
    /**
     * 有三个子接口，分别是set ，list ，queue，是单集合的老祖宗
     *
     *
      */
   @Test
   public void TestCollection(){

       List<String> c = new ArrayList<String>();
       //add remove contains isEmpty clear size
       c.add("a");
       c.add("b");
       c.remove("a");
       c.add("d");
       c.add("e");

       //迭代器
       Iterator iterator= c.iterator();
       while(iterator.hasNext()){
           System.out.println(iterator.next());
       }

       //下面看一个并发修改异常
       Iterator iterator1=c.iterator();
       while(iterator1.hasNext()){
           String s = (String) iterator1.next();
           if(s.equals("d")){
//               c.add("d");
           }
       }

       //此时只能使用for循环遍历
       for (String s : c) {
           System.out.println(s);
       }

       //这里可以不会报错，但是却一直运行
//       for(int i=0;i<c.size();i++){
//           System.out.println(c.get(i));
//           if(c.get(i).equals("d")){
//               c.add("d");
//           }
//       }


       //使用列表迭代器,可以在一边迭代的时候，添加元素！
       ListIterator<String> listIterator = c.listIterator();
       while(listIterator.hasNext()){
           System.out.println(listIterator.next());
           listIterator.add("e");
       }
       /**
        *
        at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1009)
        at java.base/java.util.ArrayList$Itr.next(ArrayList.java:963)
        */

       /**
        * 运行之后便会报错，来分析分析为什么会报错吧？看源码！（使用alt+f7可以方便找到类中的方法）：
        * final void checkForComodification() {
        *             if (modCount != expectedModCount)
        *                 throw new ConcurrentModificationException();
        *         }
        *  可以看到，当modcount和expetedModCount不一样的时候，便会throw抛出一个异常
        *  这里就不往下分析了，找到这两个变量，然后猜测，在迭代器使用next的时候，肯定改变了其中一个值，因此导致这两个变量
        *  不一样。
        *
        *  问题：那么这个方法存在的意义是什么？
        *  并发修改异常，
        */
   }
}
