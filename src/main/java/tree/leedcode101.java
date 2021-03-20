package tree;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author qingqing
 * @function:
 * @create 2021-02-23-13:48
 */
public class leedcode101 {
    LinkedList<Integer> subleft = new LinkedList<>();
    LinkedList<Integer> subright = new LinkedList<>();
    LinkedList<Integer> sub = new LinkedList<>();
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        traverse(root.left);
        frontleft(root.left);
        frontright(root.right);
        int size = subleft.size();
        for (int i=0; i<size; i++) {
            if(subleft.get(i) != subright.get(i))
                return false;
        }
        return true;
    }
    //求left子树的镜像的前序遍历，对比right的前序遍历
    void traverse(TreeNode root){
        if(root == null) return;
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        traverse(root.left);
        traverse(root.right);
    }
    void frontleft(TreeNode root){
        if(root == null) return;
        subleft.add(root.val);
        frontleft(root.left);
        frontleft(root.right);
    }
    void frontright(TreeNode root){
        if(root == null) return;
        subright.add(root.val);
        frontright(root.left);
        frontright(root.right);
    }

    @Test
    void test(){
        String str = "[1,2,2,3,4,4,3]";
        TreeNode root = TreeNode.mkTree(str);
        boolean res = isSymmetric(root);
        System.out.println(res);

    }


}
