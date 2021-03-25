package Search;

import org.junit.jupiter.api.Test;
import sort.QuickSort;

/**
 * @author qingqing
 * @function:
 * @create 2021-03-25-16:34
 */
public class EatBanana875 {
    //二分查找，吃香蕉速度为k，k可能的结果是一个有序的搜索空间
    //需要找到最小的k-->找到二分查找的左边界
    public int minEatingSpeed(int[] piles, int h) {
        //找到最小的速度K
        //速度k是1-max(piles)中的某个数，尽量小，不可能超过piles中最大值
        int kleft=1;
        int kright=findMax(piles);
        int max = kright;
        //找左边界
        while(kleft<=kright){
            int mid = kleft+(kright-kleft)/2;
            //mid为对比对象，其中放着当前的k
            //相当于nums[mid]==target
            if(helper(piles,mid,h)) kright = mid-1;
            else kleft = mid+1;
        }
        if(kleft>max || !helper(piles,kleft,h))
            return -1;
        return kleft;
    }

    //只判断当前mid作为吃香蕉的速度是否能在H小时内吃完
    //不考虑速度是不是最小
    public boolean helper(int[] piles, int mid, int h){
        //用mid与piles的每个值相除
        int time=0;
        int subtime=0;
        for(int n: piles){
            subtime = n/mid + ((n%mid>0)? 1:0);
            time = time + subtime;
        }
        return time<=h;
    }

    public int findMax(int[] piles){
        int max=piles[0];
        for(int i=0;i<piles.length;i++)
            if(piles[i]>max)  max = piles[i];
        return max;
    }

    @Test
    public void test(){
        int[] piles = new int[]{3,6,7,11};
        int h = 8;
        EatBanana875 test = new EatBanana875();
        System.out.println(test.minEatingSpeed(piles,h));
    }

}
