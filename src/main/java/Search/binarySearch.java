package Search;

/**
 * @author qingqing
 * @function:
 * @create 2021-03-25-13:43
 */
public class binarySearch {
    //在有序队列中查找
    public int BSearch(int[] nums, int target){
        if(nums.length == 0) return -1;
        int left=0;
        int right=nums.length-1;
        //如果没有等号，会漏掉left、right、mid指向同一数字的情况
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target) return mid;
            else if(target>nums[mid]) left = mid+1;
            else if(target<nums[mid]) right = mid-1;
        }
        return -1;
    }

    //有序队列中可能有重复，左侧边界索引
    public int BSearch_left(int[] nums, int target){
        if(nums.length == 0) return -1;
        //找到 target 时不要立即返回，而是缩小「搜索区间」的上界right，在区间[left, mid]中继续搜索，即不断向左收缩，达到锁定左侧边界的目的。
        int left = 0;
        int right = nums.length-1;   //查找范围是[left,right]
        while (left<=right){   //left = right +1 的时候退出
            int mid = left+(right-left)/2;
            if(nums[mid] == target) right=mid-1;   //!继续向左寻找target
            //如果[left,mid-1]中没有target-->target>nums[mid-1],left = mid+1,while结束，返回的left=right+1,正好指向target
            //如果[left,mid-1]中有target-->将能找到最左边的target
            else if(nums[mid] > target) right = mid-1;
            else if(nums[mid] < target) left = mid+1;
        }
        //注意while的结束条件是left>right，只用判断left是不是溢出！
        //一直没找到：溢出、nums[left]不为target
        if(left>nums.length || nums[left] != target)
            return -1;

        return left;
    }

    //有序队列中可能有重复，右侧边界索引
    public int BSearch_right(int[] nums, int target){
        if(nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target) left=mid+1;   //向右查找是否还有target，如果没有，将在nums[mid]>target处结束，right将指向target
            else if(nums[mid]>target) right=mid-1;
            else if(nums[mid]<target) left=mid+1;
        }
        //target在right中！
        if(right<0||nums[right]!=target)
            return -1;

        return right;
    }
}
