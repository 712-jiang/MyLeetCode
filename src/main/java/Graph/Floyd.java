package Graph;

/**
 * @author qingqing
 * @function:
 * @create 2021-05-07-16:24
 */
public class Floyd {
    public static int[][] distance;   //距离矩阵
    public static int[][] path;       //路径矩阵
    public static void main(String[] args) {
        char[] vertices = new char[]{'A', 'B', 'C', 'D'};
        int[][] graph = new int[][]{
                {0, 2, -1, 6}
                , {2, 0, 3, 2}
                , {-1, 3, 0, 2}
                , {6, 2, 2, 0}};
        floyd(graph);
        System.out.println("====distance====");
        for (int[] ints : distance) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("====path====");
        for (int[] ints : path) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void floyd(int[][] graph){
        distance=graph;
        int length = graph.length;
        //初始化path
        path = new int[length][length];
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                path[i][j]=j;
            }
        }
        //初始化distance
        for(int k=0;k<length;k++){           //中转点
            for(int i=0;i<length;i++){       //出度点
                for(int j=0;j<length;j++){   //入度点
                    if(distance[k][i]!=-1 && distance[j][k]!=-1){
                        int newDist = distance[k][i]+distance[j][k];
                        if(newDist<distance[j][i] || distance[j][i]==-1){   //经中转可以到达/小于直接到达
                            distance[j][i]=newDist;  //更新距离
                            path[j][i]=k;        //更新path，经过中转点
                        }
                    }
                }
            }
        }
    }
}
