package algorithm;

import baseclass.RandomListNode;

import java.util.HashMap;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Clone {
    /**
     * 38ms
     * 9792k
     * @param pHead pHead
     * @return head
     */
    public RandomListNode clone(RandomListNode pHead){
        if(pHead==null){
            return null;
        }
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>(16);
        RandomListNode p = pHead;
        RandomListNode q = pHead;
        while(p!=null){
            map.put(p,new RandomListNode(p.label));
            p = p.next;
        }
        while (q!=null){
           // if(q.next!=null){//没有也可以通过，但是要考虑q.next和q.random为空时，get（）会异常。
                map.get(q).next = map.get(q.next);
            //}else {
              //  map.get(q).next = null;
           // }
            map.get(q).random = map.get(q.random);
            q = q.next;
        }
        return map.get(pHead);
    }
}
