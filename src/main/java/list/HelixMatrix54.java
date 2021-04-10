package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qingqing
 * @function:  螺旋矩阵 leetcode54 以螺旋顺序读取矩阵（注意长方形！）
 * @create 2021-04-06-11:22
 */
//要增加结束条件！如果矩阵是长方形，最里面一层不需要执行四步循环！要找到终止在哪一步！
//否则会出现多读的情况
//一旦出现left>right  or   top>dom这种情况，说明遍历已经结束！
public class HelixMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;    //上边界
        int dom = m-1;  //下边界
        int left = 0;   //左边界
        int right = n-1; //右边界
        List<Integer> res = new ArrayList<>();
        while(true){
            //从左往右
            for(int i=left;i<=right;i++){
                res.add(matrix[top][i]);
            }
            top=top+1;
            if(top>dom) break;  //结束条件

            //从上往下
            for(int i=top;i<=dom;i++){
                res.add(matrix[i][right]);
            }
            right = right-1;
            if(left>right) break;  //结束条件

            //从右往左
            for(int i=right;i>=left;i--){
                res.add(matrix[dom][i]);
            }
            dom = dom-1;
            if(top>dom) break;   //结束条件

            //从下往上
            for(int i=dom;i>=top;i--){
                res.add(matrix[i][left]);
            }
            left = left+1;
            if(left>right) break;   //结束条件

        }
        return res;
    }
}
