package DP;

/**
 * @author 712
 * @function:  53. 最大子序和
 *找到状态转移方程：f(i)=max{f(i-1)+nums[i],nums[i]}
 * @create 2021/5/30 12:45
 */
public class maxSubArray53 {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = nums[0];
        for(int i=1;i<nums.length;i++){
            pre = Math.max(pre+nums[i], nums[i]);
            //看下f(i)有没有最大的大
            max = Math.max(max,pre);
        }
        return max;
    }
}
