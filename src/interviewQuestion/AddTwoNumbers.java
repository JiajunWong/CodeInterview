package interviewQuestion;

import util.ListNode;

/*
You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8 
*/
public class AddTwoNumbers
{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode tem = new ListNode(0);
        ListNode result = tem;
        int offset = 0;

        while (l1 != null || l2 != null)
        {
            if (l1 != null)
            {
                offset += l1.val;
                l1 = l1.next;
            }
            if (l2 != null)
            {
                offset += l2.val;
                l2 = l2.next;
            }

            tem.next = new ListNode(offset % 10);
            tem = tem.next;
            offset /= 10;
        }

        if (offset == 1)
        {
            tem.next = new ListNode(1);
        }

        return result.next;
    }
}
