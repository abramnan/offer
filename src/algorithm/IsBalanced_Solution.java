package algorithm;

import baseclass.TreeNode;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树：左右两个子树高度差不大于1，且左右子树也都是平衡二叉树
 */
public class IsBalanced_Solution {
    /**
     * 11ms
     * 9252k
     * 先找深度，如果左深度-右深度大于1，则返回-1，否则返回大的深度+1
     * @param root root
     * @return d
     */
    public int deepth(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = deepth(root.left);
        if(left == -1){
            return -1;
        }
        int right = deepth(root.right);
        if(right==-1){
            return -1;
        }
        if(left-right<(-1)||left-right>1){
            return -1;
        }else {
            return 1+(Math.max(left, right));
        }
    }
    public boolean isBalanced_Solution(TreeNode root) {
        return deepth(root)!=-1;
    }

}
