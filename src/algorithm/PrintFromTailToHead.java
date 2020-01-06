/**
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * */
package algorithm;

import java.util.ArrayList;
import baseclass.ListNode;
/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class PrintFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = listNode;
        while(temp!=null) {
            list.add(0, temp.val);//使用了ArrayList的add（index，value）方法，指定插入的位置，每次指定插入位置都为0；则是倒序
            temp = temp.next;
        }
        return list;
    }


    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode){
        if(listNode!=null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
