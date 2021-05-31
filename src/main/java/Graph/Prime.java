package Graph;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 712
 * @function:
 * @create 2021/4/27 21:35
 */
public class Prime {
    //使用static修饰，Prime类的所有实例共享该字段
    private static String[] vertices;  //存顶点
    static int[][] graph;         //存邻接矩阵
    private static final int Max= Integer.MAX_VALUE;   //用final修饰，经过构造函数后Max不会再改变

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //第一行，顶点
        vertices = s.nextLine().split(" ");
        int n = vertices.length;
        graph = new int[n][n];
        //后面每行是边矩阵
        for(int i=0;i<n;i++){
            int Max_num=0;   //记录当前节点和其他节点距离为Max的数量，防止有无边的节点，无法生成包含所有节点的最小生成树
            //在primeFun的while中陷入死循环
            for(int j=0;j<n;j++){
                int temp = s.nextInt();
                if(temp<0) {
                    graph[i][j]=Max;
                    Max_num++;
                }
                else graph[i][j]=temp;
            }
            if(Max_num==n){
                System.out.println("无法生成包含所有节点的最小生成树");
                return;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res = primeFun(0);
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }

    //startIndex:Prime开始节点-最小生成树的根节点
    public static ArrayList<Integer> primeFun(int startIndex){
        ArrayList<Integer> connectedVer = new ArrayList<>();   //存储已连接的节点
        connectedVer.add(startIndex);    //将当前节点标记为已连接
        while(connectedVer.size()<vertices.length){   //判断是否遍历了所有节点--如果有的节点没有任何连接，就不行
            int minWeight = Integer.MAX_VALUE;
            int minWeightTo = -1;
            //遍历已连接的节点
            for(int i=0;i<connectedVer.size();i++){
                int curVer = connectedVer.get(i);  //当前节点的编号
                //遍历已连接节点的每条边
                for(int j=0;j<graph[curVer].length;j++){
                    if(!connectedVer.contains(j)){    //只遍历没有访问过的节点
                        int tempWeight = graph[curVer][j];
                        if(tempWeight<minWeight){
                            minWeight = tempWeight;
                            minWeightTo = j;
                        }
                    }
                }
            }
            if(minWeightTo>0)  connectedVer.add(minWeightTo);  //防止只有一个节点，minWeightTo还是初始值
        }
        return connectedVer;
    }
}
