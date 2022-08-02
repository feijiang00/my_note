package mySchoolOj.two;

import java.util.Scanner;

/**
 * @author
 * @version
 */
public class six {
    static int[] book = new int[2000001];
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        int n = cin.nextInt();
        for(int i=0;i<n;i++){
            book[cin.nextInt()]++;
        }
        int key=0;
        int s=0;
        for(int i=0;i<n;i++){
            if(key<book[i]){
                key=book[i];
                s=i;
            }
        }
        System.out.println(s);
        System.out.println(key);
        cin.close();
    }
}
