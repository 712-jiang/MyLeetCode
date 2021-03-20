//package dataStructure;
//
//import tree.TreeNode;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author qingqing
// * @function:方法一：递归
// * 思路
// *
// * 对于任意一颗树而言，前序遍历的形式总是
// *
// *
// * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
// * 即根节点总是前序遍历中的第一个节点。而中序遍历的形式总是
// *
// *
// * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
// * 只要我们在中序遍历中定位到根节点，那么我们就可以分别知道左子树和右子树中的节点数目。由于同一颗子树的前序遍历和中序遍历的长度显然是相同的，因此我们就可以对应到前序遍历的结果中，对上述形式中的所有左右括号进行定位。
// *
// * 这样以来，我们就知道了左子树的前序遍历和中序遍历结果，以及右子树的前序遍历和中序遍历结果，我们就可以递归地对构造出左子树和右子树，再将这两颗子树接到根节点的左右位置。
// *
// * 细节
// *
// * 在中序遍历中对根节点进行定位时，一种简单的方法是直接扫描整个中序遍历的结果并找出根节点，但这样做的时间复杂度较高。我们可以考虑使用哈希表来帮助我们快速地定位根节点。对于哈希映射中的每个键值对，键表示一个元素（节点的值），值表示其在中序遍历中的出现位置。在构造二叉树的过程之前，我们可以对中序遍历的列表进行一遍扫描，就可以构造出这个哈希映射。在此后构造二叉树的过程中，我们就只需要 O(1)O(1) 的时间对根节点进行定位了。
// *
// * @create 2021-02-13-22:20
// */
//public class offer07 {
//    private HashMap<Integer, Integer> indexMap;
//
//
//    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
//        if (preorder_left > preorder_right) {
//            return null;
//        }
//
//        // 前序遍历中的第一个节点就是根节点，位置
//        int preorder_root = preorder_left;
//        // 在中序遍历中定位根节点，返回根节点的位置
//        int inorder_root = indexMap.get(preorder[preorder_root]);
//
//        // 先把根节点建立出来
//        TreeNode root = new TreeNode(preorder[preorder_root]);
//        // 得到左子树中的节点数目：根节点-0，中序遍历，根节点以前都是左子树
//        int size_left_subtree = inorder_root - inorder_left;
//        // 得到左子树的前序遍历结果和中序遍历结果，递归调用
//        // 前序遍历的左边界+1，右边界：左边界+左子树节点数； 中序遍历的左边界不变，右边界-1
//        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
//        //得到右子树的前序遍历结果和中序遍历结果
//        //前序遍历的左边界 左边界+左子树节点数+1，右边界不变； 中序遍历的左边界 根节点位置+1，右边界不变
//        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
//        return root;
//    }
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = preorder.length;
//        // 构造哈希映射，帮助我们快速定位根节点,k:节点的值，V:节点的坐标
//
//        for (int i = 0; i < n; i++) {
//            this.indexMap.put(inorder[i], i);
//        }
//        //指当前遍历方式的左边界，右边界
//        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
//    }
//}
//
////我的答案：
//class Solution {
//    //先定义一个indexMap类型变量，用于接收转为Map的中序遍历数组
//    private Map<Integer, Integer> indexMap;
//    public TreeNode reBuildTree(int[] preorder, int[] inorder, int leftpretree, int rightpretree, int leftintree, int rightintree){
//        if(leftpretree > rightpretree) {
//            return null;
//        }
//        int preorder_root = leftpretree;
//        int inorder_root = indexMap.get(preorder[preorder_root]);
//        TreeNode root = new TreeNode(preorder[preorder_root]);
//        int size_left_subtree = inorder_root - leftintree;
//
//        root.left = reBuildTree(preorder, inorder, leftpretree+1, leftpretree+size_left_subtree, leftintree, leftintree+size_left_subtree);
//        root.right = reBuildTree(preorder, inorder, leftpretree+1+size_left_subtree, rightpretree, inorder_root+1, rightintree);
//        return root;
//    }
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        int n = preorder.length;
//        //新建一个HashMap变量，存到indexMap中
//        indexMap = new HashMap<Integer,Integer>();
//        for (int i = 0; i < n; i++) {
//            indexMap.put(inorder[i], i);
//        }
//        return reBuildTree(preorder,inorder,0,n-1,0,n-1);
//    }
//
//}