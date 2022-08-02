package mySchoolOj.two;

import java.util.Scanner;

public class four2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
        int[] a = new int[cin.nextInt()];
        int[] b = new int[cin.nextInt()];
        for (int i = 0; i < a.length; i++) {
            a[i] = cin.nextInt();

        }
        for (int i = 0; i < b.length; i++) {
            b[i] = cin.nextInt();
        }

        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b.length; j++) {
                int cur = Math.abs(a[i] - b[j]);
                if (cur < min) min = cur;
            }
        System.out.println(min);
        cin.close();
    }
}
