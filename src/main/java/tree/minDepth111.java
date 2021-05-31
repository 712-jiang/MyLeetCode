package tree;

/**
 * @author 712
 * @function:  111 二叉树的最小深度
 * @create 2021/5/30 16:36
 */
public class minDepth111 {
    //终止条件：遇到了子树（左右都是null）
    //返回值：左右都为空，返回1；左右只有一个不为空，返回不为空的最小深度；左右都不为空，返回小的做小深度
    //递归过程：只能站在当前节点，看当前的一棵子树！
    // return Math.min(min_left, min_right) + 1;  相当于return root子树的最小深度 + root
    private int min=Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        helper(root,1);
        return min;
    }

    public void helper(TreeNode root,int level){
        if(root==null||(root.left==null&&root.right==null)){
            min=Math.min(min,level);
        }
        if(level<min){
            if(root.left!=null)
                helper(root.left,level+1);
            if(root.right!=null)
                helper(root.right,level+1);
        }
    }
}
