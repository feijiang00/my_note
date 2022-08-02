package mySchoolOj.one;

import java.util.Scanner;

public class six5 {
    public static void main(String[] args) {
        Scanner cn = new Scanner(System.in);
        String strA = cn.nextLine();
        String strB = cn.nextLine();
        System.out.println(getDistance(strA,strB));
        cn.close();
    }
    public static int getDistance(String strA, String strB){
        if (strA.equals(strB)) {//若两个字符串相同，返回0
            return 0;
        }
        int lengthA=strA.length();
        int lengthB=strB.length();
        int length=Math.max(lengthA,lengthB);//找到两个字符串长度最大值定义，二维数组的长度
        int array[][]=new int[length+1][length+1];//申请一个二维数组，存储转移矩阵
        for(int i=0;i<=length;i++){//边界条件初始化
            array[i][0]=i;

        }
        for(int j=0;j<=length;j++){
            array[0][j]=j;
        }


        for(int i=1;i<=lengthA;i++){//状态转移方程
            for(int j=1;j<=lengthB;j++){
                array[i][j]=min(array[i-1][j]+1,
                        array[i][j-1]+1,
                        array[i-1][j-1]+(strA.charAt(i-1)==strB.charAt(j-1)?0:1));
            }
        }
        return array[lengthA][lengthB];
    }
    //取三个数中的最小值
    public static int  min(int a,int b, int c){
        return Math.min(Math.min(a,b),c);
    }

}
