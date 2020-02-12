package algorithm;

import baseclass.TreeNode;

import java.util.Stack;

/**
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 * 41ms
 * 9688k
 */
public class KthNode {
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot==null||k<=0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRoot;
        //部分中序遍历
        while (!stack.isEmpty()||cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else {
                cur = stack.pop();
                if(--k<=0){
                    return cur;
                }
                cur = cur.right;
            }
        }
        return null;
    }
}
