package tree;

/**
 * @author 712
 * @function: 100. 相同的树
 * 不要想复杂：递归，比完p_root,q_root,再分别比两棵树的left和right
 * @create 2021/5/30 16:01
 */
public class isSameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //包含两种情况：
        // （1）两个空二叉树比较
        // （2）两个完全相同的二叉树比较，比完最后的叶子节点都没有return false，返回的.left .right都是null
        if(p == null && q == null) return true;
        if(q == null || p == null) return false;
        if(p.val !=q.val) return false;
        //如果当前的两个节点相同，则应该继续比较！
        //如果已经比较到两个二叉树的最后一个节点了，此时递归调用传入的参数都是null，将return true。
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
