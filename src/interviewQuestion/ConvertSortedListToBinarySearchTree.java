package interviewQuestion;

import util.ListNode;
import util.TreeNode;

public class ConvertSortedListToBinarySearchTree
{
    public TreeNode sortedListToBST(ListNode head)
    {
        return rec(head, null);
    }

    private TreeNode rec(ListNode start, ListNode end)
    {
        if (start == end)
        {
            return null;
        }
        ListNode slow = start;
        ListNode fast = start;
        while (fast != end && fast.next != end)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = rec(start, slow);
        root.right = rec(slow.next, end);
        return root;
    }
}
