package mySchoolOj.one;

import java.util.Scanner;

public class nine {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        int m=cin.nextInt();
        for(int i=0;i<m;i++){
            String str = cin.next();//用nextline错误是因为m后有个换行符
//            StringBuilder strb = new StringBuilder(str);
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)>='a'&&str.charAt(j)<='z'){
                  System.out.print((char)(str.charAt(j)-32));
                }
                if(str.charAt(j)>='A'&&str.charAt(j)<='Z'){
                    System.out.print((char)(str.charAt(j)+32));
                }
            }
           System.out.println();
        }

        cin.close();
    }
}
