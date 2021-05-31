package backTrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @author 712
 * @function:  46. 全排列
 * 标准模板，使用contains避免track中有重复字符
 * @create 2021/5/30 12:43
 */
public class fullPermutation46 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> temp = new LinkedList<>();
        backtrack(nums,temp);
        return res;
    }
    public void backtrack(int[] nums, LinkedList<Integer> temp){
        //结束条件
        if(temp.size() == nums.length){
            res.add(new LinkedList(temp));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(temp.contains(nums[i]))
                continue;
            temp.add(nums[i]);
            backtrack(nums,temp);
            temp.removeLast();
        }
    }
}
