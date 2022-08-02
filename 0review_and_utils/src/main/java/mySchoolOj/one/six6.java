package mySchoolOj.one;

import java.util.Scanner;

public class six6 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        char [] ch1 = new char[201];
        char [] ch2 = new char[201];
        ch1 = cin.nextLine().toCharArray();
        ch2 = cin.nextLine().toCharArray();
        if(ch1.length<ch2.length){
            char [] ch3 = new char[201];
            ch3 = ch1;
            ch1 = ch2;
            ch2 = ch3;
        }
        int len1 = ch1.length;
        int len2 = ch2.length;
        int sameindex=0,i=0,j=0,dif=0;
        boolean k=false;
        for(i=0,sameindex = 0; i<len1;i++){
            for(j=sameindex,k=false;j<len2&&(!k);j++){
                if(ch1[i] == ch2[j]){
                    sameindex=++j;
                    k=true;
                }
            }
            if(!k) dif++;
        }
        System.out.println(dif);
        cin.close();
    }
}
