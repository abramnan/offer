package algorithm;

public class Sum_Solution {
    /**
     * 暴力循环
     * 17ms
     * 9440k
     * @param n
     * @return
     */
    public int sum_Solution(int n){
        int sum = 0;
        for(int i =1;i<=n;i++){
            sum+=i;
        }
        return sum;
    }

    /**
     * 这是一个等差数列，sum=(a1+an)n/2=>(1+n)n/2=>(n+n^2)/2；Math.pow(a,b)表示a^b；右移一位相当于除以2。
     * @param n n
     * @return sum
     * 24ms
     * 9164k
     */
    public int sum_Solution1(int n){
        int sum = (int)Math.pow(n,2)+n;
        return sum>>1;
    }
}
