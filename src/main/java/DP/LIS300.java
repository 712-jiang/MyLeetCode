package DP;

import org.junit.jupiter.api.Test;

/**
 * @author 712
 * @function:
 * @create 2021/4/23 14:51
 */
public class LIS300 {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int max = 1;
        int[] dp = new int[len];
        dp[0]=1;
        for(int i=1;i<len;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                max = Math.max(max,dp[i]);
            }
        }
        for(int i=0;i<nums.length;i++) System.out.println(dp[i]);
        return max;
    }
    @Test
    public void test(){
        int[] num = {10,9,2,5,3,7,101,18};
        LIS300 lis354 = new LIS300();
        int res = lis354.lengthOfLIS(num);
        System.out.println(res);
    }
}
