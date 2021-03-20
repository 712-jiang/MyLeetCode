//package tree;
//
//import java.util.Iterator;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.ListIterator;
//
///**
// * @author qingqing
// * @function:
// * @create 2021-03-03-15:18
// */
//public class leetcode341 {
//    //实例化一个Iterator对象 it
//    private ListIterator<Integer> it;
//
//    public leetcode341(List<NestedInteger> nestedList) {
//        // 存放将 nestedList 打平的结果
//        List<Integer> result = new LinkedList<>();
//        for (NestedInteger node : nestedList) {
//            // 以每个节点为根遍历
//            traverse(node, result);
//        }
//        // 得到 result 列表的迭代器
//        //List的接口：iterator()，用这种方法迭代，效率高，会根据result类型选择最佳的迭代方法
//        this.it = result.iterator();
//    }
//
//    public Integer next() {
//        return it.next();
//    }
//
//    public boolean hasNext() {
//        return it.hasNext();
//    }
//
//    // 遍历以 root 为根的多叉树，将叶子节点的值加入 result 列表
//    private void traverse(NestedInteger root, List<Integer> result) {
//        if (root.isInteger()) {
//            // 到达叶子节点
//            result.add(root.getInteger());
//            return;
//        }
//        // 遍历框架
//        for (NestedInteger child : root.getList()) {
//            traverse(child, result);
//        }
//    }
//}
//
