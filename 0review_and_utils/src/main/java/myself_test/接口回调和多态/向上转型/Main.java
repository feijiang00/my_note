package myself_test.接口回调和多态.向上转型;

/**
 * Author:feijiang
 * Date: 2022/9/21 14:23
 */
public class Main {

    public static void main(String[] args) {

        /**
         * 向上转型
         */
        ABC abc1 = new AB();
        abc1.callback();//AB,向上转型有了扩展,但是丢失了子类AB中的callback2()方法

        //因此向下转型的意义：找回callback2方法

        /**
         * 向下转型
         */
//        ABC abc = new AB();

        AB ab = null;
        if (abc1 instanceof ABC) {
            ab = (AB) abc1; //这里ab1变成了父类，强制转型；也就是父类abc被赋值给子类ab1，向下转型
        }

        //可以看到向下转型，子类
        ab.callback();
        ab.callback2();
    }
}
