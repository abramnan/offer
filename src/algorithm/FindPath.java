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

import baseclass.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    /**
     * 29ms
     * 9636k
     * 递归
     * 没有写数组长度大的在前
     * 但也通过了
     */
    private ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target){
        if(root==null){
            return result;
        }
        list.add(root.val);
        target-=root.val;
        if(target==0&&root.left==null&&root.right==null){
            result.add(new ArrayList<>(list));
        }
        findPath(root.left,target);
        findPath(root.right,target);
        list.remove(list.size()-1);//删除list中最后一个元素，类似于递归回溯
        return result;
    }

    /**
     * 非递归
     * 不对，还没写出来
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> findPath1(TreeNode root,int target){
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        if(root==null){
            return result;
        }
        stack.push(root);
        numStack.push(root.val);
        int sum = 0;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            sum+=node.val;
            if(node.left==null&&node.right==null&&target==sum){
                result.add(new ArrayList<Integer>(numStack));
                sum-=numStack.pop();
            }
            if(node.left!=null){
                stack.push(node.left);
                numStack.push(node.left.val);
            }
            if(node.right!=null){
                stack.push(node.right);
                numStack.push(node.right.val);
            }
        }
        return result;
    }
}
