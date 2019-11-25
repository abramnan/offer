/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * */
package algorithm;

import baseclass.TreeNode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinaryTree {
    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    /*
    * Arrays.copyOfRange(T[ ] original,int from,int to)

    将一个原始的数组original，从下标from开始复制，复制到上标to，生成一个新的数组。

    注意这里包括下标from，不包括上标to。左闭右开
    * */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0||in.length==0)
            return null;
        TreeNode temp = new TreeNode(pre[0]);
        for(int i =0;i<pre.length;i++){
            if(in[i]==pre[0]){
                temp.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                temp.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }
        return temp;
    }
}
