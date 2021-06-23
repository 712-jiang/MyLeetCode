package list;

import org.junit.jupiter.api.Test;

/**
 * @author 712
 * @function:
 * @create 2021/4/14 20:03
 */
public class getIntersectionNode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while(headA != null){
            while(headB != null){
                if(headA == headB) return headA;
                else headB = headB.next;
            }
            headA = headA.next;
        }
        return null;
    }
    @Test
    public void Test(){
        String num1 = "6913259244";
        String num2 = "71103343";
        int len1 = num1.length();
        int len2 = num2.length();
        int max = Math.max(len1,len2);
        long sum = 0;
        for(int i=0; i<max; i++){
            if(len1>0) {
                int a = num1.charAt(--len1) - '0';
                sum += a * Math.pow(10, i);
            }
            if(len2>0){
                int b = (int) num2.charAt(--len2) - '0';
                sum += b * Math.pow(10, i);
            }
        }
        System.out.println(sum);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
   }
}