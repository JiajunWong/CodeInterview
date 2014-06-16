package InterviewCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Util.TreeNode;

/**
 * @author jiajunwang
 * 1. get node numbers (recursive, iterative)
 * 2. 
 */
public class AboutTree
{
    //1. get node numbers(recursive)
    public int getNodeNumRec(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }

    //1. get node numbers(iterative)
    public int getNodeNum(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int count = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            TreeNode treeNode = queue.remove();
            if (treeNode.left != null)
            {
                queue.add(treeNode.left);
                count++;
            }
            if (treeNode.right != null)
            {
                queue.add(treeNode.right);
                count++;
            }
        }

        return count;
    }

    //2. get depth of the tree(recursive)
    public int getDepthRec(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    //2. get depth of the tree(iteratvie)
    public int getDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int count = 1;
        int curLevelNodes = 1;
        int nextLevelNodes = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode treeNode = queue.remove();
            curLevelNodes--;
            if (treeNode.left != null)
            {
                queue.add(treeNode.left);
                nextLevelNodes++;
            }
            if (treeNode.right != null)
            {
                queue.add(treeNode.right);
                nextLevelNodes++;
            }
            if (curLevelNodes == 0)
            {
                count++;
                curLevelNodes = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }
        return count;
    }

    //3. pre-order traversal(recursive)
    public void preorderTraversalRec(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        System.out.print(root.val + " ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }

    //3. pre-order traversal(iterative)
    public void preorderTraversal(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.val + " ");
            if (treeNode.right != null)
            {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null)
            {
                stack.push(treeNode.left);
            }
        }
    }

    //4. in-order traversal(recursive)
    public void inorderTraversalRec(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        inorderTraversalRec(root.left);
        System.out.print(root.val + " ");
        inorderTraversalRec(root.right);
    }

    //4. in-order traversal(iterative)
    public void inorderTraversal(TreeNode root)
    {
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while (true)
        {
            while (cur != null)
            {
                stack.push(cur);
                cur = cur.left;
            }
            if (stack.isEmpty())
            {
                break;
            }
            cur = stack.pop();
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    //5. post-order traversal(recursive)
    public void postorderTraversalRec(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }

    //5. post-order traversal(recursive)
    public void postorderTraversal(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode cur = stack.pop();
            output.push(cur);
            if (cur.left != null)
            {
                stack.push(cur.left);
            }
            if (cur.right != null)
            {
                stack.push(cur.right);
            }
        }
        while (!output.isEmpty())
        {
            System.out.print(output.pop().val + " ");
        }
    }
}
