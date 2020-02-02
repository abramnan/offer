package algorithm;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 注：这个是有顺序的，根节点左节点的比跟小，右节点比根大
 * 17ms
 * 9320k
 * 思路：判断是不是所有的根节点左节点比根大，左节点比根小
 */
public class VerifySquenceOfBST {
    public boolean judge(int[] sequence,int start,int last){
        if(start>=last){
            return true;
        }
        int point = sequence[last];
        int i;
        for(i =start;i<last;i++){
            if(sequence[i]>point){
                break;
            }
        }
        for(int j = i;j<last;j++){
            if(sequence[j]<point)
                return false;
        }
        return judge(sequence,start,i-1)&&judge(sequence,i,last-1);
    }
    public boolean erifySquenceOfBST(int[] sequence){
        if(sequence==null||sequence.length==0){
            return false;
        }
        return judge(sequence,0,sequence.length-1);
    }
}
