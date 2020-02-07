package algorithm;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述：
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 	对于%50的数据,size<=10^4
 * 	对于%75的数据,size<=10^5
 * 	对于%100的数据,size<=2*10^5
 *
 * 输入：
 * 	1,2,3,4,5,6,7,0
 * 	输出：
 * 	7
 * 	556ms
 * 	52280k
 * 	归并排序
 * 	O(nlogn)
 */
public class InversePairs {
    private int count;
    public void mergeSort(int[] array,int start,int end){
        if(start>=end)return;
        int mid = (end+start)/2;
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);
        merge(array,start,mid,end);
    }
    public void merge(int[] array,int start,int mid,int end){
        int[] temp = new int[end-start+1];
        int k =0,i=start,j=mid+1;
        while (i<=mid&&j<=end){
            //如果前面的小于后面的，不能组成逆序对
            if(array[i]<=array[j]){
                temp[k++]=array[i++];//先赋值，再加一
            }else {
                //如果前面的元素大于后面的，那么在前面元素之后的元素（i到mid）都能和后面的元素（j）构成逆序对
                temp[k++]=array[j++];
                count=(count+(mid-i+1))%1000000007;
            }
        }
        while (i<=mid){
            temp[k++] = array[i++];
        }
        while (j<=end){
            temp[k++]=array[j++];
        }
        for(int l=0;l<k;l++){
            //将排序好的放进去
            array[start+l] = temp[l];
        }
    }
    public int InversePairs(int [] array) {
        mergeSort(array,0,array.length-1);
        return count;
    }
}
