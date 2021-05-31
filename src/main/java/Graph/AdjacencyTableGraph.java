package Graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author 712
 * @function:
 * @create 2021/4/27 22:04
 */
class EdgeNode{
    int vex;     //当前节点的下标-出发点-顶点表对应元素的下标
    int adjVex;  //目标点-边表中对应元素的下标
    int weight;
    EdgeNode next;
    public EdgeNode(int vex, int adjVex, int weight) {
        this.vex = vex;
        this.adjVex = adjVex;
        this.weight = weight;
        this.next = null;
    }
}

class VertexNode<T>{
    T vex_value;
    EdgeNode firstedge;
    public VertexNode(T vex_value) {
        this.vex_value = vex_value;
        this.firstedge = null;
    }
}

public class AdjacencyTableGraph {
    int numVertexes;   //顶点数量
    int numEdges;      //边的数量
    private ArrayList<VertexNode> vexs;  //顶点表
    boolean[] visited;  //访问记录

    //初始化table
    public AdjacencyTableGraph(int numVertexes, int numEdges) {
        this.numVertexes = numVertexes;
        this.numEdges = numEdges;
        this.vexs = new ArrayList<VertexNode>(numVertexes);
        this.visited = new boolean[numVertexes];
    }

    public void insertVex(VertexNode v) {
        vexs.add(v);
    }

    public void insertEdge(EdgeNode e) {
        int i = e.vex; // 顶点表中对应结点的下标
        int j = e.adjVex; // 边表结点对应的下标
        VertexNode vexi = vexs.get(i);
        VertexNode vexj = vexs.get(j);
        e.next = vexi.firstedge;
        vexi.firstedge = e;

        EdgeNode e2 = new EdgeNode(j, i, 1);
        e2.next = vexj.firstedge;
        vexj.firstedge = e2;
    }

    public void show() {
        for (int i = 0; i < numVertexes; i++) {
            VertexNode vex = vexs.get(i);
            System.out.print("【" + vex.vex_value + "】—>");
            EdgeNode node = vex.firstedge;
            while (node != null) {
                System.out.print(vexs.get(node.adjVex).vex_value + "(" + node.adjVex + ")" + "->");
                node = node.next;
            }
            System.out.print("null");
            System.out.println();
        }
    }
    private void DFS(int i) {   //对第i个顶点进行DFS
        EdgeNode p;          //声明一个边表节点
        visited[i] = true;   //标记已经访问过的顶点
        p=vexs.get(i).firstedge;   //取出i顶点的第一个边表节点
        while(p!=null){            //第i个顶点有边
            if(!visited[p.adjVex]){  //如果指向的顶点没有被访问过
                DFS(p.adjVex);       //将指向顶点作为起始点DFS
            }
            p = p.next;   //如果访问过了，就取另一个指向顶点
        }
    }

    private void DFSTraverse() {
        int i;
        for (i = 0; i < numVertexes; i++) {
            visited[i] = false;
        }
        for (i = 0; i < numVertexes; i++) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    private void BFSTraverse() {
        EdgeNode p;
        int i;
        LinkedList queue = new LinkedList();
        for (i = 0; i < numVertexes; i++) {
            visited[i] = false;
        }
        for (i = 0; i < numVertexes; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.print(vexs.get(i).vex_value + " ");
                queue.addLast(i);
                while (!queue.isEmpty()) {
                    i = (Integer) queue.removeFirst();
                    p = vexs.get(i).firstedge;
                    while (p != null) {
                        if (!visited[p.adjVex]) {
                            visited[p.adjVex] = true;
                            System.out.print(vexs.get(p.adjVex).vex_value + " ");
                            queue.addLast(p.adjVex);
                        }
                        p = p.next;
                    }
                }
            }
        }
    }
}
