/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * */
package algorithm;

//二分，有问题，数组越界，没找到在哪
public class RotateArray {
    public  int minNumberInRotateArray(int [] array) {
        if(array.length<=0)
            return 0;
        else if(array.length==1)
            return array[0];
        else {
            return serch(0,array.length,array);
        }
    }

    public static int serch(int first,int last,int[] array){
        if(first==last)
            return array[first];
        int mid = (first + last)/2;
        if(mid==0) {
            if (array[mid] > array[mid + 1])
                return array[mid];
            else
                return array[mid + 1];
        }
        else {
            if (array[mid - 1] > array[mid] && array[mid] < array[mid + 1])
                return array[mid];
            else {
                if (array[mid] > array[first])
                    return serch(mid + 1, last, array);
                else
                    return serch(first, mid - 1, array);
            }
        }
    }

    /*
    * 网上的代码，可以提交成功，但是也有问题，比如333313，如果不重复还好。
    * */

    import java.util.*;
    public class Solution {
        public int minNumberInRotateArray(int [] nums) {
            if (nums.length == 1) {
                return nums[0];
            }
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[l] < nums[r]) {
                    return nums[l];
                }
                if (nums[mid] > nums[mid + 1]) {
                    return nums[mid + 1];
                }
                if (nums[mid] < nums[mid - 1]) {
                    return nums[mid];
                }
                if (nums[mid] > nums[0]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return 0;
        }
    }

    //暴力循环O(n)
    public int minNumberInRotateArray(int [] array) {
        for(int i =0;i<array.length-1;i++) {
            if (array[i] > array[i + 1])
                return array[i + 1];
        }
        return 0;
    }

}
