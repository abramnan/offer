package algorithm;

import java.util.ArrayList;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 2=<N<=60
 * 例：
 *      输入：8
 *      输出：18
 */
public class CutRope {
    /**
     * 递归
     * 18ms
     * 9676k
     * @param target
     * @param max
     * @return
     */
    public int curRope(int target,int max){
        int maxValue = max;
        for(int i =1;i<target;i++){
            maxValue = Math.max(maxValue,i*curRope(target-i,target-i));
        }
        return maxValue;
    }
    public int cutRope(int target) {
        return curRope(target,target);

    }

    /**
     * 动态规划
     * 13ms
     * 9696k
     */
    public int cutRope1(int target) {
        if(target==2){
            return 1;
        }
        if(target==3){
            return 2;
        }
        if(target==4){
            return 4;
        }

        ArrayList<Integer> list = new ArrayList<>();
        //前四个
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for(int j = 5;j<=target;j++){
            int max = 0;
            for(int i = 2;i<=j/2;i++){
                if(list.get(i)*list.get(target-i)>max){
                    max = list.get(i)*list.get(target-i);
                }
            }
            list.add(max);
        }
        return list.get(target);
    }
}
