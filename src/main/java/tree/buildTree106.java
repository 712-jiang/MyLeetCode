package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qingqing
 * @function:106. 从中序与后序遍历序列构造二叉树
 * @create 2021-02-19-14:11
 */
public class buildTree106 {
    static Map<Integer, Integer> inmap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i = 0; i<inorder.length; i++){
            inmap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    TreeNode build(int[] inorder, int inleft, int inright, int[] postorder, int postleft, int postright){
        if(inleft > inright) return null;
        int rootVal = postorder[postright];
        int index = inmap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int left_len = index-inleft;
        root.left = build(inorder,inleft,index-1, postorder, postleft, left_len+postleft-1);
        root.right = build(inorder,index+1,inright, postorder, left_len+postleft, postright-1);
        return root;
    }
}
