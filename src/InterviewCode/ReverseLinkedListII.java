package InterviewCode;

import Util.ListNode;

public class ReverseLinkedListII
{
    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = null, post = null;
        for (int i = 1; i <= n; i++)
        {
            if (i < m)
            {
                pre = pre.next;
            }
            else if (i == m)
            {
                cur = pre.next;
                post = cur.next;
            }
            else
            {
                cur.next = post.next;
                post.next = pre.next;
                pre.next = post;
                post = cur.next;
            }
        }
        return dummy.next;
    }
}
