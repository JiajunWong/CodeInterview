package InterviewCode;

import Util.ListNode;

public class RotateList
{
    public static ListNode routateRight(ListNode head, int n)
    {
        if (head == null || head.next == null || n == 0)
        {
            return head;
        }

        ListNode tail = head;
        int length = 1;
        while (tail.next != null)
        {
            length++;
            tail = tail.next;
        }
        int offset = length - n % length;

        ListNode newTail = head;
        while (offset > 1)
        {
            newTail = newTail.next;
            offset--;
        }
        ListNode result = newTail.next;
        tail.next = head;
        newTail.next = null;

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
