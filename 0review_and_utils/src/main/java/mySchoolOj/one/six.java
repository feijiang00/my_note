package mySchoolOj.one;

import java.util.Scanner;

public class six {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 =in.nextLine();
        String s2 =in.nextLine();
        int len1=s1.length(),len2=s2.length();  //计算出长度差即为需要操作的数目a
        int min =Math.min(len1, len2),max=Math.max(len1, len2);
        int equ=0; //统计两个串中相同的字符个数
        for(int i=0;i<len1;i++) {
            for(int j=0;j<len2;j++) {
                if(s1.charAt(i)==s2.charAt(j))
                    equ++;
            }
        }
        System.out.println((max-min+min-equ)); //长度差a+还需修改的次数b

    }
}
