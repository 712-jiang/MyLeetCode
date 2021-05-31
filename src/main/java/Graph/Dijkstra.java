package Graph;

/**
 * @author qingqing
 * @function:
 * @create 2021-05-06-17:54
 */
public class Dijkstra {

    public static void main(String[] args) {
        int[][] graph = new int[][]{                    //邻接矩阵
                {0, 2, -1, 6}
                , {2, 0, 3, 2}
                , {-1, 3, 0, 2}
                , {6, 2, 2, 0}
        };
        int[] dijkstra = dijkstra(graph,0);
        for(int i=0;i<graph.length;i++){
            System.out.println(dijkstra[i]);
        }
    }

    static int[] dijkstra(int[][] graph, int startindex){
        int length = graph.length;
        int[] result = new int[length];   //index-节点序号；value-当前节点到startindex的最小路径
        int[] noFind = new int[length];   //没有确定最短路径的节点
        for(int i=0;i<length;i++){
            result[i] = -1;  //所有节点到startindex的最短路径默认为-1
        }
        //A直接到达各节点的距离
        for(int j=0;j<length;j++){
            noFind[j] = graph[startindex][j];
        }
        noFind[0] = -1;  //排除自己到自己
        result[startindex]=0;  //自己到自己，距离肯定为0
        //开始更新每个点的最短距离
        for(int i=1;i<length;i++){
            int minIndex = -1;
            int minWay = Integer.MAX_VALUE;
            //BFS，遍历startindex到其他（还没确定最短路径的节点）节点的路径，找到最小的
            for(int j=0;j<length;j++){
                if(noFind[j]!=-1 && noFind[j]<minWay){
                    minWay = noFind[j];
                    minIndex = j;
                }
            }
            result[minIndex] = minWay;  //startindex到minIndex的最小路径
            noFind[minIndex] = -1;
            //更新noFind，由于startindex到其他节点的路径确定了，noFind中的路径也可能发生变化
            //检查minIndex到剩余节点的距离
            for(int j=0;j<length;j++){
                if(graph[minIndex][j]>0 && result[j]==-1){
                    int newDist = result[minIndex]+graph[minIndex][j];  //以minIndex节点为桥梁，到达j节点的最短路径
                    if(newDist<noFind[j] || noFind[j]==-1){
                        noFind[j]=newDist;
                    }
                }
            }
        }
        return result;
    }
}

