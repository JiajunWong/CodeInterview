package test;

import util.ListNode;

public class ListFindKBackwardsTest
{
    public static ListNode findKBackwards(ListNode head, int k)
    {
        while (head == null || k == 0)
        {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++)
        {
            if (fast == null)
            {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private static int counter = 0;

    public static ListNode findKBackwardsRec(ListNode head, int k)
    {
        while (head == null || k == 0)
        {
            return null;
        }
        findKBackwardsRec(head.next, k);
        counter++;
        if (counter == k)
        {
            return head;
        }
        return null;
    }

    public static void main(String[] args)
    {
        ListNode one = ListNode.lazyInit();
        ListNode result = findKBackwardsRec(one, 6);
        if (result == null)
        {
            System.out.println("null");
        }
        else
        {
            System.out.println(result.val);
        }
    }
}
