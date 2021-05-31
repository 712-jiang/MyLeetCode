package list;


import java.util.HashMap;

/**
 * @author qingqing
 * @function:  两数之和：leedcode01
 * 数组 nums 和目标值 target，在该数组中找出 和 为目标值 target的那两个整数，
 * @create 2021-04-10-22：10
 */
public class twoSum01 {
    public int[] solution(int[] nums, int target) {
        HashMap<Integer,Integer> res = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(res.containsKey(target-nums[i])){    //暴力解法，查找target-num[i]的时间复杂度是O(N),HashMap查找key的时间复杂度为O(1)
                return new int[]{i,res.get(target-nums[i])};
            }
            res.put(nums[i],i);    //判断当前nums[i]和前面已经遍历过的值能否得到target
        }
        return null;
    }

    public static void main(String[] args) {
        int aim=0;
        int i=10;
        aim = i--;
        System.out.println(aim);
    }
}
