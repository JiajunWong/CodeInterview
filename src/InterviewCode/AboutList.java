package InterviewCode;

import java.util.HashMap;
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

    //2. reverse a list (iterative) -- not broke the original list
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

    //2. reverse a list (iterative) -- broke the orignal list
    public ListNode reverseListBr(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode cur = head;
        ListNode post = cur.next;
        while (post != null)
        {
            ListNode tem = post.next;
            post.next = cur;
            cur = post;
            post = tem;
        }
        return cur;
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
        if (head1 == null || head2 == null)
            return null;

        //get length 
        int len1 = 1;
        ListNode temp1 = head1;
        while (temp1.next != null)
        {
            temp1 = temp1.next;
            len1++;
        }
        int len2 = 1;
        ListNode temp2 = head2;
        while (temp2.next != null)
        {
            temp2 = temp2.next;
            len2++;
        }

        if (temp1 != temp2)
            return null;

        ListNode list1 = head1;
        ListNode list2 = head2;

        if (len1 > len2)
        {
            int offset = len1 - len2;
            while (offset > 0)
            {
                offset--;
                list1 = list1.next;
            }
        }
        else
        {
            int offset = len2 - len1;
            while (offset > 0)
            {
                offset--;
                list2 = list2.next;
            }
        }

        while (list1 != list2)
        {
            list1 = list1.next;
            list2 = list2.next;
        }

        return list1;
    }

    //10. find the first node in the cycle list (fast-slow pointer way)
    public ListNode findFristNodeInCycleList(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
            {
                break;
            }
        }

        if (fast == null || fast.next == null)
        {
            return null;
        }

        slow = head;
        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }

    //10. find the first node in the cycle list (hash map way)
    public ListNode findFirstNodeInCycleListHash(ListNode head)
    {
        HashMap<ListNode, Boolean> hashMap = new HashMap<ListNode, Boolean>();
        while (head != null)
        {
            if (hashMap.get(head) == true)
            {
                return head;
            }
            else
            {
                hashMap.put(head, true);
                head = head.next;
            }
        }

        return null;
    }

    //11. delete a node in O(n)
    public void deleteListNode(ListNode head, ListNode delete)
    {
        if (delete == null)
            return;
        if (delete.next != null)
        {
            delete.val = delete.next.val;
            delete.next = delete.next.next;
        }
        else
        {
            if (head == delete)
                head = null;
            else
            {
                ListNode tem = head;
                while (tem.next != delete)
                {
                    tem = tem.next;
                }
                tem.next = null;
            }
        }

    }
}
