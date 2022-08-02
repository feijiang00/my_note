package mySchoolOj.three;

import java.util.Scanner;

public class one {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        int n=cin.nextInt();
        int m =cin.nextInt();
        computer[] comp = new computer[10];
//        List <computer> list = new ArrayList<computer>();
        int num=0;  //学生编号
        int N=6;
        while(N-->0){
            computer c = new computer();
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
            comp[num]=c;
            num++;
        }
        System.out.println(comp.length);
        N=6;
//        TreeSet set = new TreeSet();
////        for(int i)
        for(int i =0;i<N;i++){
            System.out.printf("%-10s",comp[i].name);
            System.out.printf("%-2d",comp[i].n);
            System.out.printf("%-4d",comp[i].score);
            System.out.println();
        }
    }
}

class computer{
    public String name;
    public int n=0;//ac的题数
    public int score=0;  //ac所用的时间
}