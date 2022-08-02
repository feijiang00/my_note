package mySchoolOj.one;


import java.util.Scanner;

public class one {
        static boolean check(String s){
            String t =new StringBuffer(s).reverse().toString();
            return s.equals(t);
        }

        public static void main(String[] args) {
            Scanner cin = new Scanner(System.in);
            //TODO
            while(cin.hasNext()){
                String s =cin.next();
                if(check(s)){
                    System.out.println("Y");
                }else{
                    System.out.println("N");
                }
            }
            cin.close();
        }
}

