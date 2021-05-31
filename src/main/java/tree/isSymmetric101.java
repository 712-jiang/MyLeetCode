package tree;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author qingqing
 * @function:  101 对称二叉树
 * 检查leftRoot == rightRoot && leftTree.left == rightTree.right && leftTree.right == rightTree.left
 * @create 2021-02-23-13:48
 */
public class isSymmetric101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return comp(root.left, root.right);

    }
    boolean comp(TreeNode l, TreeNode r){
        //一直比较到二叉树末端，同时为null，则二叉树左右镜像为true
        if(l== null && r==null){
            return true;
        }
        //在不满足同时为null的情况下，有任意边为null，说明左右子树节点数都不同，镜像肯定为false
        if(l==null || r==null){
            return false;
        }
        return (l.val == r.val) && comp(l.left, r.right) && comp(l.right, r.left);
    }
}
