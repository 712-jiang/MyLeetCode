package tree;

/**
 * @author qingqing
 * @function:二叉树展开为单链表
 * @create 2021-02-19-15:53
 */
/*
 */
public class leedcode114 {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        TreeNode p = root;
        while(p.right != null){
            p = p.right;
        }
        p.right = temp;


    }

}


