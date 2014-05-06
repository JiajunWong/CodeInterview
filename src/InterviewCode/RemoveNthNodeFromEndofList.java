package InterviewCode;

import Util.ListNode;

public class RemoveNthNodeFromEndofList
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++)
        {
            fast = fast.next;
            if (fast == null)
            {
                return head;//there is no element can be removed.
            }
        }

        if (fast == null)
        {
            head = head.next;
            return head;
        }

        while (fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
