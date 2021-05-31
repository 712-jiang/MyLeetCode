package tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qingqing
 * @function:
 * @create 2021-02-22-22:29
 */
public class levelOrder102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        //将root一层压入队列
        Queue<TreeNode> q = new LinkedList<>();   //ArrayList没有继承Queue
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int num = q.size();  //一层的节点数；
            for(int i=0;i<num;i++){
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            res.add(new ArrayList(temp));
        }
        return res;
    }

    @Test
    void test(){
        String str = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNode.mkTree(str);
        List<List<Integer>> res = levelOrder(root);
        System.out.println(res);

    }
}
