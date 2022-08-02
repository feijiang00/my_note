package mySchoolOj.two;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class eight2 {
    public static void main(String[] args) {
        LinkedList<Double> l1 = new LinkedList<Double>();
        LinkedList<Double> l2= new LinkedList<Double>();
        Scanner cin = new Scanner(System.in);
        int T = cin.nextInt();
        String a;
        double b;
        while(T-->0){
            a = cin.next();
            b = cin.nextDouble();
            if(a.equals("female")){
                l2.add(b);
            }else{
                l1.add(b);
            }
        }
        Collections.sort(l2);
        Collections.sort(l1);
        while(!l1.isEmpty()){
            System.out.printf("%.2f ",l1.getFirst());
            l1.poll();
        }
        System.out.printf("%.2f",l2.getLast());
        l2.pollLast();
        while(!l2.isEmpty()){
            System.out.printf(" %.2f",l2.getLast());
            l2.pollLast();
        }
        System.out.println();
    }

}
