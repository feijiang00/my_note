package mySchoolOj.one;

import java.util.Scanner;

public class seven {
    static int getmax(String str){
        int sum=65;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)>sum)
                sum=str.charAt(i);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        while(cin.hasNextLine()){
            String str = cin.nextLine();
            int k =getmax(str);
            for(int i=0;i<str.length();i++){
                if(str.charAt(i) == k)
                    System.out.print(str.charAt(i)+"(max)");
                else
                    System.out.print(str.charAt(i));
            }
            System.out.println();
        }
        cin.close();
    }
}
