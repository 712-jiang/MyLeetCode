package DP;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author 712
 * @function: leetcode354俄罗斯套娃信封问题：
 * 【重点1】对二维数组排序，需要给sort自定义compare方法：按照w升序排列，w相同时，按照h【从大到小】降序排列
 * 【重点2】拿到按照w大小排好序的h，求他的最长递增子序列：LIS
 * @create 2021/4/23 21:53
 */
public class maxEnvelopes354 {
    public int maxEnvelopes(int[][] envelopes) {
        //先排序
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){   //a、b是记录[w,h]数组
                if(a[0]==b[0]) return b[1]-a[1]; //w相等，按照h倒序排列（从大到小），这样后面使用LIS最大升序子序列计算，不会同时加入两个w相等的数组-因为“降序”，因为后面的h都比前面的小！！
                else return a[0]-b[0];
            }
        });
        //构造LIS计算对象nums
        int[] nums = new int[envelopes.length];
        for(int i=0;i<envelopes.length;i++){
            nums[i]=envelopes[i][1];
        }
        //开始LIS
        return LIS(nums);
    }

    int LIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int max = 1;
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    @Test
    public void test(){
        int[][] prices = new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}};
        maxEnvelopes354 test = new maxEnvelopes354();
        int result = test.maxEnvelopes(prices);
        System.out.println(result);
    }
}
