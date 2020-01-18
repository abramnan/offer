package algorithm;
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

import baseclass.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 在网上找的代码
 */
public class ReverseList {
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode p = head;
        ListNode pNext = null;//当前节点的后一个节点
        ListNode pPre = null;//当前节点的前一个节点
        while(p!=null){
            pNext = p.next;
            p.next = pPre;
            pPre = p;
            p = pNext;
        }
        return pPre;
    }
}
