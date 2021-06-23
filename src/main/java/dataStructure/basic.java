package dataStructure;

import java.util.*;

/**
 * @author 712
 * @function:  基础数据结构源码
 * @create 2021/6/9 9:38
 */
public class basic {
    public static void main(String[] args) {
        Map<String,Integer> m = new HashMap<>();
        m.put("a",1);
        m.put("b",2);
        m.put("c",2);
        m.put("d",1);
        m.put("e",2);
        m.put("f",2);
        m.put("h",1);
        m.put("i",2);
        m.put("g",2);
        m.put("k",1);
        m.put("l",2);
        m.put("m",2);
        m.put("n",2);
        m.put("o",2);
        m.put("p",1);
        m.put("q",2);
        m.put("r",2);
        System.out.println(m);
        boolean equals = m.get("a").equals(m.get("b"));
        System.out.println(equals);
    }
}
