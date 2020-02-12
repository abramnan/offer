package algorithm;

import baseclass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * 主要的方法与BFS写法没什么区别
 * BFS里是每次只取一个，而我们这里先得到队列长度size，这个size就是这一层的节点个数，
 * 然后通过for循环去poll出这size个节点，这里和按行取值二叉树返回ArrayList<ArrayList<Integer>>这种题型的解法一样，
 * 之字形取值的核心思路就是通过两个方法：
 *      list.add(T): 按照索引顺序从小到大依次添加
 *      list.add(index, T): 将元素插入index位置，index索引后的元素依次后移,这就完成了每一行元素的倒序，
 *      或者使用Collection.reverse()方法倒序也可以
 *
 * 32ms
 * 9560k
 */
public class Print {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean rev = true;
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                if(node==null){
                    continue;
                }
                if(rev){
                    list.add(node.val);
                }else {
                    list.add(0,node.val);
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if(list.size()!=0){
                result.add(list);
            }
            rev=!rev;
        }
        return result;
    }
}
