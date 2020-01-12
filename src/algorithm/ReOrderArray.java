package algorithm;

import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public static void reOrderArray(int[] array){
        /**
         * 新建两个数组，分别存奇数和偶数，然后合并
         */
        int[] arrayEven = new int[array.length];
        int[] arrayOdd = new int[array.length];//奇数
        int even=0;
        int odd=0;
        for (int value : array) {
            if (value % 2 == 0) {
                arrayEven[even] = value;
                even++;
            } else {
                arrayOdd[odd] = value;
                odd++;
            }
        }
        //数组复制函数，（源，源的开始位置，目标（复制到的地方），从目标哪里开始，长度）
        System.arraycopy(arrayOdd,0,array,0,odd);
        System.arraycopy(arrayEven,0,array,odd,even);

    }

    /**
     * 网上的代码，通过插入排序的思想
     * 找到第一个奇数，将他前面的偶数后移一位，然后把这个奇数放到前面空出的位置上
     * @param array
     */
    public void reOrderArray2(int[] array){
        if(array==null||array.length==0){
            return;
        }
        int m = 0;//记录奇数后一个位置
        for(int i=0;i<array.length;i++){
            if((Math.abs(array[i]))%2!=0){
                int tmp = array[i];
                int j=i;
                while(j>m){
                    array[j] = array[j-1];
                    j--;
                }
                m=j+1;
                array[j] = tmp;
            }
        }
    }

    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7};
        reOrderArray(array);
        for(int value:array)
        System.out.print(value);
    }
}
