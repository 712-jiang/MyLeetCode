package DP;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 712
 * @function: 121. 买卖股票的最佳时机
 *  //卖出日期向前找最小值
 * @create 2021/4/13 15:56
 */
public class maxProfit121 {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int maxPro = prices[1]-prices[0];
        List<Integer> res = new ArrayList<>();
        res.add(0);
        //i代表第几天买入，j代表第几天卖出
        for(int i=0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                int temp = Math.max(res.get(j-1), prices[j]-prices[i]);
                res.add(temp);
                maxPro = Math.max(maxPro, temp);
            }
        }
        //如果不管怎么买都赔钱，就不买，返回0
        return maxPro>0? maxPro:0;
    }
    @Test
    public void test(){
        int[] prices = new int[]{7,6,4,3,1};
        maxProfit121 test = new maxProfit121();
        int result = test.maxProfit(prices);
        System.out.println(result);
    }
}
