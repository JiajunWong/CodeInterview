package InterviewCode;

import Util.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        int preLen = preorder.length;
        int inLen = inorder.length;
        return dfs(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }

    private TreeNode dfs(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd)
    {
        if (preStart > preEnd)
        {
            return null;
        }

        int rootVal = preorder[preStart];
        int rootIndex = 0;

        for (int i = inStart; i <= inEnd; i++)
        {
            if (inorder[i] == rootVal)
            {
                rootIndex = i;
                break;
            }
        }

        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(preorder, preStart + 1, preStart + len, inorder, inStart, rootIndex - 1);
        root.right = dfs(preorder, preStart + len + 1, preEnd, inorder, rootIndex + 1, inEnd);

        return root;
    }
}
