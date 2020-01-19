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
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

import baseclass.ListNode;
public class Merge {
    /**
     * 新建一个链表，比较后放入新链表
     * 要知道如何新建链表,23行
     * 42ms
     * @param list1 list1
     * @param list2 list2
     * @return head.next
     */
    public ListNode merge(ListNode list1, ListNode list2){
       ListNode head = new ListNode(-1);
       ListNode cur = head;
       while(list1!=null&&list2!=null){
           if(list1.val<list2.val){
               cur.next = list1;
               list1 = list1.next;
           }else {
               cur.next = list2;
               list2 = list2.next;
           }
           cur = cur.next;
       }
       if(list1==null){
           cur.next = list2;
       }
       if(list2==null){
           cur.next = list1;
       }
       return head.next;
    }

    /**
     * 将p2插入p1
     * 30ms
     * @param list1 1
     * @param list2 2
     * @return list1
     */
    public ListNode merge1(ListNode list1,ListNode list2){
        if(list1 == null ){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode pre1 = new ListNode(-1);//list1的前一个节点
        ListNode list2Next = null;//记录list2的下一个节点
        ListNode head = null;
        pre1.next = list1;
        if(list1.val<=list2.val){//找到谁做头节点，关键,要和后面的比较条件（68行）一致
            head = list1;
        }else {
            head = list2;
        }
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                pre1 = list1;
                list1 = list1.next;
            }else {
                list2Next = list2.next;
                pre1.next = list2;
                list2.next = list1;
                pre1 = list2;
                list2 = list2Next;
            }
        }
        if(list2!=null){
            pre1.next = list2;
        }
        return head;
    }

    /**
     * 递归
     * 49ms
     * @param list1 1
     * @param list2 2
     * @return head
     */
    public ListNode merge2(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNode head = null;
        if(list1.val<=list2.val){
            head = list1;
            head.next = merge2(list1.next,list2);
        }else {
            head = list2;
            head.next = merge2(list1,list2.next);
        }
        return head;
    }

}
