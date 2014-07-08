package InterviewCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import Util.TreeNode;

public class AboutBFS
{
    //Binary Tree Level Order Traversal 
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
        {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int curNodeNum = 1;
        int nextNodeNum = 0;

        ArrayList<Integer> array = new ArrayList<Integer>();
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            array.add(node.val);
            if (node.left != null)
            {
                queue.add(node.left);
                nextNodeNum++;
            }
            if (node.right != null)
            {
                queue.add(node.right);
                nextNodeNum++;
            }
            curNodeNum--;
            if (curNodeNum == 0)
            {
                result.add(new ArrayList<Integer>(array));
                array.clear();
                curNodeNum = nextNodeNum;
                nextNodeNum = 0;
            }
        }

        return result;
    }

    //Binary Tree Level Order Traversal II 
    public List<List<Integer>> levelOrderII(TreeNode root)
    {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null)
        {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Stack<List<Integer>> stack = new Stack<List<Integer>>();
        queue.add(root);
        int curNodeNum = 1;
        int nextNodeNum = 0;

        ArrayList<Integer> array = new ArrayList<Integer>();
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            array.add(node.val);
            if (node.left != null)
            {
                queue.add(node.left);
                nextNodeNum++;
            }
            if (node.right != null)
            {
                queue.add(node.right);
                nextNodeNum++;
            }
            curNodeNum--;
            if (curNodeNum == 0)
            {
                stack.push(new ArrayList<Integer>(array));
                array.clear();
                curNodeNum = nextNodeNum;
                nextNodeNum = 0;
            }
        }

        while (!stack.isEmpty())
        {
            result.add(stack.pop());
        }

        return result;
    }
}
