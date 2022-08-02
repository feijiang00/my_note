package mySchoolOj.one;

import java.util.Scanner;
import java.util.regex.Pattern;

//*
// 没考虑ip为空的情况，写了很久*/
public class last {
    public static boolean isInteger(String str) {
        if(str == null)
            return false;
        Pattern pattern = Pattern.compile("^(([0-9]|([1-9]\\d)|(1\\d\\d)|(2([0-4]\\d|5[0-5]))))$");
        return pattern.matcher(str).matches();
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        while(cin.hasNextLine()){
            String str = cin.nextLine();
            if(str.equals("End of file"))
                break;
            String s[] =str.split("\\.");
            boolean k = true;
            if(s.length<4)
                k=false;
            for(int i=0;i<s.length;i++){
                if(!isInteger(s[i]))
                    k=false;
            }
            if(k)
                System.out.println("Y");
            else
                System.out.println("N");
        }
        cin.close();
    }
}
