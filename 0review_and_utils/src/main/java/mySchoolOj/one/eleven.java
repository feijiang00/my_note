package mySchoolOj.one;

import java.util.Scanner;

public class eleven {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int m,n;
        m=cin.nextInt();
        n=cin.nextInt();

        char[][] ch = new char[51][101];
        int [] p = new int[51];
//        A[] a = new A[51];

//        for(int l=0;l<n;l++){
//            a[l] = new A();//这是重点！！！！！！！
//            String str =cin.next();
//            a[l].ch=str.toCharArray();
//            a[l].p=0;//逆序量
//        }
        for(int l=0;l<n;l++){
            ch[l] =cin.next().toCharArray();
            p[l] =0;
        }
        for(int l=0;l<n;l++){
            for(int i=0;i<m-1;i++){
                for(int j=i+1;j<m;j++){
//                    if(a[l].ch[i]>a[l].ch[j])
//                        a[l].p++;
                    if(ch[l][i]>ch[l][j])
                        p[l]++;
                }
            }
        }

        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
//                if(a[j].p>a[j+1].p){
//                    A tmp = a[j];
//                    a[j] = a[j+1];
//                    a[j+1] = tmp;
                if(p[j]>p[j+1]){
                    char[] tmp = new char[101];
                    tmp = ch[j];
                    ch[j]=ch[j+1];
                    ch[j+1]=tmp;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
//                System.out.print(a[i].ch[j]);
                System.out.print(ch[i][j]);
            System.out.println();
        }


        cin.close();
    }
}
// class A{
//    public  char[] ch = new char[101];
//    public  int p =0;
//}
