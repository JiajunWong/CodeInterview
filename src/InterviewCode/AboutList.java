package InterviewCode;

import java.util.Stack;

import Util.ListNode;

/**
 * @author jwang
 *
 * 1. get list length
 * 2. reverse a list (iterative, recursive)
 * 3. find the kth element count backwards (iterative, recursive)
 * 4. find the middle element
 * 5. reversely print the list (iterative, recursive)
 * 6. merge two sorted lists (iterative, recursive)
 * 7. detect whether a list has cycle
 * 8. detect whether two lists intersect
 * 9. get first common node from two lists
 * 10. find the first node in the cycle list (two ways)
 * 11. delete a node in O(n)
 */
public class AboutList
{
    //1. get list length
    public int getLength(ListNode head)
    {
        if (head == null)
            return 0;

        ListNode cur = head;
        int counter = 0;
        while (cur != null)
        {
            counter++;
            cur = cur.next;
        }
        return counter;
    }

    //2. reverse a list (iterative)
    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode newHead = null;
        ListNode cur = head;
        while (cur != null)
        {
            ListNode preCur = cur;
            cur = cur.next;
            preCur.next = newHead;
            newHead = preCur;
        }

        return newHead;
    }

    //2. reverse a list (recursive)
    public ListNode reverseListRec(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //3. find the kth element count backwards (iterative)
    public ListNode findKBackwards(ListNode head, int k)
    {
        if (head == null || k == 0)
        {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (k > 1 && fast != null)
        {
            fast = fast.next;
            k--;
        }

        if (k > 1 || fast == null)
        {
            return null;
        }

        while (fast != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    private int counter = 0;

    //3. find the kth element count backwards (recursive)
    public ListNode findBackwardsRec(ListNode head, int k)
    {
        if (head == null && k == 0)
            return null;
        findBackwardsRec(head.next, k);
        counter++;
        if (counter == k)
        {
            return head;
        }

        return null;
    }

    //4. find the middle element
    public ListNode findMidNode(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null)
        {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null)
            {
                fast = fast.next;
            }
        }

        return slow;
    }

    //5. reversely print the list (iterative)
    public void printListReversely(ListNode head)
    {
        if (head == null)
            return;
        Stack<ListNode> stack = new Stack<ListNode>();
        while (head != null)
        {
            stack.push(head);
            head = head.next;
        }
        ListNode listNode = null;
        while (!stack.isEmpty())
        {
            listNode = stack.pop();
            System.out.println(listNode.val);
        }
    }

    //5. reversely print the list (recursive)
    public void printListReverselyRec(ListNode head)
    {
        if (head == null)
        {
            return;
        }
        printListReverselyRec(head.next);
        System.out.println(head.val);
    }

    //6. merge two sorted lists (iterative)
    public ListNode mergeTwoList(ListNode head1, ListNode head2)
    {
        if (head1 == null)
        {
            return head2;
        }
        if (head2 == null)
        {
            return head1;
        }
        ListNode result = null;
        if (head1.val > head2.val)
        {
            result = head2;
            head2 = head2.next;
        }
        else
        {
            result = head1;
            head1 = head1.next;
        }
        while (head1 != null && head2 != null)
        {
            if (head1.val > head2.val)
            {
                result.next = head2;
                head2 = head2.next;
                result = result.next;
            }
            else
            {
                result.next = head1;
                head1 = head1.next;
                result = result.next;
            }
        }

        if (head1 != null)
        {
            result.next = head1;
        }
        else if (head2 != null)
        {
            result.next = head2;
        }

        return result;
    }

    //6. merge two sorted lists (iterative)
    public ListNode mergeTwoListRec(ListNode head1, ListNode head2)
    {
        if (head1 == null)
        {
            return head2;
        }
        if (head2 == null)
        {
            return head1;
        }
        ListNode result = null;
        if (head1.val > head2.val)
        {
            result = head2;
            result.next = mergeTwoListRec(head1, head2.next);
        }
        else
        {
            result = head1;
            result.next = mergeTwoListRec(head1.next, head2);
        }
        return result;
    }

    //7. detect whether a list has cycle
    public boolean hasCycle(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    //8. detect whether two lists intersect
    public boolean hasIntersect(ListNode head1, ListNode head2)
    {
        if (head1 == null || head2 == null)
        {
            return false;
        }
        while (head1 != null)
            head1 = head1.next;
        while (head2 != null)
            head2 = head2.next;
        return head1 == head2;
    }

    //9. get first common node from two lists
    public ListNode getFirstCommonNode(ListNode head1, ListNode head2)
    {
        
    }
}
