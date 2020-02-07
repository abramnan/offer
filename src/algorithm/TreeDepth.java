package algorithm;

import baseclass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
    /**
     * 递归
     * 17ms
     * 9484k
     * @param root root
     * @return deep
     */
    public int treeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left,right)+1;
    }

    /**
     * 非递归
     *11ms
     * 9404k
     * 利用队列，count是当前的节点，nextcount是当前深度总的节点。【总是要遍历到当前深度的最后一个节点，深度才加1】
     * @param root root
     * @return d
     */
    public int treeDepth1(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //count当前节点的个数，nextCount当前层的节点总个数
        int count = 0,d=0,nextCount = queue.size();
        while (queue.size()!=0){
            count++;
            TreeNode node = queue.poll();
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
            if(count==nextCount){
                d++;
                count=0;
                nextCount=queue.size();
            }
        }
        return d;
    }
}
