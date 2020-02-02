package algorithm;

import java.util.*;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */

/**
 * 29ms
 * 9440k
 * 思路（自己）：对入栈的元素编号，找到第一个出栈的元素，在该元素之前入栈的元素必须是按顺序出栈的
 * 该题唯一约束是在第一个出栈元素之前入栈的元素出栈时必须按顺序的。
 */
public class IsPopOrder {
    public boolean isPopOrder(int [] pushA,int [] popA){
        Map<Integer,Integer> map = new HashMap<>(16);
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<pushA.length;i++){
            map.put(pushA[i],i);
        }
        for(int temp:popA){
            if(!map.containsKey(temp)){
                return false;
            }
        }
        for (int value : popA) {
            if (map.get(value) < map.get(popA[0])) {
                list.add(value);
            }
        }
        for(int i =0;i<list.size()-1;i++){
            if(map.get(list.get(i))<map.get(list.get(i+1))){
                return false;
            }
        }
        return true;
    }

    /**
     * @param pushA push
     * @param popA pop
     * @return boolean
     * 按照入栈顺序重新入栈，入栈过程中结合出栈的顺序判断是否出栈
     * 17ms
     * 9440k
     */
    public boolean isPopOrder1(int[] pushA,int[] popA){
        int len = pushA.length;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i =0,j=0;i<len;i++){
            stack.push(pushA[i]);
            while(j<len&&stack.peek()==popA[j]){//顺序不能错，不然会报错，stack溢出
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
