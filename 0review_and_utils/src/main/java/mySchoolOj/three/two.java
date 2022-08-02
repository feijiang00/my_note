package mySchoolOj.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        int m = cin.nextInt();
        int n = cin.nextInt();
        ArrayList<polynomial> M = new ArrayList<>();
        ArrayList<polynomial> N = new ArrayList<>();
//        polynomial p =new polynomial();

        for(int i=0;i<m;i++){
            polynomial p =new polynomial();
            p.coefficient=cin.nextInt();
            p.index=cin.nextInt();
            M.add(p);
        }

        for(int j=0;j<n;j++){
            polynomial p =new polynomial();
            p.coefficient=cin.nextInt();
            p.index=cin.nextInt();
            N.add(p);
        }

        //按指数降序排序
        Collections.sort(M);
        Collections.sort(N);

        ArrayList<polynomial> S = new ArrayList<>();
        int key =0;
        while(!M.isEmpty()&&!N.isEmpty()) {
            if (M.get(key).index == N.get(key).index) {
                polynomial p = new polynomial();
                p.index = M.get(key).index;
                p.coefficient = M.get(key).coefficient + N.get(key).coefficient;
                S.add(p);
                M.remove(key);
                N.remove(key);
            } else if (M.get(key).index > N.get(key).index) {
                polynomial p = new polynomial();
                p.index = M.get(key).index;
                p.coefficient = M.get(key).coefficient;
                S.add(p);
                M.remove(key);
            } else {
                polynomial p = new polynomial();
                p.index = N.get(key).index;
                p.coefficient = N.get(key).coefficient;
                S.add(p);
                N.remove(key);
            }
        }

//        会有一个list数组中多出一组数值
            if(!M.isEmpty()){
                polynomial p =new polynomial();
                p.index=M.get(key).index;
                p.coefficient=M.get(key).coefficient;
                S.add(p);
                M.remove(key);
            }
            if(!N.isEmpty()){
                polynomial p =new polynomial();
                p.index=N.get(key).index;
                p.coefficient=N.get(key).coefficient;
                S.add(p);
                N.remove(key);
            }

            Collections.sort(S);

//            for (polynomial it : S) {
//                System.out.print(it.coefficient+" "+it.index);
//                System.out.println();
//            }
        for(int k=0;k<S.size();k++){
            if(S.get(k).coefficient!=0)
            System.out.println(S.get(k).coefficient+" "+S.get(k).index);
        }

        cin.close();
    }
}

class polynomial implements Comparable<polynomial>{
    int coefficient;//系数
    int index;//指数


    @Override
    public int compareTo(polynomial t1) {
        return t1.index - this.index;
    }

}

