package mySchoolOj.two;

import java.util.Scanner;

public class five {
    static int[] array= new int[11];
    public static void getnum(int n){
        int k;
        while(n/10!=0){
            k=n%10;
            array[k]++;
            n=n/10;
        }
        k=n%10;
        array[k]++;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        int num = cin.nextInt();
//        if(num>=1000000){
//            for(int i=1000001;i<=num;i++){
//                getnum(i);
//            }
//            array[0]+=488895;
//            array[1]+=600001;
//            for(int i=2;i<=9;i++){
//                array[i]+=600000;
//            }
//        }
//        else if(num>=100000000){
//            for(int i=100000001;i<=num;i++){
//                getnum(i);
//            }
//            array[0]+=68888897;
//            array[0]+=80000001;
//            for(int i=2;i<=9;i++){
//                array[i]+=80000000;
//            }
//        }
//        else if(num>=10000000){
//            for(int i=10000001;i<=num;i++){
//                getnum(i);
//            }
//            array[0]+=5888896;
//            array[0]+=7000001;
//            for(int i=2;i<=9;i++){
//                array[i]+=7000000;
//            }
//        }
//        else if(num>=1000000000){
//            for(int i=1000000001;i<=num;i++){
//                getnum(i);
//            }
//            array[0]+=788888898;
//            array[0]+=900000001;
//            for(int i=2;i<=9;i++){
//                array[i]+=900000000;
//            }
//        }
//        else {
            for (int i = 1; i <= num; i++) {
                getnum(i);
            }
//        }
        for(int i=0;i<=9;i++){
            System.out.println(array[i]);
        }
    }
}
