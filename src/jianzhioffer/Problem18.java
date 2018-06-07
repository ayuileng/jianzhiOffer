package jianzhioffer;

import jianzhioffer.node.ListNode;


public class Problem18 {
    //list is sorted already
    public ListNode deleteDuplication(ListNode pHead) {
        if(pHead == null) return null;
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode cur = pHead;
        ListNode pre = head;
        while(cur != null){
            if(cur.next == null){
                break;
            }else{
                if(cur.val !=  cur.next.val){
                    cur = cur.next;
                    pre = pre.next;
                    pre.next = cur;
                }else{
                    while (cur.next != null && cur.val ==  cur.next.val){
                        cur = cur.next;
                    }
                    cur = cur.next;
                    pre.next = cur;
                }
            }

        }
        return head.next;
    }


}
