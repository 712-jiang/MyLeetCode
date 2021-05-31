package double_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
/**
 * @author qingqing
 * @function:  三数之和：leedcode15
 * 排序 + 双指针
 * for循环第一个数，后两个数用双指针枚举；
 * 【关键一】「双指针」，当需要枚举数组中的两个元素时，如果随着第一个元素的递增，第二个元素是递减的，那么就可以使用双指针的方法，
 * 将枚举的时间复杂度从 O(N^2)减少至 O(N)。
 * 使用双指针，枚举的数组必须是有序的！
 *
 * 【关键二】不能重复！排序后，每次枚举不是下一个数字，而是下一个不重复的数字！
 *
 * @create 2021-04-10-22：15
 */
public class threeSum15 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        for(int a=0;a<nums.length;a++){
            if(a==0 || nums[a] !=nums[a-1]){
                int b=a+1;
                int c=nums.length-1;
                while(b<c){
                    if(b>a+1 && nums[b] == nums[b-1]){
                        b++;
                        continue;
                    }
                    if(c<nums.length-1 && nums[c] == nums[c+1]){
                        c--;
                        continue;
                    }
                    if(nums[a]+nums[b]+nums[c]==0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[a]);
                        temp.add(nums[b]);
                        temp.add(nums[c]);
                        res.add(new ArrayList<Integer>(temp));
                        b++;
                    }
                    else if(nums[a]+nums[b]+nums[c]<0) b++;
                    else if(nums[a]+nums[b]+nums[c]>0) c--;
                }
            }
        }
        return res;
    }
}
