package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author 712
 * @function:
 * @create 2021/5/11 13:18
 */
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

//遍历，考虑递归
public class cloneGraph133 {
    List<Node> memary = new ArrayList<>();  //记录clone过的节点
    public static void main(String[] args) {

        int val = 5;
        Node node = new Node(val);
        Node newnode = new Node(node.val);
        List<Node> memory = new ArrayList<>();
        memory.add(newnode);
        if(memory.contains(node)) System.out.println("1");
        if(memory.contains(newnode)) System.out.println("2");
        if(!memory.contains(node)) System.out.println("3");

    }
//    public Node cloneGraph(Node node) {
//        if(node == null) return node;
//        if(!memary.contains(node)){
//            Node clonenode = new Node(node.val, new ArrayList());
//            memary.add(node);  //记录访问过的节点
//            for(Node neighbor: node.neighbors){
//                clonenode.neighbors.add(cloneGraph(neighbor));  //在clone neighbors的时候，将neighbor节点clone过来
//            }
//            return clonenode;
//        }
//        else if(memary.contains(node)){
//            Node newnode = new Node(node.val);
//            return newnode;  //如果neighbor已经添加进来，直接返回当前节点值，注意不能直接返回node，否则是浅克隆
//        }
//    }
}
