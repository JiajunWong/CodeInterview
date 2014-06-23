package InterviewCode;

import Util.ListNode;
import Util.TreeNode;

public class ConvertSortedListToBinarySearchTree
{
    public TreeNode sortedListToBST(ListNode head)
    {
        return rec(head, null);
    }

    private TreeNode rec(ListNode head, ListNode end)
    {
        if (head == end)
        {
            return null;
        }
        ListNode mid = head;
        ListNode fast = head;
        while (fast != end && fast.next != end)
        {
            mid = mid.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(mid.val);
        root.left = rec(head, mid);
        root.right = rec(mid.next, end);
        return root;
    }
}
