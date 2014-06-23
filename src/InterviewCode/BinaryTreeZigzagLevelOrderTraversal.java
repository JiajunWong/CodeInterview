package InterviewCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Util.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
        {
            return result;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int num = 0;
        boolean reversed = false;
        while (!queue.isEmpty())
        {
            num = queue.size();
            arrayList.clear();
            for (int i = 0; i < num; i++)
            {
                TreeNode node = queue.remove();
                arrayList.add(node.val);
                if (node.left != null)
                {
                    queue.add(node.left);
                }
                if (node.right != null)
                {
                    queue.add(node.right);
                }
            }
            if (reversed)
            {
                Collections.reverse(arrayList);
                reversed = false;
            }
            else
            {
                reversed = true;
            }
            result.add(new ArrayList<Integer>(arrayList));
        }
        return result;
    }
}
