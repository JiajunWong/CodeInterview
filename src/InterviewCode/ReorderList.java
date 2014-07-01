package InterviewCode;

import Util.ListNode;

public class ReorderList
{
    public void reorderList(ListNode head)
    {
        if (head == null || head.next == null || head.next.next == null)
        {
            return;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse the list
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode cur = head2, post = cur.next;
        cur.next = null;
        while (post != null)
        {
            ListNode tem = post.next;
            post.next = cur;
            cur = post;
            post = tem;
        }
        head2 = cur;
        //merge
        ListNode a = head1;
        ListNode b = head2;
        while (b != null)
        {
            ListNode tem1 = a.next;
            ListNode tem2 = b.next;
            a.next = b;
            b.next = tem1;
            a = tem1;
            b = tem2;
        }
    }
}
