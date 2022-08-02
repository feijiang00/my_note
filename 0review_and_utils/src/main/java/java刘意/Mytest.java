package java刘意;

/**
 * @author FeiJiang00
 * @date 2021/11/14 14:22
 */
public class Mytest {
    public static void main(String[] args) {

        int a=1;
        int b=a++ + ++a;
        System.out.println(b);
        System.out.println(a);

        int c=1;
        c=a++;
        System.out.println(c);

    }
}
