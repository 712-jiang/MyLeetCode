package lru;

import java.util.*;

/**
 * @author qingqing
 * @function:
 * @create 2021-03-10-14:14
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
        cache.put(1,2);
        cache.put(1,4);
        System.out.println(cache);



    }
}
