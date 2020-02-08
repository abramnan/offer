package algorithm;

import java.util.Arrays;

/**
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class LeftRotateString {
    /**
     * 思路：把前n个拿出来，其余的前移，再把那n个放到后面
     * 16ms
     * 9664k
     * @param str s
     * @param n n
     * @return str
     */
    public static String leftRotateString(String str,int n) {
        if(str==null||str.length()==0){
            return str;
        }
        if(n>str.length()){
            n = n%str.length();
        }
        char[] chars = str.toCharArray();
        int length = str.length();
        if(str.length()==n){
            return str;
        }
        char[] before = new char[n];
        System.arraycopy(chars, 0, before, 0, n);
        for (int i = n;i<length;i++){
            chars[i-n] = chars[i];
        }
        for (int i = 0;i<n;i++){
            chars[i+str.length()-n] = before[i];
        }
        String s = new String(chars);
        return s;
    }

    /**
     * 用subString来写
     * @param str
     * @param n
     * @return
     */
    public static String leftRotateString1(String str,int n) {
        if(str==null||str.length()==0){
            return str;
        }
        if(n>str.length()){
            n = n%str.length();
        }
        return str.substring(n)+str.substring(0,n);
    }

    public static void main(String[] args){
        String s = "abcdefg";
        leftRotateString(s,2);
    }
}
