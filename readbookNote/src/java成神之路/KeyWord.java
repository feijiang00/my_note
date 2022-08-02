package java成神之路;

import org.testng.annotations.Test;

/**
 * @author FeiJiang00
 * @date 2021/11/11 15:21
 */
public class KeyWord {

    public static void main(String[] args) {

//        transient关键字
        //简单点说，就是被 transient 修饰的成员变量，在序列化的时候其值会被忽略，在被反
        //序列化后， transient 变量的值被设为初始值， 如 int 型的是 0，对象型的是 null



    }

    @Test
    public  void testInstanceof(){
        //instanceof
        A a = new A();
        System.out.println(a instanceof A);
    }

    @Test
    public void testFinal(){

        final int  a = 1;
//        a=2;  这样写会直接报错

        String  str1 = "abc";
        String  str2 = "abc";
        String  str3 = new String("abc");
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

    }


}

class A{

}


