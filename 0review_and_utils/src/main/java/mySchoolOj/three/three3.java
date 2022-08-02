package mySchoolOj.three;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by c on 2017/7/29.
 */
public class three3  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String , Integer> hashMap = new HashMap<String , Integer>();
        while(scanner.hasNext()){
            String s = scanner.nextLine();
            if(s.equals("%%%"))break;
            String [] ss = s.split(" ");
            Integer put = new Integer(ss[2]);
            hashMap.put(ss[0],put);
        }
        while(scanner.hasNext()){
            String s1 = scanner.nextLine();
            String[] ss1 = s1.split(" ");
            Integer sum = hashMap.get(ss1[0]);
            for(int i = 1; i < ss1.length; i+=2){
                if(ss1[i].equals("+")){
                    sum+=hashMap.get(ss1[i+1]);
                }
                else if(ss1[i].equals("-")){
                    sum-=hashMap.get(ss1[i+1]);
                }
                else if(ss1[i].equals("*")){
                    sum*=hashMap.get(ss1[i+1]);
                }
            }
            System.out.println(sum);
        }
    }
}
