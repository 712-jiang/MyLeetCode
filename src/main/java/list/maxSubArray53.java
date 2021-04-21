package list;

import org.junit.jupiter.api.Test;

//leetcode53:最大子序和   应该用动态规划做：下面的解法行不通
public class maxSubArray53 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int sum = 0;
        for(int i=0;i<nums.length;i++) sum += nums[i];
        int i=0;
        int j=nums.length-1;
        int max=sum;
        int aim = 0;
        while(i<j){
            if(nums[i]<nums[j]) aim = i++;  //先赋值，再+1
            else if(nums[i]>nums[j]) aim = j--;
            else{
                if(nums[i+1]>nums[j-1]) aim = j--;
                else if(nums[i+1]<nums[j-1]) aim = i++;
                else {
                    aim = i++;
                    sum -= nums[j--];
                }
            }
            sum -= nums[aim];
            max= max>sum? max:sum;
        }
        return max;
    }
    @Test
    void test(){
        int[] nums = new int[]{1,2,-1,-2,2,1,-2,1,4,-5,4};  //这个例子确实通过不了，用双指针比较大小思路错了
        maxSubArray53 maxSubArray53 = new maxSubArray53();
        int res = maxSubArray53.maxSubArray(nums);
        System.out.println(res);
    }
}

