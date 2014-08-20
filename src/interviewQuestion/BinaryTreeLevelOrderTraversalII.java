package interviewQuestion;

import java.util.ArrayList;
import java.util.Stack;

import util.TreeNode;


public class BinaryTreeLevelOrderTraversalII
{
    public static ArrayList<ArrayList<Integer>> solution(TreeNode root)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null)
        {
            return result;
        }

        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();

        list.add(root);
        while (!list.isEmpty())
        {
            ArrayList<TreeNode> tpList = new ArrayList<TreeNode>();
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            while (!list.isEmpty())
            {
                TreeNode treeNode = list.remove(0);
                numbers.add(treeNode.val);
                if (treeNode.left != null)
                    tpList.add(treeNode.left);
                if (treeNode.right != null)
                    tpList.add(treeNode.right);
            }
            list = tpList;
            stack.push(numbers);
        }

        while (!stack.isEmpty())
        {
            result.add(stack.pop());
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
    }

}
