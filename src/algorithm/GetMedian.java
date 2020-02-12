package algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 这一题主要的思想是利用优先队列，优先队列分为大顶堆和小顶堆，默认维护的是小顶堆的优先队列。
 * 
 * 需要求的是中位数，如果我将 1 2 3 4 5 6 7 8定为最终的数据流
 * 此时的中位数是4+5求均值。为什么是4，为什么是5
 * 利用队列我们就可以看得很清楚，4是前半部分最大的值，肯定是维系在大顶堆
 * 而5是后半部分的最小值，肯定是维系在小顶堆。
 * 问题就好理解了：
 * 使用小顶堆存大数据，使用大顶堆存小数据。这样堆顶一取出就是中位数了。
 * 20ms
 * 9808k
 */
public class GetMedian {
    private int cnt = 0;
    private PriorityQueue<Integer> low = new PriorityQueue<>();//极小堆
    private PriorityQueue<Integer> high = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public void Insert(Integer num) {
        cnt++;
        if((cnt&1)==1){
            // 由于奇数，需要存放在大顶堆上
            // 但是呢，现在你不知道num与小顶堆的情况
            /** 小顶堆存放的是后半段大的数*/
            // 如果当前值比小顶堆上的那个数更大
            if(!low.isEmpty()&&num>low.peek()){
                // 存进去
                low.offer(num);
                //然后在将那个最小的吐出来
                num = low.poll();
            }// 最小的就放到大顶堆，因为它存放前半段
            high.offer(num);
        }else {
            // 偶数的话，此时需要存放的是小的数
            // 注意无论是大顶堆还是小顶堆，吐出数的前提是得有数
            if(!high.isEmpty()&&num<high.peek()){
                high.offer(num);
                num = high.poll();
            }// 大数被吐出，小顶堆插入
            low.offer(num);
        }
    }

    public Double GetMedian() {
        double result = 0;
        if((cnt&1)==1){
            result = high.peek();
        }else {
            result = (high.peek()+low.peek())/2.0;
        }
        return result;
    }
}
