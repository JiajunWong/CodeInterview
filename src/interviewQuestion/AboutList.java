package interviewQuestion;

import java.util.HashMap;
import java.util.Stack;

import util.ListNode;

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
    public static int getLength(ListNode head)
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
    public static ListNode reverseList(ListNode head)
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

    //Wrong!
    //2. reverse a list (iterative) -- broke the orignal list
    //    public static ListNode reverseListBr(ListNode head)
    //    {
    //        if (head == null || head.next == null)
    //        {
    //            return head;
    //        }
    //        ListNode cur = head;
    //        ListNode post = cur.next;
    //        while (post != null && post.next != null)
    //        {
    //            ListNode tem = post.next;
    //            post.next = cur;
    //            cur = post;
    //            post = tem;
    //        }
    //        return cur;
    //    }

    //2. reverse a list (recursive)
    public static ListNode reverseListRec(ListNode head)
    {
        if (head.next == null)
            return head;

        ListNode newHead = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    //3. find the kth element count backwards (iterative)
    public ListNode findKBackwards(ListNode head, int k)
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
        //This is right.
        if (head == null)
        {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

        //this is another wrong version:
        //        if (head == null || head.next == null)
        //        {
        //            return head;
        //        }
        //
        //        ListNode q = head;
        //        ListNode p = head;
        //
        //        while (q.next != null)
        //        {
        //            q = q.next;
        //            p = p.next;
        //            if (q.next != null)
        //            {
        //                q = q.next;
        //            }
        //        }
        //        return p;
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

    //12. sort list
    public ListNode sortList(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        slow = sortList(head);
        fast = sortList(fast);
        return merge(slow, fast);
    }

    private ListNode merge(ListNode slow, ListNode fast)
    {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (slow != null && fast != null)
        {
            if (slow.val <= fast.val)
            {
                cur.next = slow;
                slow = slow.next;
            }
            else
            {
                cur.next = fast;
                fast = fast.next;
            }
            cur = cur.next;
        }

        if (slow != null)
        {
            cur.next = slow;
        }
        if (fast != null)
        {
            cur.next = fast;
        }

        return head.next;
    }

    //insersion sort list
    public ListNode insertionSortList(ListNode head)
    {
        ListNode newHead = new ListNode(0);
        ListNode helper = newHead;
        ListNode cur = head;
        while (cur != null)
        {
            ListNode next = cur.next;
            helper = newHead;
            while (helper.next != null && helper.next.val < cur.val)
            {
                helper = helper.next;
            }
            cur.next = helper.next;
            helper.next = cur;
            cur = next;
        }
        return newHead.next;
    }

    //reorder list
    public void reorderList(ListNode head)
    {
        if (head == null || head.next == null || head.next.next == null)
        {
            return;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        //reverse the list
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode cur = head2, post = cur.next;
        cur.next = null;
        while (post != null)
        {
            ListNode tem = post.next;
            post.next = cur;
            cur = post;
            post = tem;
        }
        head2 = cur;
        //merge
        ListNode a = head1;
        ListNode b = head2;
        while (b != null)
        {
            ListNode tem1 = a.next;
            ListNode tem2 = b.next;
            a.next = b;
            b.next = tem1;
            a = tem1;
            b = tem2;
        }
    }

    //Reverse Linked List II 
    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = null, post = null;
        for (int i = 1; i <= n; i++)
        {
            if (i < m)
            {
                pre = pre.next;
            }
            else if (i == m)
            {
                cur = pre.next;
                post = cur.next;
            }
            else
            {
                cur.next = post.next;
                post.next = pre.next;
                pre.next = post;
                post = cur.next;
            }
        }
        return dummy.next;
    }

    //Partition List
    public ListNode partition(ListNode head, int x)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode post = new ListNode(0);
        ListNode cur = head, tem1 = pre, tem2 = post;
        while (cur != null)
        {
            if (cur.val < x)
            {
                pre.next = new ListNode(cur.val);
                pre = pre.next;
            }
            else
            {
                post.next = new ListNode(cur.val);
                post = post.next;
            }
            cur = cur.next;
        }
        if (pre != null)
        {
            pre.next = tem2.next;
        }
        return tem1.next;
    }

    //Remove Duplicates from Sorted List 
    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null)
        {
            if (cur.val == pre.val)
            {
                pre.next = cur.next;
                cur = cur.next;
            }
            else
            {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    //Remove Duplicates from Sorted List II
    public ListNode deleteDuplicatesII(ListNode head)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null)
        {
            ListNode post = cur.next;
            while (post.next != null && post.next.val == post.val)
            {
                post = post.next;
            }
            if (post != cur.next)
            {
                cur.next = post.next;
            }
            else
            {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    //Merge Two Sorted Lists
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
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
        return newHead.next;
    }

    //Rotate List 
    public ListNode rotateRight(ListNode head, int n)
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

    //Remove Nth Node From End of List
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++)
        {
            fast = fast.next;
        }

        if (fast == null)
        {
            head = head.next;
            return head;
        }

        while (fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
