package mySchoolOj.one;

import java.util.Scanner;

public class ten {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        String key[] = new String[16];
        key[0]="0000";
        key[1]="0001";
        key[2]="0010";
        key[3]="0011";
        key[4]="0100";
        key[5]="0101";
        key[6]="0110";
        key[7]="0111";
        key[8]="1000";
        key[9]="1001";
        key[10]="1010";
        key[11]="1011";
        key[12]="1100";
        key[13]="1101";
        key[14]="1110";
        key[15]="1111";
        while(cin.hasNextLine()){
            String str =cin.nextLine();
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='0')
                    System.out.print(key[0]);
                if(str.charAt(i)=='1')
                    System.out.print(key[1]);
                if(str.charAt(i)=='2')
                    System.out.print(key[2]);
                if(str.charAt(i)=='3')
                    System.out.print(key[3]);
                if(str.charAt(i)=='4')
                    System.out.print(key[4]);
                if(str.charAt(i)=='5')
                    System.out.print(key[5]);
                if(str.charAt(i)=='6')
                    System.out.print(key[6]);
                if(str.charAt(i)=='7')
                    System.out.print(key[7]);
                if(str.charAt(i)=='8')
                    System.out.print(key[8]);
                if(str.charAt(i)=='9')
                    System.out.print(key[9]);
                if(str.charAt(i)=='A')
                    System.out.print(key[10]);
                if(str.charAt(i)=='B')
                    System.out.print(key[11]);
                if(str.charAt(i)=='C')
                    System.out.print(key[12]);
                if(str.charAt(i)=='D')
                    System.out.print(key[13]);
                if(str.charAt(i)=='E')
                    System.out.print(key[14]);
                if(str.charAt(i)=='F')
                    System.out.print(key[15]);
            }
            System.out.println();
        }
        cin.close();
    }
}
