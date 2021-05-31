package Graph;

import java.util.*;

/**
 * @author 712
 * @function:
 * @create 2021/5/25 15:11
 */
public class gardenNoAdj1042 {
    public int[] gardenNoAdj(int N, int[][] paths) {
        /* 这是一道简单题，限制每个节点的度为3，同时提供四种颜色，因此不需要回溯 */
        /* 初始化节点，使用map保存节点与其临界点的关系 */
        /* 第一版本采用了内部类构建，参考评论区的HashMap更简洁 */
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            graph.put(i, new HashSet<>());
        }
        /* 初始化路径信息 *///构建邻接表
        for (int[] path: paths) {
            int a = path[0] - 1;
            int b = path[1] - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        int[] res = new int[N];  //存放种花记录
        //优先给当前节点涂色，但是涂色前先检查一下邻接矩阵的已涂色情况，避免重复
        for (int i = 0; i < N; i++) {  //遍历graph
            boolean[] used = new boolean[5];  //初始值为false
            /* 查看当前节点的所有邻接点的色彩 */
            for (int adj: graph.get(i)) {
                if(res[adj]==0) continue;  //如果邻接花园尚未涂色，跳过即可
                used[res[adj]] = true;  //如果邻接花园涂色了，再used对应位置标记出来
            }
            /* 为当前节点染色 */
            for (int j = 1; j <= 4; j++) {
                if (!used[j]) {
                    res[i] = j;
                }
            }
        }
        return res;
    }
}
