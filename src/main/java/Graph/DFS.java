package Graph;

/**
 * @author 712
 * @function:
 * @create 2021/4/27 18:10
 */
public class DFS {
    private boolean[] marked;
    private int count;
    public DFS(Graph G,int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }
    public void dfs(Graph G, int v){

    }
}
