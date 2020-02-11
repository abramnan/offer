package algorithm;

import baseclass.ListNode;

import java.util.HashMap;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class EntryNodeOfLoop {
    /**
     * 13ms
     * 9552k
     * 通过hashMap辅助
     */
    HashMap<ListNode,Integer> hashMap = new HashMap<>();
    public ListNode entryNodeOfLoop(ListNode pHead){
        ListNode p = pHead;
        while (p!=null){
            if(hashMap.containsKey(p)){
                return p;
            }else {
                hashMap.put(p,0);
                p=p.next;
            }
        }
        return null;
    }

    /**
     * 快慢指针
     *
     * 用快慢指针判断有没有环
     * 若有，返还相遇的指针，此时指针必定相遇在环中
     * 遍历环，得到环的数目n
     * 一个指针先走n步，另一个指针再开始走（它们的速度相同），它们相遇的地方就是入口
     * 解释4：
     * 假设入口到环的入口结点距离k，当后走的指针移动k步到达入口结点时，先走的指针移动距离
     * 为n+k，刚好多走了一个环的距离，所以又移动到了入口结点，此时两指针相遇
     *
     * 15ms
     * 9544k
     */
    public ListNode entryNodeOfLoop1(ListNode pHead){
        boolean round = false;
        ListNode low = pHead;
        ListNode fast = pHead;
        if(pHead==null){
            return null;
        }
        //判断是否有环
        while (fast!=null&&fast.next!=null){
            low=low.next;
            fast=fast.next.next;//因为这里两个next，所以while里有两个判断
            if(low==fast){
                round=true;
                break;
            }
        }
        if(!round){
            return null;
        }else {
            //计算环中个数
            int count = 1;
            fast=fast.next;
            while (fast!=low){
                fast=fast.next;
                count++;
            }
            low = pHead;
            fast = pHead;
            for(int i =0;i<count;i++){
                fast = fast.next;
            }
            while (low!=fast){
                fast=fast.next;
                low=low.next;
            }
            return low;
        }
    }
}
