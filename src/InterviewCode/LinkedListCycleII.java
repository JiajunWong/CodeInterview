package InterviewCode;

import Util.ListNode;

public class LinkedListCycleII
{
    public ListNode detectCycle(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (true)
        {
            if (fast == null || fast.next == null)
            {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast)
            {
                break;
            }
        }
        slow = head;
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
