package double_pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 712
 * @function:无重复字符的最长子串
 * 找出不含有重复字符的 最长子串 的长度
 * @create 2021/5/30 10:29
 */
public class lengthOfLongestSubstring003 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> node = new HashMap<>();
        int max = 0;
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int left=0;
        int right=0;
        while(right<s.length()){
            if(node.containsKey(s.charAt(right))){
                int curIndex = node.get(s.charAt(right))+1;
                for(int i=left;i<curIndex;i++)
                    node.remove(s.charAt(i));
                //把left更新过去
                left = curIndex;
            }
            else if(!node.containsKey(s.charAt(right))){
                node.put(s.charAt(right),right);
                right++;
            }
            if(max<(right-left))
                max = right-left;
        }
        return max;
    }
}
