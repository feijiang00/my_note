package mySchoolOj.two;

import java.util.*;

/*
* ArrayList 顺序队列（数组），当你删除一个数后，后面的所有数（下标）会向前进一*/
public class three {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //java中的栈
        Stack<Integer> s = new Stack<>();
//        s=new Vector<>();

        //java中的队列
        Queue<Integer> q = new LinkedList<>();
        //TODO
        List list = new ArrayList<Integer>(100001);
        int n = cin.nextInt();
        for(int i=0;i<n;i++){
            int  m =cin.nextInt();
            list.add(m);
        }
        int i=0;
        while(!list.isEmpty()){
            Integer k = (Integer) list.remove(i);
            System.out.print(k+" ");
            if(list.isEmpty())
                break;
            k = (Integer) list.remove(i);
            list.add(k);
        }
        cin.close();
    }
}
