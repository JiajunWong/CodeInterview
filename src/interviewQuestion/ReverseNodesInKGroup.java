package interviewQuestion;

import util.ListNode;

public class ReverseNodesInKGroup
{

    public ListNode reverseKGroup(ListNode head, int k)
    {
        if (head == null || k == 1)
        {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        int i = 0;
        while (head != null)
        {
            i++;
            if (i % k == 0)
            {
                pre = reverseNode(pre, head.next);
                head = pre.next;
            }
            else
            {
                head = head.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverseNode(ListNode pre, ListNode next)
    {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next)
        {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
}
