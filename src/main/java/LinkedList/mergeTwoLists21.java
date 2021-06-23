package LinkedList;


/**
 * @author 712
 * @function: 21. 合并两个有序链表
 * 创建新的ListNode p，另外创建赋值指针res，每次比较两个链表当前节点大小，取小的，并继续指向res.next(直接用p将找不到起始点)
 * @create 2021/5/30 11:31
 */
public class mergeTwoLists21 {
    private ListNode res;
    private ListNode p = new ListNode(-1);
    int count=0;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        res = p;
        //l1和l2都不为null，需要比较
        while(l1 != null && l2 !=null){
            if(l1.val<=l2.val){
                res.next = l1;
                l1 = l1.next;  //l1指向下一个数
            }else{
                res.next = l2;
                l2 = l2.next;
            }
            res=res.next;  //赋值指针
        }
        //只有一个不为null，直接赋值
        res.next=l1 == null ? l2:l1;
        return p.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
