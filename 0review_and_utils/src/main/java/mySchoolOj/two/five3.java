package mySchoolOj.two;

import java.util.Scanner;


/**
 * 统计数字问题 给定表示书的总页码的十进制整数m(1<= m <= 10的9次方)， 计算书的全部页码中分别用到多少次数字0，1，2，……，9
 *
 * @author John.Chang
 *
 * @version 1.0
 */

public class five3 {
    public static int [] count= new int[10];

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
//        System.out.print("请输入要计算和的页数：");
        int n = input.nextInt();
        solve(n);

        int len = (int)(Math.log10(n))+1;//也可以通过循环来计算
        for (int i = 0; i < len; i++) {//处理多计算的0，即减掉，
            count[0] -= (int)(Math.pow(10, i));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(count[i] + " ");
        }

    }

    public static void solve(int n){

        //Arrays.fill(count,0);
        //计算位数
        int len = (int)(Math.log10(n))+1;//也可以通过循环来计算
        //System.out.println(len);
        //最高位的值,同时也是划分区间的个数
        int value_hight = n/(int)(Math.pow(10, len-1));
        //System.out.println(value_hight);

        /*
         * 这个循环计算划分的单个区间的0-9的个数再乘上区间数
         */
        for (int i = 0; i < 10; i++) {
            //原公式为n*10^n-1,n是位数，因为是先把最高位去掉了所有是n=len-1
            count[i] += value_hight*(len-1)*(int)(Math.pow(10, len-2));
            //System.out.println(count[i] + " ");
        }

        /*
         * 这个循环计算最高位出现的次数
         */
        for (int i = 0; i < value_hight; i++) {
            count[i] += (int)(Math.pow(10, len-1)) ;//最高位数字*相应的位置倍数
            //System.out.println(count[i] + " ");
        }

        int low = (int)(Math.pow(10, len-1));//除去最高位的10的倍数
        low = n%low; // 取余，把最高位去掉，比如567%100（上面算的low）=67
        if(low == 0){ //如果low为0
            count[value_hight]++; //说明是600%100=0这种情况，直接最高位加1就好了
            count[0]+=len-1;//0的个数加上除去最高位的位数个数len-1 -> 如600，3-1=2;
            return;
        }else{
            int lenT = (int)(Math.log10(low))+1;//计算除去高位后低位的位数，如67的位数
            if(lenT != len-1){//就是1001中间有零的这种情况，中间的零也要算上
                count[0] += (len-lenT-1)*(low+1);//总位数-去算得的位数-1是高位就得中间零的个数，在乘上算得的低位
                count[value_hight] +=1+low; //高位刚刚算了几个区间的还有本身的比如567的5出现的次数还要加上67+1=68
                solve(low);//继续递归
            }else{//中间没0的情况
                count[value_hight] +=1+low; //高位刚刚算了几个区间的还有本身的比如567的5出现的次数还要加上67+1=68
                solve(low);//继续递归
            }
        }
    }

}
