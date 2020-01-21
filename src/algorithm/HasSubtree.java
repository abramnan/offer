package algorithm;
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
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

import baseclass.TreeNode;

public class HasSubtree {
    public boolean hasSubTree(TreeNode root1, TreeNode root2){
        if(root2==null||root1==null){
            return false;
        }
        if(root1.val == root2.val){
            if(judge(root1,root2)){
                return true;
            }
        }
        return hasSubTree(root1.left,root2)||hasSubTree(root1.right,root2);
    }

    //判断是不是子结构
    public static boolean judge(TreeNode treeNode1,TreeNode treeNode2){
        //小树循环完，全部匹配
        if(treeNode2==null){
            return true;
        }
        //大树循环完，小树还没循环完，匹配不成功
        if(treeNode1==null){
            return false;
        }
        //如果不相等，则不是子树
        if(treeNode1.val!=treeNode2.val){
            return false;
        }
        return judge(treeNode1.left,treeNode2.left)&&judge(treeNode1.right,treeNode2.right);
    }
}
