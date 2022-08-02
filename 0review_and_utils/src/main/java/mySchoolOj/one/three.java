package mySchoolOj.one;

import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        int n = cin.nextInt();
        int i=0;
        int sum=0;
        for(i=1;;i++){
            sum=i*i*i+sum;
            if(sum>n)
                break;
        }
        System.out.println(i-1);
        cin.close();
    }
}
