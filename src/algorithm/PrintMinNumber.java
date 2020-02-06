package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    /**
     *17ms
     * 9528k
     * 首先，我们并不能直接用(o1,o2)->o2.compareTo(o1)，
     * 因为很明显当数字一样大时长度并不能作为排序的依据。该题的正确解法为短的字符串循环与长的字符串作比较，
     * @param numbers
     * @return
     */
    public String printMinNumber(int [] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for(int i : numbers){
            list.add(i+"");
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i =0,j=0;
                while(i<o1.length()||j<o2.length()){
                    if(j==o2.length()){
                        j-=o2.length();
                    }
                    if(i==o1.length()){
                        i-=o1.length();
                    }
                    if(o1.charAt(i)<o2.charAt(j)){
                        return -1;
                    }else if(o1.charAt(i)>o2.charAt(j)){
                        return 1;
                    }
                    i++;
                    j++;
                }
                return 0;
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for(String s:list){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    /**
     * 利用了贪心的思想，既然整个序列是最小的，那么越靠前的序列肯定也是最小的，任何两个序列的组合也是较小的。
     * 同时将两个字符串按不同顺序相加得到的长度也是相等的，此时就可以简单地使用compareTo的方法来做比较。
     * @param numbers
     * @return
     */
    public String printMinNumber1(int [] numbers) {
        ArrayList<String> arrayList = new ArrayList<String>();
        for(int i : numbers){
            arrayList.add( i + "" );
        }

        Collections.sort(arrayList, (o1,o2)->(o1+o2).compareTo(o2+o1));

        StringBuilder stringBuilder2 = new StringBuilder();
        for(String s : arrayList){
            stringBuilder2.append(s);
        }
        return stringBuilder2.toString();
    }

}
