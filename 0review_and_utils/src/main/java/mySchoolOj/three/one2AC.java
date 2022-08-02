package mySchoolOj.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class one2AC {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        int n=cin.nextInt();
        int m =cin.nextInt();
//        computer[] comp = new computer[10];
        ArrayList<computer2> list = new ArrayList<>();
//        int num=0;  //学生编号
//        int N=6;
        while(cin.hasNextLine()){
            computer2 c = new computer2();
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
            list.add(c);
//            num++;
        }
//        System.out.println(list.size());
//        TreeSet set = new TreeSet();
////        for(int i)
//        Collections.addAll(list);
        Collections.sort(list, new Comparator<computer2>() {
            @Override
            public int compare(computer2 computer2, computer2 t1) {
                if(computer2.n!=t1.n){
                    return t1.n - computer2.n;
                }else {
                    if(computer2.score!=t1.score){
                        return computer2.score-t1.score;
                    }else
                        return computer2.name.compareToIgnoreCase(t1.name);
                }
            }
        });
        for(int i =0;i<list.size();i++){
            System.out.printf("%-11s",list.get(i).name);
            System.out.printf("%2d",list.get(i).n);
            System.out.printf("%5d\n",list.get(i).score);
//            System.out.println();
        }
    }
}

class computer2 {
    public String name;
    public int n=0;//ac的题数
    public int score=0;  //ac所用的时间
}

/**
 * 自定义排序（排序对象实现comparable接口的compareto方法
 */
//class computer2 implements Comparable<computer2>{
//    public String name;
//    public int n=0;//ac的题数
//    public int score=0;  //ac所用的时间
//
//    /**
//     * 需要实现的方法，实现升序排序，降序请反写
//     * this表示当前的对象
//     * @param computer2 比较时传入的对象
//     * @return
//     */
//    @Override
//    public int compareTo(computer2 computer2) {
//        if(computer2.n!=this.n)
//            return computer2.n - this.n;
//    }
//}

