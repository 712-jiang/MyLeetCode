package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author 712
 * @function:
 * @create 2021/4/27 16:49
 */
public class Graph {
    private int V;        //节点数
    private int E;              //边数
    public List<Integer>[] adj;   //邻接表

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (List<Integer>[]) new List[V];
        for(int v=0;v<V;v++){
            adj[v] = new ArrayList<Integer>();
        }
    }
    public Graph(Scanner s){
        s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        for(int i=0;i<E;i++){
            int v = s.nextInt();
            int w = s.nextInt();
            addEdge(v,w);   //添加这条边
        }
    }
    public int V(){return V;}
    public int E(){return E;}
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

}
