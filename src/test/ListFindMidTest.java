package test;

import util.ListNode;

public class ListFindMidTest
{
    public static ListNode findMidNode(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
        //        if (head == null || head.next == null) {  
        //            return head;  
        //        }  
        //  
        //        ListNode q = head;      // p---q   
        //        ListNode p = head;  
        //  
        //        while (q.next != null) {  
        //            q = q.next;  
        //            p = p.next;  
        //            if (q.next != null) {  
        //                q = q.next;  
        //            }  
        //        }  
        //        return p;  
    }

    public static void main(String[] args)
    {
        ListNode one = ListNode.autoInit(5);
        System.out.println(findMidNode(one).val);
    }
}
