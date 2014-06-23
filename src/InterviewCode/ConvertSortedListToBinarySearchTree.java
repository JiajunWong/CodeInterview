package InterviewCode;

import Util.ListNode;
import Util.TreeNode;

public class ConvertSortedListToBinarySearchTree
{
    public TreeNode sortedListToBST(ListNode head)
    {
        TreeNode root = new TreeNode(0);
        return dfs(root, head);
    }

    private TreeNode dfs(TreeNode root, ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        root.left = dfs(root.left, head.next);
        root.val = head.val;
        root.right = dfs(root.right, head.next);
        return root;
    }
}
