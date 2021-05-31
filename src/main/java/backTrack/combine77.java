package backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 712
 * @function:  组合，对比求子集
 * 都是通过start避免重复
 * 判断结束的条件不同，其他都一样
 * @create 2021/5/30 15:49
 */
public class combine77 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(k==0 || n==0 || k>n) return null;
        backtrack(new ArrayList<Integer>(),n,k,1);
        return res;
    }
    void backtrack(ArrayList<Integer> temp, int n, int k, int start){
        if(temp.size() == k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<n+1; i++){

            temp.add(i);
            backtrack(temp,n,k,i+1);
            temp.remove(temp.size()-1);
        }
    }
}
