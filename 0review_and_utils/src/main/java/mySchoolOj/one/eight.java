package mySchoolOj.one;

import java.util.Scanner;

/*
* cin.next()不会吸收回车，空格和tab只要遇到回车，空格和Tab就会停止。
cin.nextLine()吸收空格和tab，遇到回车停止。
* */
public class eight {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        int array[] = new int[27];
        while(cin.hasNextLine()){
            String str = cin.nextLine();
            boolean key=false;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='a'||str.charAt(i)=='A')
                    array[0]++;
                if(str.charAt(i)=='b'||str.charAt(i)=='B')
                    array[1]++;
                if(str.charAt(i)=='c'||str.charAt(i)=='C')
                    array[2]++;
                if(str.charAt(i)=='d'||str.charAt(i)=='D')
                    array[3]++;
                if(str.charAt(i)=='e'||str.charAt(i)=='E')
                    array[4]++;
                if(str.charAt(i)=='f'||str.charAt(i)=='F')
                    array[5]++;
                if(str.charAt(i)=='g'||str.charAt(i)=='G')
                    array[6]++;
                if(str.charAt(i)=='h'||str.charAt(i)=='H')
                    array[7]++;
                if(str.charAt(i)=='i'||str.charAt(i)=='I')
                    array[8]++;
                if(str.charAt(i)=='j'||str.charAt(i)=='J')
                    array[9]++;
                if(str.charAt(i)=='k'||str.charAt(i)=='K')
                    array[10]++;
                if(str.charAt(i)=='l'||str.charAt(i)=='L')
                    array[11]++;
                if(str.charAt(i)=='m'||str.charAt(i)=='M')
                    array[12]++;
                if(str.charAt(i)=='n'||str.charAt(i)=='N')
                    array[13]++;
                if(str.charAt(i)=='o'||str.charAt(i)=='O')
                    array[14]++;
                if(str.charAt(i)=='p'||str.charAt(i)=='P')
                    array[15]++;
                if(str.charAt(i)=='q'||str.charAt(i)=='Q')
                    array[16]++;
                if(str.charAt(i)=='r'||str.charAt(i)=='R')
                    array[17]++;
                if(str.charAt(i)=='s'||str.charAt(i)=='S')
                    array[18]++;
                if(str.charAt(i)=='t'||str.charAt(i)=='T')
                    array[19]++;
                if(str.charAt(i)=='u'||str.charAt(i)=='U')
                    array[20]++;
                if(str.charAt(i)=='v'||str.charAt(i)=='V')
                    array[21]++;
                if(str.charAt(i)=='w'||str.charAt(i)=='W')
                    array[22]++;
                if(str.charAt(i)=='x'||str.charAt(i)=='X')
                    array[23]++;
                if(str.charAt(i)=='y'||str.charAt(i)=='Y')
                    array[24]++;
                if(str.charAt(i)=='z'||str.charAt(i)=='Z')
                    array[25]++;
                if(str.charAt(i)=='#')
                    key=true;
            }
            if(key)
                break;;
        }
            System.out.println("a "+array[0]);
            System.out.println("b "+array[1]);
            System.out.println("c "+array[2]);
            System.out.println("d "+array[3]);
            System.out.println("e "+array[4]);
            System.out.println("f "+array[5]);
            System.out.println("g "+array[6]);
            System.out.println("h "+array[7]);
            System.out.println("i "+array[8]);
            System.out.println("j "+array[9]);
            System.out.println("k "+array[10]);
            System.out.println("l "+array[11]);
            System.out.println("m "+array[12]);
            System.out.println("n "+array[13]);
            System.out.println("o "+array[14]);
            System.out.println("p "+array[15]);
            System.out.println("q "+array[16]);
            System.out.println("r "+array[17]);
            System.out.println("s "+array[18]);
            System.out.println("t "+array[19]);
            System.out.println("u "+array[20]);
            System.out.println("v "+array[21]);
            System.out.println("w "+array[22]);
            System.out.println("x "+array[23]);
            System.out.println("y "+array[24]);
            System.out.println("z "+array[25]);
        cin.close();
    }
}
