import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 712
 * @function:
 * @create 2021/4/22 21:49
 */
public class test {
    TreeNode newRoot;
    List<Integer> res = new ArrayList<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //找到target节点的father,当作新树的根节点newRoot
        dfs(root,target,null);
        collect(newRoot,0,k-1);
        collect(target,0,k);
        return res;
    }
    //father是root的父节点
    public boolean dfs(TreeNode root, TreeNode target, TreeNode father){
        if(root==null) return false;
        if(root==target){
            newRoot=father;
        }
        if(dfs(root.left,target,root)){   //如果root的左节点是target，target为根，成为一棵独立子树
            //root无left，反向二叉树，将root的根节点的father接为root的left
            root.left=father;
            return true;
        }
        if(dfs(root.right,target,root)){
            root.right=father;
            return true;
        }
        return false;
    }

    public void collect(TreeNode root, int n, int k) {
        if (root == null) {
            return;
        }
        // 如果达到指定搜索深度，返回搜寻结果
        if (n == k) {
            res.add(root.val);
        } else {
            collect(root.left, n + 1, k);
            collect(root.right, n + 1, k);
        }
    }

    class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
    }
    @Test
    public void tese(){
        TreeNode root = new TreeNode(3);
        makeTree(root.left,5);
        makeTree(root.right,1);
        makeTree(root.left,5);
        makeTree(root.right,1);
    }
    public void makeTree(TreeNode subroot,int val){

    }
}
