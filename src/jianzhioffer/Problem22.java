package jianzhioffer;
import jianzhioffer.node.ListNode;

public class Problem22 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return null;
        ListNode fast = head;
        while (k > 0 && fast.next != null) {
            fast = fast.next;
            k--;
        }
        if(k>1){
            return null;
        }
        if(k==1){
            return head;
        }
        ListNode slow = head;
        while (fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}
