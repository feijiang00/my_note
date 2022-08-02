package mySchoolOj.two;

import java.util.Scanner;

public class five2 {
    static Scanner cin = new Scanner(System.in);
        public static void main(String[] args) {
            int[] a = new int[10];//a[i]记录i出现的次数i=0~9
            int n = cin.nextInt();
            for (int p = 1; p <= n; p++) {
                int j = p;
                while (j > 0) {
                    int d = j % 10;
                    a[d]++;
                    j /= 10;
                }
            }
            for (int i : a) System.out.println(i);
            cin.close();
        }
}
