package algorithm;

import baseclass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetrical {
    /**
     * 递归
     * @param node1 node1
     * @param node2 node2
     * @return
     * 17ms
     * 9324k
     */
    public boolean judge(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null){
            return true;
        }else if(node1==null||node2==null){
            return false;
        }

        if(node1.val!=node2.val){
            return false;
        }else {
            return judge(node1.left,node2.right)&&judge(node1.right,node2.left);
        }
    }
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot==null){
            return true;
        }
        return judge(pRoot.left,pRoot.right);
    }

    /**
     * 设置两个链表，分别代表左子树和右子树。左子树每次都从左往右添加节点，右子树每次都从右往左添加节点。
     * @param pRoot p
     * @return 0
     *14ms
     * 9404k
     */
    boolean isSymmetrical1(TreeNode pRoot){
        if(pRoot==null){
            return true;
        }
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.offer(pRoot.left);
        right.offer(pRoot.right);
        while (!left.isEmpty()&&!right.isEmpty()){
            TreeNode leftNode = left.poll();
            TreeNode rightNode = right.poll();
            if(leftNode==null&&rightNode==null){
                continue;
            }
            if(leftNode==null||rightNode==null){
                return false;
            }
            if(leftNode.val!=rightNode.val){
                return false;
            }
            left.add(leftNode.left);
            left.add(leftNode.right);

            right.add(rightNode.right);
            right.add(rightNode.left);
        }
        return left.isEmpty()&&right.isEmpty();
    }
}
