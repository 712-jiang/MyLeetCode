package tree;

/**
 * @author 712
 * @function:  98. 验证二叉搜索树
 * 通过上下界来判断：
 * 左子树，不考虑下界，上界为左子树的root节点（左子树上的节点都小于root）
 * 右子树，不考虑上界，下界为右子树的root节点（右子树的节点都大于root）
 * @create 2021/5/30 16:17
 */
public class isValidBST98 {
    Long lower = Long.MIN_VALUE;
    Long higher = Long.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        return helper(root, lower, higher);
    }
    public boolean helper(TreeNode root, long lower, long higher){
        if(root == null) return true;
        //一旦碰到false就返回
        if(lower >= root.val) return false;
        if(higher <= root.val) return false;
        //左子树中，不考虑下界，上界为左子树的root节点（左子树上的节点都小于root）
        //右子树中，不考虑上界，下界为右子树的root节点（右子树的节点都大于root）
        return helper(root.left, lower, root.val) && helper(root.right, root.val, higher);
    }
}
