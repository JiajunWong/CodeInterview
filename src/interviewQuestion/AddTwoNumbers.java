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
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        int carrier = 0;
        while (l1 != null || l2 != null)
        {
            int sum = carrier;
            if (l1 != null)
            {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null)
            {
                sum += l2.val;
                l2 = l2.next;
            }

            carrier = sum / 10;
            ListNode node = new ListNode(sum % 10);
            dummy.next = node;
            dummy = dummy.next;
        }

        if (carrier != 0)
        {
            dummy.next = new ListNode(carrier);
            dummy = dummy.next;
        }

        return result.next;
    }
}
