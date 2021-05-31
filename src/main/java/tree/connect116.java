package tree;

/**
 * @author 712
 * @function:
 * @create 2021/5/30 16:41
 */
public class connect116 {
    public Node connect(Node root) {
        if(root == null) return root;
        subconnect(root.left, root.right);
        return root;
    }
    void subconnect(Node node1, Node node2){
        if (node1 == null || node2 == null) return;
        //统一处理方式：一个节点的next指向另一个节点
        node1.next = node2;
        //同一父节点的两个节点
        subconnect(node1.left, node1.right);
        subconnect(node2.left, node2.right);
        //不同父节点的两个节点
        subconnect(node1.right, node2.left);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
