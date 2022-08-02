package mySchoolOj.two;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class four {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        Set set = new TreeSet();
        Set set2 = new TreeSet();
        int n =cin.nextInt();
        int m = cin.nextInt();
        int k;
        for(int i =0;i<n;i++){
            k=cin.nextInt();
            set.add(k);
        }

        for(int i =0;i<m;i++){
            k=cin.nextInt();
            set2.add(k);
        }
        System.out.println(Math.min(Math.abs((int) ((TreeSet) set).last()-((int)((TreeSet) set2).first())),Math.abs((int)((TreeSet) set).first()-((int)((TreeSet) set2).last()))));
        cin.close();
    }
}
