package mySchoolOj.two;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class eight {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        TreeSet<Double> maleTree = new TreeSet<Double>();
        TreeSet<Double> femaleTree = new TreeSet<Double>();
        int n = cin.nextInt();
        for(int i=0;i<n;i++){
            String str = cin.next();
            if(str.equals("male")){
                maleTree.add(cin.nextDouble());
            }else{
                femaleTree.add(cin.nextDouble());
            }
        }
        //格式化输出
        DecimalFormat df = new DecimalFormat("#0.00");
        //male升序；female降序
        TreeSet<Double> femaleReverseTree = (TreeSet<Double>) femaleTree.descendingSet();
        Iterator iterator;
        iterator = maleTree.iterator();
        while (iterator.hasNext()){
            System.out.print(df.format(iterator.next())+" ");
        }
        iterator = femaleReverseTree.iterator();
        System.out.print(df.format(iterator.next()));
        while ((iterator.hasNext())){
            System.out.print(" "+df.format(iterator.next()));
//            if(iterator.hasNext())
//                System.out.print(" ");
        }
        cin.close();
    }
}
