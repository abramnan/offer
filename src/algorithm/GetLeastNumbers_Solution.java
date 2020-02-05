package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbers_Solution {
    /**
     * 暴力循环
     * 24ms
     * 9600k
     * @param input input
     * @param k k
     * @return return
     */
    public ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input==null||input.length==0||k>input.length||k<=0){
            return list;
        }
        Arrays.sort(input);
        for(int i =0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    /**
     * 先找到前k个,排序，然后根据后面的对前k个替换
     * 25ms
     * 9408k
     * @param input input
     * @param k k
     * @return return
     */
    public ArrayList<Integer> getLeastNumbers_Solution1(int [] input, int k){
        ArrayList<Integer> list = new ArrayList<>();
        if(input==null||input.length==0||k>input.length||k<=0){
            return list;
        }
        for(int i = 1; i< k; i++){
            int j = i-1;
            int unFindElement = input[i];
            while(j >= 0 && input[j] > unFindElement){
                input[j+1] = input[j];
                j--;
            }

            input[j+1] = unFindElement;
        }
        //遍历后面的元素 进行k个元素的更新和替换
        for(int i = k; i < input.length; i++){
            if(input[i] < input[k-1]){
                int newK = input[i];
                int j = k-1;
                while(j >= 0 && input[j] > newK){
                    input[j+1] = input[j];
                    j--;
                }
                input[j+1] = newK;
            }
        }
        //把前k个元素返回
        for(int i=0; i < k; i++)
            list.add(input[i]);
        return list;
    }
}
