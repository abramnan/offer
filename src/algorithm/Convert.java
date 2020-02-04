package algorithm;

import baseclass.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * public class TreeNode {
 *     int val = 0;
 *     TreeNode left = null;
 *     TreeNode right = null;
 *
 *     public TreeNode(int val) {
 *         this.val = val;
 *
 *     }
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 双向链表：左节点指向第一个比它小的，右节点指向第一个比他大的
 */
public class Convert {
    /**
     * 18ms
     * 9332k
     * 代码很少，比较难理解，要画图
     * 思路：找到最右节点，和它上一个节点，修改指针，然后将上一个节点和这个节点左边的修改指针，递归。
     */
    TreeNode pre = null;
    public TreeNode convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        convert(pRootOfTree.right);
        if(pre==null){
            pre = pRootOfTree;
        }else {
            pRootOfTree.right = pre;
            pre.left = pRootOfTree;
            pre = pRootOfTree;
        }
        convert(pRootOfTree.left);
        return pre;
    }

    /**
     * 思路：先中序遍历，在修改指针
     * 17ms
     * 9440k
     * @param pRootOfTree
     * @return
     */
    public TreeNode convert1(TreeNode pRootOfTree){
        if(pRootOfTree==null) {
            return null;
        }
        ArrayList<TreeNode> list = new ArrayList<>();
        convertList(pRootOfTree,list);
        return convertLinked(list);
    }

    //递归中序遍历
    public void convertList(TreeNode pRootOfTree, ArrayList<TreeNode> list){
        if(pRootOfTree.left!=null){
            convertList(pRootOfTree.left,list);
        }
        list.add(pRootOfTree);
        if(pRootOfTree.right!=null){
            convertList(pRootOfTree.right,list);
        }
    }

    //修改指针
    public TreeNode convertLinked(ArrayList<TreeNode> list){
        for(int i = 0;i<list.size()-1;i++){
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }
        return list.get(0);
    }

    /**
     * 中序遍历，非递归
     * 17ms
     * 9536k
     * @param pRootOfTree
     * @return
     */
    public TreeNode convert2(TreeNode pRootOfTree){
        if (pRootOfTree == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = pRootOfTree;
        LinkedList<TreeNode> queue = new LinkedList<>();
        //非递归中序遍历
        while(cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                cur = stack.pop();
                queue.offer(cur);
                cur = cur.right;
            }
        }
        for(int i = 0;i<queue.size();i++){
            TreeNode left = i==0?null:queue.get(i-1);
            TreeNode right = i==queue.size()-1?null:queue.get(i+1);
            queue.get(i).left = left;
            queue.get(i).right = right;
        }
        return queue.get(0);
    }
}
