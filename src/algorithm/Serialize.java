package algorithm;

import baseclass.TreeNode;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 *
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class Serialize {
    int index = -1;

    /**
     * 分别遍历左节点和右节点，空使用#代替，节点之间，隔开
     * 41ms
     * 9612k
     * @param root root
     * @return 0
     */
    String Serialize(TreeNode root) {
        if(root==null){
            return "#";
        }else {
            return root.val+"," + Serialize(root.left) + "," + Serialize(root.right);
        }
    }

    /**
     *
     * @param str str
     * @return s
     */
    TreeNode Deserialize(String str) {
        String[] s = str.split(",");
        index++;
        int len = s.length;
        if(index>=len){
            return null;
        }
        TreeNode treeNode = null;
        if(!s[index].equals("#")){
            treeNode = new TreeNode(Integer.parseInt(s[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;
    }
}
