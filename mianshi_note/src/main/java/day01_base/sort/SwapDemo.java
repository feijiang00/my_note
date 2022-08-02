package day01_base.sort;

/**
 * @date 2021/12/16 8:53
 */
public class SwapDemo {
    public static void main(String[] args) {
        int a=1,b=2;
        swap(a,b);
        System.out.println("a="+a+",b="+b);

    }

    public static void swap(int a,int b){
        int tmp =a;
        a=b;
        b=tmp;
    }
}
