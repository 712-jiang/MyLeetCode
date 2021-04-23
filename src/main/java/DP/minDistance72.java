package DP;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 712
 * @function: 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数。
 * 将i,j视为word1(0-i) 转换成 word2(0-j)的最小操作数
 * @create 2021/4/23 10:59
 */
public class minDistance72 {
    //动态规划-备忘录
//    Map<List<Integer>,Integer> memo = new HashMap<>();  //key-(i,j),value-最小操作数
//    int res= Integer.MAX_VALUE;
//    public int minDistance(String word1, String word2) {
//        List<Integer> temp = new ArrayList<>();
//        int i = word1.length()-1;
//        int j = word2.length()-1;
//        temp.add(i);
//        temp.add(j);
//        if(memo.containsKey(temp))  return memo.get(temp);
//        if(i==-1) return j+1;  //可以理解为word1(0-0)转换成word2(0-j),需要j+1步操作
//        if(j==-1) return i+1;
//        if(word1.charAt(i) == word2.charAt(j)){  //相等，跳过
//            res = minDistance(word1.substring(0,i),word2.substring(0,j));
//            memo.put(temp,res);
//            return res;
//        }
//        //不相等
//
//        res = Math.min(
//                Math.min(
//                        minDistance(word1.substring(0,i),word2.substring(0,j))+1,     //替换
//                        minDistance(word1.substring(0,i),word2.substring(0,j+1))+1    //删除s1
//                ),
//                minDistance(word1.substring(0,i+1),word2.substring(0,j))+1     //插入s1
//        );
//        memo.put(temp,res);
//        return res;
//    }

    //DP table

    public int minDistance(String word1, String word2){
        int res= Integer.MAX_VALUE;
        List<Integer> temp = new ArrayList<>();
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int k=0;k<=m;k++) dp[k][0]=k;
        for(int k=0;k<=n;k++) dp[0][k]=k;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else {
                    res = Math.min(dp[i-1][j],dp[i][j-1]);
                    dp[i][j]=Math.min(res,dp[i-1][j-1])+1;
                }
            }
        }
        return dp[m][n];
    }
    @Test
    public void test(){
        String word1 = "horse";
        String word2 = "ros";
        minDistance72 minDistance72 = new minDistance72();
        int res = minDistance72.minDistance(word1,word2);
        System.out.println(res);
    }
}
