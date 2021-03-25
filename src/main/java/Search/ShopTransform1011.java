package Search;

import org.junit.jupiter.api.Test;

/**
 * @author qingqing
 * @function:
 * @create 2021-03-25-20:10
 */
public class ShopTransform1011 {
    public int shipWithinDays(int[] weights, int D) {
        int left=getmax(weights);  //保证所有包裹都能放到船上
        int right=getsum(weights);  //一天将所有包裹运出去--[left,right]闭区间
        int max = right;
        int min = left;
        //求左边界
        while(left<=right){
            int mid = left+(right-left)/2;
            if(helper(weights,mid,D)) right = mid-1;
            else left=mid+1;
        }
        if(left > max || !helper(weights,left,D)){
            return -1;
        }
        return left;
    }
    public boolean helper(int[] weights, int mid, int D){
        int sum=0;
        for(int n:weights){
            sum += n;
            if(sum == mid) {
                D--;
                sum=0;
            }
            else if(sum > mid){
                D--;
                sum=n;
            }
        }
        if(sum>0)  D--;    //如果还有最后一个包裹，如果没有和倒数第二个包裹一起上船，需要单独上船
        return D>=0;
    }

    public int getmax(int[] weights){
        int max = weights[0];
        for(int m: weights){
            max = (max<m)? max=m:max;
        }
        return max;
    }

    public int getsum(int[] weights){
        int sum = 0;
        for(int m: weights){
            sum += m;
        }
        return sum;
    }

    @Test
    public void test(){
        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
        int D = 1;
        ShopTransform1011 test = new ShopTransform1011();
        System.out.println(test.shipWithinDays(weights,D));
    }

}
