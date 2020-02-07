package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    /**
     * 通过HashMap来存储
     * 22ms
     * 9540k
     * @param array a
     * @param num1 n1
     * @param num2 n2
     */
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int judge = 0;
        for (int value : array) {
            if (hashMap.containsKey(value)) {
                hashMap.put(value, 2);
            } else {
                hashMap.put(value, 1);
            }
        }
        for (int value : array) {
            if (hashMap.get(value) == 1) {
                if (judge == 0) {
                    num1[0] = value;
                    judge = 1;
                }
                if (judge == 1) {
                    num2[0] = value;
                }
            }
        }
    }

    /**
     * 25ms
     * 9452k
     * 比较好用的剑指offer的做法：
     * 首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
     * 当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的就是落单的数，因为成对儿出现的都抵消了。
     *
     * 依照这个思路，我们来看两个数（我们假设是AB）出现一次的数组。
     * 我们首先还是先异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1，即为A和B的不同的位。
     * 我们就取第一个1所在的位数，假设是第3位，接着把原数组分成两组，分组标准是第3位是否为1。
     * 如此，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数，肯定不在一组。
     * 然后把这两个组按照最开始的思路，依次异或，剩余的两个结果就是这两个只出现一次的数字。
     * @param array a
     * @param num1 1
     * @param num2 2
     */
    public void findNumsAppearOnce1(int [] array,int num1[] , int num2[]) {
        int xor = 0;
        for(int i =0;i<array.length;i++){
            xor = xor^array[i];
        }
        int index = 1;
        while ((index & xor)==0){
            index = index<<1;
        }
        int result1 = 0;
        int result2 = 0;
        for(int i = 0;i<array.length;i++){
            if((index&array[i])==0){
                result1 = result1^array[i];
            }else {
                result2 = result2^array[i];
            }
        }
        num1[0] = result1;
        num2[0] =result2;
    }

    /**
     * 1、Arrays.sort 数组排序
     * 2、使用栈进行从小到大入栈，一样的则弹出，不一样则入栈
     * 3、取栈中剩余的元素
     * @param array a
     * @param num1 1
     * @param num2 2
     */
    public void findNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        Stack<Integer> sta = new Stack<Integer>();
        for(int i=0; i<array.length; i++){
            if(sta.empty() || sta.peek()!=array[i]) {
                sta.push(array[i]);
            }else if(sta.peek() == array[i]) {
                sta.pop();
            }
        }
        num1[0] = sta.pop();
        num2[0] = sta.pop();
    }

}
