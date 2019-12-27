package algorithm;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * f(n)=2f(n-1)
 */
public class FrogJump2 {
    public int JumpFloorII(int target){
        //17ms
        if(target==1){
            return target;
        }
        return 2*JumpFloorII(target-1);
    }

    public int JumpFloorII2(int target){
        //15ms
        int[] dp = new int[target+1];
        for(int i =1;i<=target;i++){
            dp[i]=1;
        }
        for(int i = 2;i<=target;i++){
            for (int j = i-1;j>=1;j--){
                dp[i]+=dp[j];
            }
        }
        return dp[target];
    }
}
