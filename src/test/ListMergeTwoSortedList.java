package test;

import util.ListNode;

public class ListMergeTwoSortedList
{
    public static ListNode mergeTwoList(ListNode head1, ListNode head2)
    {
        if (head1 == null)
            return head2;
        if (head2 == null)
            return head1;

        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (head1 != null && head2 != null)
        {
            if (head1.val > head2.val)
            {
                result.next = head2;
                head2 = head2.next;
            }
            else
            {
                result.next = head1;
                head1 = head1.next;
            }
            result = result.next;
        }
        if (head1 != null)
        {
            result.next = head1;
        }
        if (head2 != null)
        {
            result.next = head2;
        }
        return cur.next;
    }
    
    public static void main(String[] args)
    {
        ListNode head1 = ListNode.autoInit(1);
        ListNode head2 = ListNode.autoInit(0);
        ListNode.printList(mergeTwoList(head1, head2));
    }
}
