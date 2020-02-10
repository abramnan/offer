package algorithm;

/**
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 示例：
 * 输入：
 * +2147483647
 *     1a33
 * 输出
 * 2147483647
 *     0
 *
 *     18ms
 *     9296k
 *     思路：很复杂，https://blog.nowcoder.net/n/eb66593eb79a4428a72e385adcfce6dd?f=comment
 */
public class StrToInt {
    public int strToInt(String str) {
        char[] chars = str.toCharArray();
        int isNegtive = 1,overValue = 0;
        int digit = 0,value = 0;
        int length = str.length();
        final int INT_MAX = (int)Math.pow(2,31)-1;
        if(length==0){
            return 0;
        }else {
            int idx = 0;
            if(chars[0]=='-'){
                isNegtive=-1;
                idx=1;
            }else if(chars[0]=='+'){
                idx=1;
            }
            for(;idx<length;idx++){
                digit = chars[idx]-'0';
                overValue = value*isNegtive-INT_MAX/10+(((isNegtive+1)/2+digit>8)?1:0);
                if(digit>9||digit<0){
                    return 0;
                }
                else if(overValue>0){
                    return 0;
                }
                value = value*10+isNegtive*digit;
            }
            return value;
        }
    }
}
