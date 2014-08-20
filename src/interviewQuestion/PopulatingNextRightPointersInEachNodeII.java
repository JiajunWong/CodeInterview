package interviewQuestion;

import interviewQuestion.PopulatingNextRightPointersInEachNode.TreeLinkNode;

public class PopulatingNextRightPointersInEachNodeII
{
    public void connect(TreeLinkNode root)
    {
        if (root == null)
        {
            return;
        }
        TreeLinkNode rootNext = root.next;
        TreeLinkNode next = null;
        while (rootNext != null)
        {
            if (rootNext.left != null)
            {
                next = rootNext.left;
                break;
            }
            else if (rootNext.right != null)
            {
                next = rootNext.right;
                break;
            }
            else
            {
                rootNext = rootNext.next;
            }
        }
        if (root.left != null)
        {
            if (root.right != null)
            {
                root.left.next = root.right;
            }
            else
            {
                root.left.next = next;
            }
        }
        if (root.right != null)
        {
            root.right.next = next;
        }
        //!!!! right first!!!
        connect(root.right);
        connect(root.left);
    }
}
