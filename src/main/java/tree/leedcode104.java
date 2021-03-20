package tree;

import org.junit.jupiter.api.Test;

/**
 * @author qingqing
 * @function:
 * @create 2021-02-22-21:33
 */
public class leedcode104 {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        else{
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right)+1;
        }

    }
    @Test
    void test(){
        String str = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.mkTree(str);
        int res = maxDepth(root);
        System.out.println(res);

    }

}
