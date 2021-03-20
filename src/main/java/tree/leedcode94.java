package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qingqing
 * @function:94. 二叉树的中序遍历
 * @create 2021-02-18-22:18
 */
public class leedcode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }
    public void inorder(TreeNode root, List<Integer> res){
        if(root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}

