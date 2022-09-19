package leetcode.editor.cn.myItem;

import org.junit.Test;

/**
 * @date 2021/12/17 11:10
 */
public class MyLinked {
   int key;
   MyLinked next;

   @Test
    public void test1(){
       MyLinked myLinked = new MyLinked();//头结点
       myLinked.next = null;

      MyLinked m1 = new MyLinked();
      m1.key = 1;
      m1.next = myLinked.next;
      myLinked.next = m1;

      MyLinked m2 = new MyLinked();
      m2.key = 2;
      m2.next = myLinked.next;
      myLinked.next = m2;

      myLinked = myLinked.next;//头结点没有数据
      while (myLinked !=null){
         System.out.println(myLinked.key);
         myLinked = myLinked.next;
      }


   }
}

