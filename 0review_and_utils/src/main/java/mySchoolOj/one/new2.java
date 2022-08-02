package mySchoolOj.one;

import java.util.Scanner;

public class new2 {
    static char a = 'A';
    static StringBuilder k = new StringBuilder();
//    public static StringBuilder getanswer(int n ){
//
//        if(n == 1) {
//            k.append(a);
//                return k;
//        }
//        else{
//            k.append(a);
//           String tmp = k.toString();
//            k = k.append(tmp);
//            k = k.append((char)(a+1));
//            k = k.append(tmp);
//            return getanswer(n=n-1);
//        }
//    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        int n = cin.nextInt();
        k.append(a);
        if(n==1){

        }else {
            for (int i = 1; i <= n; i++) {
                String tmp = k.toString();
                k = k.append(tmp);
                k = k.append((char) (a + n));
                k = k.append(tmp);
            }
        }
        System.out.println(k);
        cin.close();
    }
}
