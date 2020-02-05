package algorithm;

import java.util.Arrays;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {
    /**
     * 思路：将数组排序，找到中间元素，如果这个元素个数大于一半，返回这个元素
     * 否则返回0
     * @param array array
     * @return return
     */
    public int moreThanHalfNum_Solution(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        Arrays.sort(array);
        int point = array[array.length/2];
        int count = 0;
        for(int i =0;i<array.length;i++){
            if(array[i]==point){
                count++;
            }
        }
        if(count>array.length/2){
            return point;
        }else {
            return 0;
        }
    }

    /**
     *16ms
     * 9264k
     * 思路：用preValue记录数字，count记录次数，遍历数组时，如果preValue==array[i]，count++，
     * 如果不等，count--，如果count==0，则preValue后移，count=1，最后的preValue为个数可能大于一半的元素
     * 原因：重复的次数大于数组长度的一半
     * @param array array
     * @return return
     */
    public int moreThanHalfNum_Solution1(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int count = 1;
        int preValue = array[0];
        for(int i = 1;i<array.length;i++){
            if(array[i]==preValue){
                count++;
            }else {
                count--;
                if(count==0) {
                    preValue = array[i];
                    count=1;
                }
            }
        }
        int sum = 0;
        for(int i = 0 ;i<array.length;i++){
            if(array[i]==preValue){
                sum++;
            }
        }
        return (sum>array.length/2)?preValue:0;
    }

}
