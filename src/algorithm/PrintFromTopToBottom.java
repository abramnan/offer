package algorithm;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

import baseclass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
    this.val = val;
    }
 }
 */

/**
 * 广度优先，通过队列
 * 深度优先通过栈
 */
public class PrintFromTopToBottom {
    /**
     *
     * @param root root
     * @return list
     * 19ms
     * 9276k
     */
    public ArrayList<Integer> printFromTopToBottom(TreeNode root){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//插入
        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();//取出
            if(treeNode.left!=null){
                queue.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.offer(treeNode.right);
            }
            list.add(treeNode.val);
        }
        return list;
    }
}
