package 互联网java1000道题;

public class test extends father{
    public void fun2(){
        fun(); //我直接调用你，不需要加this
        Object object = this;
        System.out.println(object.getClass());
    }


    public static void main(String[] args) {

        test test = new test();
        test.fun2();
    }
}


