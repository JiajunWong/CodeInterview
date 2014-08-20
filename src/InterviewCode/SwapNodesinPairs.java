package InterviewCode;

import Util.ListNode;

public class SwapNodesinPairs
{
    public ListNode swapPairs(ListNode head)
    {
        if (head == null || head.next == null)
            return null;

        ListNode first = head;
        ListNode second = head.next;
        ListNode third = second.next;

        second.next = first;
        first.next = swapPairs(third);
        return second;
    }

    public ListNode swapPairs2(ListNode head)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy, post = head;

        while (post != null && post.next != null)
        {
            ListNode temp = post.next.next;
            post.next.next = cur.next;
            cur.next = post.next;
            post.next = temp;
            cur = post;
            post = cur.next;
        }

        return dummy.next;
    }
}
