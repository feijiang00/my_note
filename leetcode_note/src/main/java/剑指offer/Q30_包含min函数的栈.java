package 剑指offer;

import java.util.Stack;

/**
 * @date 2022/1/4 13:29
 */
public class Q30_包含min函数的栈 {

    class MinStack {
        Stack<Integer> stack1;
        Stack<Integer> stack2;//最小栈
        /** initialize your data structure here. */
        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x) {
            stack1.push(x);
            //什么时候push入最小栈，自然是元素是当前最小的
            if(stack2.isEmpty() || x<=stack2.peek())
                stack2.push(x);
        }

        public void pop() {
            //当pup的数从主栈了，别忘了联动最小栈
            if(stack1.pop().equals(stack2.peek()))
                stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
}
