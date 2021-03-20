package tree;

/**
 * @author qingqing
 * @function: Offer 27. 二叉树的镜像
 * @create 2021-02-16-22:39
 */
//广度优先遍历BFS
//深度优先遍历DFS
//？？？？？？

public class offer27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
}
