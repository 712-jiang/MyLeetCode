//package dataStructure;
//
//import java.util.Arrays;
//import java.util.HashSet;
//
///**
// * @author qingqing
// * @function:找出数组中重复的数字
// * @create 2021-02-13-21:21
// */
///*
//HashSet,set中元素不能重复
// */
//public class offer03 {
//    public int findRepeatNumber(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        int repet = -1;
//        for(int num : nums){
//            if (! set.add(num)){
//                repet = num;
//                break;
//            }
//        }
//        return repet;
//    }
//}
//
///*
//排序，比较前后两个元素是否相同
// */
//class Solution2 {
//    public int findRepeatNumber(int[] nums) {
//        int repet = -1;
//        Arrays.sort(nums);
//        for(int i = 0; i < nums.length-1; i++){
//            if(nums[i] == nums[i+1]){
//                return nums[i];
//            }
//        }
//        return repet;
//    }
//}
//
///*
//还可以改为一个萝卜一个坑，假设没有重复，则nums排序后，数值和脚标相等
// */
//class Solution3 {
//    public int findRepeatNumber(int[] nums) {
//        int repet = -1;
//        int temp;
//        for(int i = 0; i < nums.length; i++){
//            while(nums[i] != i){
//                if(nums[i] == nums[nums[i]]){
//                    return nums[i];
//                }
//                temp = nums[i];
//                nums[i] = nums[temp];
//                nums[temp] = temp;
//            }
//        }
//        return repet;
//    }
//}