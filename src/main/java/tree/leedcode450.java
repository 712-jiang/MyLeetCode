package tree;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author qingqing
 * @function:
 * @create 2021-02-27-11:24
 */
public class leedcode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key){
            if(root.left == null && root.right == null) return null;
            else{
                TreeNode temp = root.right;
                root = root.left;
                while(root.right != null){
                    root.right = root.right.right;
                }
                root.right = temp;
            }
            return root;
        }
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    @Test
    void test(){
        String str = "[5,3,6,2,4,null,7]";
        TreeNode root = TreeNode.mkTree(str);
        TreeNode res = deleteNode(root, 5);
        System.out.println(res);

    }
}
