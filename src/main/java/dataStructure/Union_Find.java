//package dataStructure;
//
///**
// * @author qingqing
// * @function:
// * @create 2021-03-06-14:43
// */
//public class Union_Find {
//    //定义一个类
//    //包含如下三个方法：
//    //连接p、q
//    //判断p、q是否连接
//    //计算联通区域的数量
//    class UnionFind {
//        //联通区域的个数
//        int count;
//        //存储一棵树
//        int[] parent;
//        //记录每棵树的深度，用于维持平衡
//        int[] rank;
//        //想办法把grid铺平，变成模板中的n个互相散列的节点
////        public UnionFind(char[][] grid) {
////            count = 0;
////            int m = grid.length;
////            int n = grid[0].length;
////            parent = new int[m * n];
////            rank = new int[m * n];
////            for (int i = 0; i < m; ++i) {
////                for (int j = 0; j < n; ++j) {
////                    if (grid[i][j] == '1') {
////                        parent[i * n + j] = i * n + j;
////                        ++count;
////                    }
////                    rank[i * n + j] = 0;
////                }
////            }
////        }
//
//        //找到i的父节点
//        public int find(int i) {
//            if (parent[i] != i) {
//                parent[i] = parent[parent[i]];
//                i = parent[i];
//            }
//            return i;
//        }
//
//        //连接x y
//        public void union(int x, int y) {
//            int rootx = find(x);
//            int rooty = find(y);
//            if (rootx != rooty) {
//                if (rank[rootx] > rank[rooty]) {
//                    parent[rooty] = rootx;
//                } else if (rank[rootx] < rank[rooty]) {
//                    parent[rootx] = rooty;
//                } else {
//                    parent[rooty] = rootx;
//                    rank[rootx] += 1;
//                }
//                --count;
//            }
//        }
//
//        public int getCount() {
////            String
//            return count;
//        }
//    }
//
//    //具体应用的方法：
//    //适时增加虚拟节点，想办法让元素「分门别类」，建立动态连通关系
//    public int numIslands(char[][] grid) {
//        if (grid == null || grid.length == 0) {
//            return 0;
//        }
//
//        int nr = grid.length;
//        int nc = grid[0].length;
//        int num_islands = 0;
//        UnionFind uf = new UnionFind(grid);
//        for (int r = 0; r < nr; ++r) {
//            for (int c = 0; c < nc; ++c) {
//                if (grid[r][c] == '1') {
//                    grid[r][c] = '0';
//                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
//                        uf.union(r * nc + c, (r-1) * nc + c);
//                    }
//                    if (r + 1 < nr && grid[r+1][c] == '1') {
//                        uf.union(r * nc + c, (r+1) * nc + c);
//                    }
//                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
//                        uf.union(r * nc + c, r * nc + c - 1);
//                    }
//                    if (c + 1 < nc && grid[r][c+1] == '1') {
//                        uf.union(r * nc + c, r * nc + c + 1);
//                    }
//                }
//            }
//        }
//
//        return uf.getCount();
//    }
//}
//
