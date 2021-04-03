package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qingqing
 * @function: 括号问题：所有合法括号的排列组合结果  leedcode22
 * @create 2021-04-03-22:29
 */
public class Brackets22 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n==0) return null;
        StringBuilder temp = new StringBuilder();
        backtrack(temp,n,0,0);
        return res;
    }
    void backtrack(StringBuilder temp, int n,int right, int left){
        //结束条件，左右括号相等
        if(left == n && right == n){
            res.add(temp.toString());
            return;
        }
        //路径：temp
        //选择列表：左括号或者右括号，这里就不用for了
        if(left<right)
            return;
        //相当于for循环中的i<n，用来结束递归！！！！
        if(left>n || right>n)
            return;
        //增加左括号
        temp.append('(');
        backtrack(temp,n,right,left+1);
        //temp中是放left和right的，删除末尾字符不能只考虑left或者right的数量！！！
        temp.deleteCharAt(left+right);

        //增加右括号
        temp.append(')');
        backtrack(temp,n,right+1,left);
        temp.deleteCharAt(left+right);
    }
}
