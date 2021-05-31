package list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 712
 * @function:  54. 螺旋矩阵
 * 从左往右-->从上往下-->从右往左-->从下往上；从外向内一圈一圈遍历
 * 增加退出循环条件，应对边界问题：长方形，最里面一层不需要执行四步循环！left>right  or   top>dom,提前结束
 * @create 2021/5/30 12:52
 */
public class spiralOrder54 {
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
            if(top>dom) break;

            //从上往下
            for(int i=top;i<=dom;i++){
                res.add(matrix[i][right]);
            }
            right = right-1;
            if(left>right) break;

            //从右往左
            for(int i=right;i>=left;i--){
                res.add(matrix[dom][i]);
            }
            dom = dom-1;
            if(top>dom) break;

            //从下往上
            for(int i=dom;i>=top;i--){
                res.add(matrix[i][left]);
            }
            left = left+1;
            if(left>right) break;

        }
        return res;
    }
}
