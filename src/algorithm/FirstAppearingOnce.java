package algorithm;


import java.util.Iterator;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * 21ms
 * 9692k
 */
public class FirstAppearingOnce {
    //Insert one char from stringstream
    public int[] charCount = new int[256];
    Queue<Character> queue = new LinkedList<>();
    public void Insert(char ch)
    {
        if(charCount[ch]==0){
            queue.add(ch);
        }
        charCount[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        while ((queue.peek())!=null) {
            char ch = queue.peek().charValue();
            if (charCount[ch] == 1) {
                return ch;
            }else {
                queue.remove();
            }

        }
        return '#';
    }
}
