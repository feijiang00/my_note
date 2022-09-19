package 剑指offer;

import java.util.Stack;

/**
 * @date 2022/1/4 12:42
 */
public class Q09_用两个栈实现队列 {
    /*
    究其原因，还是这里是添加的元素是先进，先出的原理
    如果一个栈肯定是不行的，因为栈是后进先出的原理

     */
    class CQueue {
        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            //stack1是存储数栈，stack2是取数
             if(!stack2.isEmpty()){
                return stack2.pop();
            }else{
                 while (!stack1.isEmpty()){
                     stack2.push(stack1.pop());
                 }
                 //将stack1里面值推进去stack2还是有可能是空
                 return stack2.isEmpty()? -1 : stack2.pop();
             }
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

}


