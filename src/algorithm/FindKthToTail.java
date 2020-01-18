package algorithm;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
import baseclass.ListNode;

public class FindKthToTail {
    /**
     * 暴力搜索
     * 27ms
     * @param head 头
     * @param k k
     * @return node
     */
    public ListNode indKthToTail(ListNode head, int k) {
        if(head==null){
            return null;
        }
        ListNode iterator = head;
        int index = 0;
        while(iterator!=null){
            iterator=iterator.next;
            index++;
        }
        ListNode iterator2 = head;
        int index2 = 0;
        if(k<1||k>index){
            return null;
        }
        while(iterator2!=null){
            index2++;
            if(index2==index-k+1){
                return iterator2;
            }
            iterator2 = iterator2.next;
        }
        return null;
    }

    /**
     * 快慢指针
     * 19ms
     * 采用两个指针P1,P2，P1先前移K步
     * 然后P1、P2同时移动，当p1移动到尾部时，P2所指位置的元素即倒数第k个元素 。
     * @param head head
     * @param k k
     * @return node
     */
    public ListNode indKthToTail2(ListNode head,int k){
        if(head==null){
            return null;
        }
        ListNode iterator = head;
        int index = 0;
        while(iterator!=null){
            iterator=iterator.next;
            index++;
        }
        if(k<1||k>index){
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i =0;i<k;i++)
        {
            p1=p1.next;
        }
        while(p1!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    /**
     * 快慢指针代码简洁版
     * 23ms
     */
    public ListNode indKthToTail3(ListNode head,int k){
        ListNode p, q;
        p = q = head;
        int i = 0;
        for (; p != null; i++) {
            if (i >= k)
                q = q.next;
            p = p.next;
        }
        return i < k ? null : q;
    }

}