package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 712
 * @function:22. 括号生成
 * 回溯，按照模板来
 * 判断结束条件（合法的加入res，不合法直接return）-->前序：增加左括号，backtrack，删除-->后序：增加右括号，backtrack，删除；
 * @create 2021/5/30 11:25
 */
public class generateParenthesis22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n==0) return null;
        StringBuilder temp = new StringBuilder();
        backtrack(temp,n,0,0);
        return res;
    }
    void backtrack(StringBuilder temp, int n,int right, int left){
        //结束条件，左右括号相等?
        if(left == n && right == n){
            res.add(temp.toString());
            return;
        }
        //路径：temp
        //选择列表：左括号或者右括号，这里就不用for了
        if(left<right)
            return;
        //相当于for循环中的i<n，用来结束递归
        if(left>n || right>n)
            return;
        //增加左括号
        temp.append('(');
        backtrack(temp,n,right,left+1);
        temp.deleteCharAt(left+right);

        //增加右括号
        temp.append(')');
        backtrack(temp,n,right+1,left);
        temp.deleteCharAt(left+right);
    }
}
