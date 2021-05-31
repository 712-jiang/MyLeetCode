package Graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author 712
 * @function:
 * @create 2021/4/27 20:29
 */
public class AdjacencyMatrixGraph {
    private ArrayList<Integer> vertices;   //顶点
    private int[][] edges;     //边表
    private int numOfVertices; //当前顶点数
    private int numOfEdges;    //当前边数
    private int maxNum;

    public AdjacencyMatrixGraph(int maxOfVertices) {
        this.maxNum = maxOfVertices;
        this.vertices = new ArrayList<>();
        this.edges = new int[maxOfVertices][maxOfVertices];
        //init 全为-1
        for(int i=0;i<maxOfVertices;i++){
            for(int j=0;j<maxOfVertices;j++){
                edges[i][j]=-1;
            }
        }
        numOfEdges=0;
        numOfVertices=0;
    }

    //增 顶点, 只是往vertices中填值而已，并没有实际增多顶点数
    public boolean putV(Integer vertex){
        if(numOfVertices<maxNum){
            vertices.add(numOfVertices,vertex);  //对应index添加vertex
            numOfVertices++;

            return true;
        }
        return false;
    }

    //增 边
    public boolean putEdge(int indexOfVertex1, int indexOfVertex2, int weight){
        if(indexOfVertex1<maxNum && indexOfVertex2<maxNum){
            edges[indexOfVertex1][indexOfVertex2] = weight;
            return true;
        }
        return false;
    }

    //访问 边
    public int[][] getEdges(){
        return edges;
    }

    public static void main(String[] args) {
        int maxVertex = 3;
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(3);
        int[][] edges = graph.getEdges();
        for(int i=0;i<maxVertex;i++){
            for(int j=0;j<maxVertex;j++){
                System.out.print(edges[i][j]);
            }
            System.out.println();
        }
        graph.putV(2);
        graph.putV(3);
        graph.putEdge(0,1,10);  //0号和1号节点之间添加连接，权重为10
        edges = graph.getEdges();
        for(int i=0;i<maxVertex;i++){
            for(int j=0;j<maxVertex;j++){
                System.out.print(edges[i][j]);
            }
            System.out.println();
        }
    }
}
