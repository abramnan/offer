/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * */
package algorithm;

import java.util.Stack;

public class Queue {
    Stack<Integer> stack1 = new Stack<Integer>();//入栈用的栈，入队列前要把出栈的栈里的压入到入栈的栈里
    Stack<Integer> stack2 = new Stack<Integer>();//出栈用的栈，出队列前要把入栈的栈里的压入到出栈的栈里

    public void push(int node) {
        while (!stack2.empty()) {
            int item = stack2.pop();
            stack1.push(item);
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()){
            int item = stack1.pop();
            stack2.push(item);
        }
        int r = stack2.pop();
        return r;
    }


    //其他解法

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() <= 0) {
            while (stack1.size() != 0) {//将stack2的pop完后才会将stack1的压入stack2后再pop
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
