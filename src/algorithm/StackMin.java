package algorithm;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
/**
 * 参考了别人的思路，这里也是使用了两个栈。
 * 一个用来存所有的元素“stackTotal”,另一个用来存加入新的元素后当前stackTotal中对应的最小值。
 * 两个栈中的元素数量始终保持一致，当新的元素小于“stackLittle”栈顶元素时，“stackLittle”像栈顶push新来的元素，否则，“stackLittle”向栈顶加入原栈顶元素。
 * 执行“pop”方法时，两个栈同时弹出各自的栈顶元素。
 */
/**
 * 19ms
 * 10448k
 */

import java.util.Stack;

public class StackMin {
    private static Stack<Integer> stack = new Stack<Integer>();
    private static Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }else {
            if(node<=minStack.peek()){
                minStack.push(node);
            }else {
                minStack.push(minStack.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
