package tree;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qingqing
 * @function:
 * @create 2021-02-22-22:29
 */
public class leedcode102 {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return null;
        List<Integer> temp = new LinkedList<>();
        temp.add(root.val);
        res.add(temp);
        traverse(root);
        return res;
    }
    void traverse(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> subres = new LinkedList<>();
            TreeNode cur =q.poll();
            if(cur.left == null && cur.right == null){
                continue;
            }
            if(cur.left != null){
                q.offer(cur.left);
                subres.add(cur.left.val);
            }
            if(cur.right != null){
                q.offer(cur.right);
                subres.add(cur.right.val);
            }
            res.add(subres);
        }
    }

    @Test
    void test(){
        String str = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.mkTree(str);
        List<List<Integer>> res = levelOrder(root);
        System.out.println(res);

    }
}
