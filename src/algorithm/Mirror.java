package algorithm;

import baseclass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class Mirror {
    //递归
    //30ms
    public void mirror(TreeNode root){
        if(root==null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }

    //非递归，用一个数据结构来存储，如队列或栈
    //26ms
    //队列
    public void mirror2(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        TreeNode cur,temp;
        nodes.offer(root);
        //广度优先
        while (!nodes.isEmpty()){
            int len = nodes.size();
            for(int i =0;i<len;i++){
                cur = nodes.poll();
                temp = cur.left;
                cur.left = cur.right;
                cur.right = temp;
                if(cur.left!=null){
                    nodes.offer(cur.left);
                }
                if(cur.right!=null){
                    nodes.offer(cur.right);
                }
            }
        }
    }

    //栈
    //24ms
    public void mirror3(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode cur;
        TreeNode temp;
        //深度优先
        while (!stack.isEmpty()){
            cur = stack.pop();
            if(cur==null){
                continue;
            }
            temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            stack.push(cur.left);
            stack.push(cur.right);
        }
    }
}
