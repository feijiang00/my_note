package mySchoolOj.two;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class two {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //TODO
        Map<String,Integer> map = new TreeMap<String,Integer>();
        String[] data = cin.nextLine().split(" ") ;
        int num = data.length;
        //遍历这个字符串数组
        for(String str : data){
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            }else{
                map.put(str, 1);
            }
        }
        System.out.println(num);
        Iterator it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry ex = (Map.Entry) it.next();
            System.out.println(ex.getKey() + ":" + ex.getValue());
        }
        //调试语句
        System.err.println(map);
        cin.close();
    }
}
//常用的一种获取文章的单词数组
//String[] word = s.toLowerCase().replaceAll("[^a-x]"," ").split("\\s+");
