package tree;

/**
 * @author qingqing
 * @function:  114二叉树展开为单链表
 *
 * @create 2021-02-19-15:53
 */
/*
 */
public class flatten114 {
    public void flatten(TreeNode root) {
        if(root == null) return;
        //自底向下，递归函数在执行操作前面！
        flatten(root.left);
        flatten(root.right);
//将root.left整个换到root.right，原来root.left全为null！！！
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        //指针p指向root
        TreeNode p = root;
        //遍历到最后一个right，将原来的root.right接在它后面
        while(p.right != null){
            p = p.right;
        }
        p.right = temp;
    }
}


