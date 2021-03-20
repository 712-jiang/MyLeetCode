package double_pointer;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author qingqing
 * @function:
 * @create 2021-03-16-21:21
 */
public class SlidingWindow {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<String, Integer> need = new HashMap<>();
        HashMap<String, Integer> window = new HashMap<>();
        int valid=0;
        int left=0, right=0;
        for(int i=0; i<s1.length(); i++) {
            String c = String.valueOf(s1.charAt(i));
            need.put(c,need.getOrDefault(c,0)+1);
        }

        //移动right
        while(right<s2.length()){
            String c = String.valueOf(s2.charAt(right));
            right++;
            //更新window
            if(s1.contains(c)) {
                window.put(c,window.getOrDefault(c,0)+1);  //存在+1，不存在创建+1
                //判断window？=need
                if(window.get(c) == need.get(c)) valid++;
            }
            System.out.println("window:"+ left+"/"+ right);
            //因为本题要求连续包含s1的排列--窗口中不能包含其他字符
            //当窗口长度等于s1的长度，立刻暂停扩大
            //排列，允许重复，所以窗口大小应该大于等于s1
            while(right-left == s1.length()){
                //判断是否满足条件
                //s1中可能有重复的字符
                if(valid == need.size()) return true;
                String s = String.valueOf(s2.charAt(left));
                //在判断s之前就left++，如果窗口中
                left++;
                //更新windows
                if(s1.contains(s)) {
                    if(window.get(s) == need.get(s)) valid--;
                    window.put(s,window.get(s)-1);  //存在且大于，-1
                }
            }
        }
        return false;
    }
    @Test
    void test(){
        String s1 = "qyy";
        String s2 = "qesyqydhffgujy";
        SlidingWindow test = new SlidingWindow();
        boolean res = test.checkInclusion(s1,s2);
        System.out.println(res);
    }
}
