import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class test {
    HashMap<Integer, ArrayList<Integer>> radj, badj;  //邻接表
    int sign = 0;  //标记上次是红是蓝
    int Osign = 0;
    int[] Ovisited;
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        Ovisited = new int[n];
        //构建邻接表
        radj = new HashMap<>();
        for(int k=0;k<n;k++){
            radj.put(k,new ArrayList<>());
        }
        for(int i=0;i<red_edges.length;i++){
            int key = red_edges[i][0];
            int val = red_edges[i][1];
            radj.get(key).add(val);
        }
        badj = new HashMap<>();
        for(int k=0;k<n;k++){
            badj.put(k,new ArrayList<>());
            Ovisited[k]=1;
        }
        for(int i=0;i<blue_edges.length;i++){
            int key = blue_edges[i][0];
            int val = blue_edges[i][1];
            badj.get(key).add(val);
            if(radj.get(key).size()!=0) Ovisited[key]++; //有红有蓝的节点
        }

        int[] answer = new int[n];
        if(radj.get(0).size()!=0) Osign=1;
        else if(badj.get(0).size()!=0) Osign=-1;
        else if(radj.get(0).size()==0 && badj.get(0).size()==0){
            answer[0]=0;
            for(int i=1;i<n;i++){
                answer[i]=-1;
            }
            return answer;
        }
        //j为终点
        for(int j=1;j<n;j++){
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            sign = Osign;
            answer[j] = BFS(j,q,n);
        }
        return answer;
    }
    public int BFS(int target,Queue<Integer> q,int n){
        int count=0;
        int[] visited = new int[n];
        for(int i=0;i<n;i++){
            visited[i] = Ovisited[i];
        }
        while(!q.isEmpty()){
            int size = q.size();
            //adj遍历red
            if(sign==1){
                for(int i=0;i<size;i++){
                    int cur = q.poll();
                    //终点判断
                    if(cur==target) return count;
                    //遍历adj
                    for(int j=0;j<radj.get(cur).size();j++){
                        int node = radj.get(cur).get(j);
                        if(visited[node]!=0){
                            q.offer(node);
                            visited[node]--;
                        }
                    }
                }
            }
            //遍历blue
            else if(sign==-1){
                for(int i=0;i<size;i++){
                    int cur = q.poll();
                    //终点判断
                    if(cur==target) return count;
                    //遍历adj
                    for(int j=0;j<badj.get(cur).size();j++){
                        int node = badj.get(cur).get(j);
                        if(visited[node]!=0){
                            q.offer(node);
                            visited[node]--;
                        }
                    }
                }
            }
            count = count+1;
            sign=-sign;
        }
        return -1;
    }
    @Test
    public void test(){
        int n = 5;
        int[][] red_edges = new int[][]{{0,1},{1,2},{2,3},{3,4}};
        int[][] blue_edges = new int[][]{{1,2},{2,3},{3,1}};
        test test = new test();
        int[] res = test.shortestAlternatingPaths(n,red_edges,blue_edges);
        for(int t:res) System.out.println(t);
    }
}