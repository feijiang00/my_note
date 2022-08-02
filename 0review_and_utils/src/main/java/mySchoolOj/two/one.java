package mySchoolOj.two;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class one {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        Set set = new HashSet<Integer>();
        int n = cin.nextInt();
        for(int i=0;i<n;i++){
            int m =cin.nextInt();
            set.add(m);
        }
        Object[] array = set.toArray();
        Set sortset = new TreeSet<Integer>();
        sortset.addAll(set);
//        System.out.println(sortset);
//        Iterable it = (Iterable) sortset.iterator();
        for (Object tmp:sortset
             ) {
            System.out.println(tmp);
        }
        cin.close();
    }
}
