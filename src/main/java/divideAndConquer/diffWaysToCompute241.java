package divideAndConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author 712
 * @function:241. 为运算表达式设计优先级——分治算法
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，计算所有可能的组合的结果。有效的运算符号包含 +, - 以及 *
 * @create 2021/4/11 21:24
 */

public class diffWaysToCompute241 {
    //保存已经计算过的sub expression，不用再计算了
    HashMap<String, List<Integer>> memory = new HashMap<>();
    public List<Integer> diffWaysToCompute(String expression) {
        if(memory.containsKey(expression)) return memory.get(expression);
        List<Integer> res = new ArrayList<>();
        for (int i=0;i<expression.length();i++){
            char symbol = expression.charAt(i);
            if(symbol=='+' || symbol=='-' || symbol=='*'){
                //[0,i]中可以优left.length种加括号的方式，left中放了每种方式的结果
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                //index=i 位置是一个符号
                //right 每种加括号方式的结果
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for(int l:left){
                    for(int r:right){
                        if(symbol == '+') res.add(l+r);
                        else if(symbol == '-') res.add(l-r);
                        else if(symbol == '*') res.add(l*r);
                    }
                }
            }
        }
        //分治，从上向下分，当没有符号，递归就要开始返回，压栈结束
        //停止递归的条件
        if(res.isEmpty())
            res.add(Integer.valueOf(expression));
        memory.put(expression,res);   //记录前面的运算结果
        return res;
    }
}
