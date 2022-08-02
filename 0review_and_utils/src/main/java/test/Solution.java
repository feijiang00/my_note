package test;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 检查括号是否匹配
     * @param arr string字符串ArrayList 包含左右括号的字符串
     * @return int整型
     */
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> arrayList = new ArrayList<String>();
        arrayList.add("()");
        arrayList.add("{");

        System.out.println(solution.count((ArrayList<String>) arrayList));
    }
    public int count (ArrayList<String> arr) {
        // write code here
        if(arr.size() == 0)
            return 0;
        //对每一个列表的元素进行判断
        int size = 0;//初始匹配数量
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<arr.size();i++){
            //对每一个string进行判断
            boolean flag = true;
            for(int j=0;j<arr.get(i).length();j++){
                if(arr.get(i).charAt(j) == '(' || arr.get(i).charAt(j)=='{'){
                    stack.push(arr.get(i).charAt(j));
                }
                if(arr.get(i).charAt(j) == ')' ){
                    if(stack.pop() != '('){
                        flag = false;
                        break;
                    }
                }
                if(arr.get(i).charAt(j) == '}' ){
                    if(stack.pop() != '{'){
                        flag = false;
                        break;
                    }
                }
            }
            if(stack.size() !=0)
                flag = false;
            if(flag)
                size++;
            stack.clear();
        }
        return size;
    }
}