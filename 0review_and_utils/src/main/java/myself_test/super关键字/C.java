package myself_test.super关键字;

/**
 * Author:feijiang
 * Date: 2022/9/22 11:36
 */
public class C extends B{
    public void print(){
        System.out.println("C");
    }

    /*
    当我自己有print方法的时候，我还想使用父类的print方法，这时候，就需要super关键字
     */
    public void print2(){
        super.print();
    }


}
