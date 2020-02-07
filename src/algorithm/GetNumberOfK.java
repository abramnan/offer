package algorithm;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 18ms
 * 8212k
 */
public class GetNumberOfK {
    public int getNumberOfK(int [] array , int k) {
        if(array==null||array.length==0){
            return 0;
        }
        int count =0;
        for(int i =0;i<array.length;i++){
            if(array[i]==k){
                count++;
            }
            if(array[i]>k){
                break;
            }
        }
        return count;
    }
}
