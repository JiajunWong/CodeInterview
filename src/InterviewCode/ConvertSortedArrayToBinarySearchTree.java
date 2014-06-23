package InterviewCode;

import Util.TreeNode;

public class ConvertSortedArrayToBinarySearchTree
{
    public TreeNode sortedArrayToBST(int[] num)
    {
        return rec(num, 0, num.length - 1);
    }

    private TreeNode rec(int[] num, int start, int end)
    {
        if (start > end)
        {
            return null;
        }
        int mid = (end - start) / 2 + start;
        TreeNode root = new TreeNode(num[mid]);
        root.left = rec(num, start, mid - 1);
        root.right = rec(num, mid + 1, end);
        return root;
    }
}
