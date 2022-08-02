package mySchoolOj.three;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class one3 {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        int n=cin.nextInt();
        int m =cin.nextInt();
//        computer[] comp = new computer[10];
//        ArrayList<computer> list = new ArrayList<>();
        TreeSet<computer3> set = new TreeSet<computer3>();
        int num=0;  //学生编号
        int N=6;
        while(N-->0){
            computer3 c = new computer3();
            c.name = cin.next();
            for(int i =0;i<n;i++){
                String tmp =cin.next(); //对于某个学生的n道题中某道题目的分数
                if(tmp.contains("(")){
                    //已经ac了，但是出错了
                    int error = tmp.charAt(tmp.length()-2) - 48; //出错次数,减去48表示从asii码转为阿拉伯数字
                    c.n++;
                    String[] ss = tmp.split("\\(");
                    Integer itmp = Integer.parseInt(ss[0]);
                    c.score+=itmp;
                    c.score+=m*error;
                }else{
                    //没有()的情况
                    Integer itmp = Integer.parseInt(tmp);
                    if(itmp<=0){
                        //没有ac出来

                    }else{
                        //一次就ac出来
                        c.n++;
                        c.score+=itmp;
                    }
                }
            }
            set.add(c);
            num++;
        }
        System.out.println(set.size());
        N=6;
//        TreeSet set = new TreeSet();
////        for(int i)
//        for(int i =0;i<N;i++){
//            System.out.printf("%-10s",list.get(i).name);
//            System.out.printf("%-2d",list.get(i).n);
//            System.out.printf("%-4d",list.get(i).score);
//            System.out.println();
//        }

//        Iterator iterator = set.iterator();
//        while(iterator.hasNext()){
//
//            System.out.println(iterator.);
//        }

        for(Iterator iter = set.iterator(); iter.hasNext(); ) {
            System.out.printf("asc : %s\n", iter.next());
        }

    }
}

/**
 * Treeset中为什么不能添加computer3这种类变量
 */
class computer3{
    public String name;
    public int n=0;//ac的题数
    public int score=0;  //ac所用的时间
}