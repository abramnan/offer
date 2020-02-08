package algorithm;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * 思路：两个指针，一个指向第一个，一个指向最后一个，向中间移动
 * 19ms
 * 9176k
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum){
        ArrayList<Integer> result = new ArrayList<>();
        if(array==null||array.length==0){
            return result;
        }
        int low = 0,high = array.length-1;
        while (low<high){
            int arraySum = array[low] + array[high];
            if(arraySum<sum){
                low++;
            }else if(arraySum>sum){
                high--;
            }else if(arraySum==sum){
                result.add(array[low]);
                result.add(array[high]);
                break;
            }
        }
        return result;
    }
}
