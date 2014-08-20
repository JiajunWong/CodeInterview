package interviewQuestion;

import util.ListNode;

public class RotateList
{
    public static ListNode routateRight(ListNode head, int n)
    {
        if (head == null || n == 0)
            return head;
        ListNode p = head;
        int len = 1;//since p is already point to head
        while (p.next != null)
        {
            len++;
            p = p.next;
        }
        p.next = head; //form a loop
        n = n % len;
        for (int i = 0; i < len - n; i++)
        {
            p = p.next;
        } //now p points to the prev of the new head
        head = p.next;
        p.next = null;
        return head;
    }
}
