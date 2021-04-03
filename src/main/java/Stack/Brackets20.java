package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author qingqing
 * @function:  括号合法性判断  leedcode 20,用压栈和出栈检验左右括号的合法性
 * @create 2021-04-03-22:26
 */
public class Brackets20 {
    public boolean isValid(String s) {
        Map<String,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        int size = s.length();
        //排除奇数哈哈哈
        if(size%2 == 1) return false;
        //遍历s
        map.put("(",1);
        map.put(")",-1);
        map.put("[",2);
        map.put("]",-2);
        map.put("{",3);
        map.put("}",-3);
        for(int i=0; i<size; i++){
            String curkey = String.valueOf(s.charAt(i));
            //右括号，出栈
            if(map.get(curkey)<0){
                if(st.empty() || st.peek()+map.get(curkey) !=0) return false;
                st.pop();
            }
            //左括号，压栈
            if(map.get(curkey)>0) st.push(map.get(curkey));
        }
        return st.empty()? true:false;
    }
}
