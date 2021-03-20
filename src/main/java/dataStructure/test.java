package dataStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author qingqing
 * @function:
 * @create 2021-02-21-16:18
 */
public class test {

    public static void main(String[] args) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> subres = new LinkedList<>();
        subres.add(1);
        subres.add(2);
        res.add(subres);
        subres = null;
        System.out.println(res);
        System.out.println(subres);
    }
}
