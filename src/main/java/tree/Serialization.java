package tree;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author qingqing
 * @function:
 * @create 2021-02-21-14:04
 */
//二叉树序列化:Serialization
//将二叉树序列化结果放入String中
public class Serialization {
    String NULL = "null";
    StringBuilder subTree = new StringBuilder();
    List<Integer> a = new LinkedList<>();
    public String serialize(TreeNode root){
        //定义一个用于存放序列化结果的list变量
        serialize(root, subTree);
        return subTree.toString();
    }

    public void serialize(TreeNode root, StringBuilder subTree){
        if(root == null) {
            subTree.append("null").append(",");
            return;
        }
        subTree.append(root.val).append(",");
        serialize(root.left, subTree);
        serialize(root.right, subTree);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(",")) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }
    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        /****** 前序遍历位置 ******/
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if ( first.equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        /***********************/

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }

    @Test
    void test(){
        String str = "[1,2,3,null,null,4,5]";
        TreeNode root = TreeNode.mkTree(str);
        TreeNode res = deserialize(serialize(root));
        System.out.println(res);

    }

}


