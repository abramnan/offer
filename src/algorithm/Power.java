package algorithm;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class Power {
    /**
     * 使用java自带乘方函数，面试应该不大行
     * @param base 基数
     * @param exponent 幂
     * @return
     */
    public double Power(double base,int exponent){
        return Math.pow(base,exponent);
    }

    /**
     * 暴力循环
     * @param base
     * @param exponent
     * @return
     */
    public double Power2(double base,int exponent){
        if (exponent == 0&&base!=0) {
            return 1;
        }
        if(exponent!=0&&base==0){
            return 0;
        }
        double sum = 1;
        int loopExponent = exponent;
        if(exponent<0){
            loopExponent = -exponent;
        }
        for(int i = 1;i<=loopExponent;i++){
            //sum*=base好像更简洁一点
            sum = sum*base;
        }
        if(exponent<0) {
            return 1 / sum;
        }
        return sum;
    }

    /**
     * 二分法，看的网上的
     * 链接：https://www.nowcoder.com/questionTerminal/1a834e5e3e1a4b7ba251417554e07c00?answerType=1&f=discussion
     * 来源：牛客网
     *
     * 为了方便讨论，假设指数exponent是正数。那么递归式如下：
     *
     * 如果exponent是偶数，Power(base, exponent) = Power(base, exponent / 2) * Power(base, exponent / 2)
     * 如果exponent是奇数，Power(base, exponent) = base * Power(base, exponent / 2) * Power(base, exponent / 2)
     * 对于负指数exponent的情况，取其绝对值先计算。将最后结果取倒数即可。
     *
     * 时间复杂度是 O(logN)；由于采用递归结构，空间复杂度是 O(logN)。
     */
    public double power(double base,int exponent){
        double sum = absPower(base,Math.abs(exponent));
        return exponent>0?sum:1/sum;
    }

    public double absPower(double base,int exponent){
        if(exponent==0&&base!=0){
            return 1;
        }
        if(exponent!=0&&base==0){
            return 0;
        }

        double subResult = absPower(base, (int) Math.floor(exponent/2));
        return exponent%2!=0 ? subResult*subResult*base:subResult*subResult;
    }

    /**
     * 牛客网上还以一种基于位运算的没看
     */
}