package Graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

/**
 * @author 712
 * @function:
 * @create 2021/5/15 9:41
 */
public class smallestStringWithSwaps1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] sChar = s.toCharArray();
        int n = pairs.size();
        if(n==0) return s;
        for(int i=0;i<n;i++){
            List<Integer> cur = new ArrayList<>();
            cur = pairs.get(i);
            int x = cur.get(0);  //char的位置
            int y = cur.get(1);
            if(sChar[x]-sChar[y]>0){   //交换
                char temp = sChar[x];
                sChar[x] = sChar[y];
                sChar[y] = temp;
            }
        }
        return sChar.toString();
    }
    @Test
    public void test(){
        String s = "dcab";
        char[] test = new char[]{'b','a','c','d'};
        String te = test.toString();
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> e1 = new ArrayList<>();
        e1.add(0);
        e1.add(3);
        List<Integer> e2 = new ArrayList<>();
        e2.add(0);
        e2.add(3);
        pairs.add(e1);
        pairs.add(e2);
        smallestStringWithSwaps1202 smallestStringWithSwaps1202 = new smallestStringWithSwaps1202();
        String res = smallestStringWithSwaps1202.smallestStringWithSwaps(s,pairs);
        System.out.println(res);
    }
}
