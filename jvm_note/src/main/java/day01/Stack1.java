package day01;

/**
 * 循环递归调用，导致栈内存溢出
 * @date 2022/1/2 19:35
 */
public class Stack1 {

    private static int count;

    public static void main(String[] args) {
        try{
            method();
        }catch (Throwable e){
            e.printStackTrace();
            System.out.println(count);
        }

    }
    public static void method(){
        count++;
        method();
    }
}
