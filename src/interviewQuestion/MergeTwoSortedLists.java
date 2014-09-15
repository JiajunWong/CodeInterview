package interviewQuestion;

import util.ListNode;

public class MergeTwoSortedLists
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode result = null;
        if (l1.val > l2.val)
        {
            result = l2;
            result.next = mergeTwoLists(l1, l2.next);
        }
        else
        {
            result = l1;
            result.next = mergeTwoLists(l1.next, l2);
        }

        return result;
    }

    public ListNode mergeTwoListsIter(ListNode l1, ListNode l2)
    {
        if (l1 == null)
        {
            return l2;
        }
        if (l2 == null)
        {
            return l1;
        }

        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while (l1 != null && l2 != null)
        {
            if (l1.val <= l2.val)
            {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else
            {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null)
        {
            cur.next = l1;
        }
        if (l2 != null)
        {
            cur.next = l2;
        }
        return newHead;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2)
    {
        if (l2 == null)
        {
            return l1;
        }
        if (l1 == null)
        {
            return l2;
        }
        ListNode result = new ListNode(0);
        ListNode cur = result;
        while (l1 != null && l2 != null)
        {
            if (l1.val < l2.val)
            {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else
            {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null)
        {
            cur.next = l1;
        }
        else if (l2 != null)
        {
            cur.next = l2;
        }
        return result.next;
    }
}
