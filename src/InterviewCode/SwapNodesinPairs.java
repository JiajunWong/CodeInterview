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

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
