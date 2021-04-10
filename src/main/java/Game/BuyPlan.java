package Game;

import backTrack.subsets78;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qingqing
 * @function:
 * @create 2021-04-05-15:07
 */
public class BuyPlan {
    List<List<Integer>> res = new ArrayList<>();
    public int Solution(List<Integer> nums, int target){
        backtrack(nums, new ArrayList<Integer>(), target, 0,0);
        Object tt = res.size() % (1e9 + 7);
        return (int) (res.size() % (1e9 + 7));
    }
    void backtrack(List<Integer> nums, ArrayList<Integer> temp, int target, int sum, int start){
        //结束条件
        if(target<sum) return;
        if(temp.size() == 2){
            if(target >= sum){
                res.add(new ArrayList<>(temp));
                return;
            }
        }

        for(int i=start;i<nums.size();i++){
            temp.add(nums.get(i));
            sum +=nums.get(i);
            backtrack(nums, temp, target, sum, i+1);  //i++和i+不一样熬
            sum -=temp.remove(temp.size()-1);
        }
    }
    @Test
    void test(){
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(5);
        nums.add(3);
        nums.add(5);
        int target = 6;
        BuyPlan test = new BuyPlan();
        int res = test.Solution(nums,target);
        System.out.println(res);
    }
}
