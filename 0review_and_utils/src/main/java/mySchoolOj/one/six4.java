package mySchoolOj.one;

import java.util.Scanner;

public class six4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int record = 0;
        if (a.length()>b.length()) {
            for (int i = 0; i < b.length(); i++) {
                record = a.charAt(i)==b.charAt(i)?record:++record;
            }
            record += 1;
        }else if(a.length()==b.length()) {
            for (int i = 0; i < b.length(); i++) {
                record = a.charAt(i)==b.charAt(i)?record:++record;
            }
        }else {
            for (int i = 0; i < a.length(); i++) {
                record = a.charAt(i)==b.charAt(i)?record:++record;
            }
            record += 1;
        }
        System.out.println(record);
    }
}
