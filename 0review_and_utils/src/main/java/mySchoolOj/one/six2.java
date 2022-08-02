package mySchoolOj.one;

import java.util.Scanner;

//*
// ac过的！！！！！！！！！！*/
public class six2 {
    static int dp[][] = new int[300][300];
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String m = sc.next();
        String n = sc.next();
        char a[] = m.toCharArray();
        char b[] = n.toCharArray();
        int x = a.length, y = b.length;
        char c[] = new char[a.length + 1];
        char d[] = new char[b.length + 1];
        for (int i = 1; i <= a.length; i++) c[i] = a[i - 1];
        for (int i = 1; i <= b.length; i++) d[i] = b[i - 1];
        for (int i = 0; i < a.length + 1; i++)
        {
            for (int j = 0; j < b.length+1; j++)
            {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= a.length; i++)
        {
            for (int j = 1; j <= b.length; j++)
            {
                if (c[i] == d[j])dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        x= Math.max(x,y);
        System.out.println(x - dp[a.length][b.length]);
    }
}
