package sort;

import org.junit.jupiter.api.Test;

/**
 * @author qingqing
 * @function:
 * @create 2021-03-15-16:39
 */
public class QuickSort {
    public int[] sortArray(int[] nums) {
        int left=0;
        int right=nums.length-1;
        subSort(nums,left,right);
        return nums;
    }
    void subSort(int[] nums, int left, int right){
        //从上往下分到底，排序结束
        if(left>=right) return;
        //找分割点
        int j = partPoint(nums,left,right);
        //递归
        subSort(nums,left,j-1);
        subSort(nums,j+1,right);  //中间的j已经排好了，不应该再动
    }
    int partPoint(int[] nums, int left, int right){
        int i = left;
        int j = right;
        while(i<j){
            //从左往右找到第一个比nums[left]大的数
            while(nums[i]<=nums[left]){
                if(i>=right) break;
                i++;
            }
            //从右往左找到第一个比nums[left]小的数
            while(nums[j]>=nums[left]){
                if(j<=left) break;
                j--;
            }
            if (i>=j) break;   //当left是最小，i和j可能会跨过对方，此时不应该执行下面的交换
            //i和j互换
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        //以nums[left]为baseline的排序完成，将nums[left]放到i or j处（ij是同一个位置）
        int mid = nums[j];
        nums[j] = nums[left];
        nums[left] = mid;
        return j;
    }

    @Test
    void test(){
        int[] input = new int[]{2,35,6,9,0,11,4,6,7,300};
        QuickSort test = new QuickSort();
        test.sortArray(input);
        for (int i : input) {
            System.out.println(i);
        }
    }
}
