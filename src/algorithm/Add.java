package algorithm;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 思路：
 * 执行加法 x ^ y，没进位的
 * 进位操作 ( x & y ) << 1 ，进位
 * 然后把结果相加，在进位，不断循环，直至没有进位
 */
public class Add {
    /**
     * 25ms
     * 9352k
     * 递归
     * @param num1
     * @param num2
     * @return
     */
    public int add(int num1,int num2) {
        return num2!=0 ? add(num1^num2,(num1&num2)<<1):num1;
    }

    /**
     * 非递归
     * 16ms
     * 9324k
     */
    public int add1(int num1,int num2) {
        int result = 0;
        int crray = 0;
        do{
            result = num1^num2;
            crray = (num1&num2)<<1;
            num1 = result;
            num2 = crray;
        }while (crray!=0);
        return result;
    }

}
