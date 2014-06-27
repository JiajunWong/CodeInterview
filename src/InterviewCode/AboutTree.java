package InterviewCode;

import java.util.ArrayList;
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
    //1. get node numbers(recursive) DFS
    public int getNodeNumRec(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }

    //1. get node numbers(iterative) BFS
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

    //5. post-order traversal(iterative)
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

    //6. level traversal(iterative)
    public void levelTraversal(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode cur = queue.remove();
            System.out.print(cur.val + " ");
            if (cur.left != null)
            {
                queue.add(cur.left);
            }
            if (cur.right != null)
            {
                queue.add(cur.right);
            }
        }
    }

    //6. level traversal(recursive)
    public void levelTraversalRec(TreeNode root)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        dfs(root, 0, result);
    }

    private void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> reuslt)
    {
        if (root == null)
        {
            return;
        }
        if (level > reuslt.size())
        {
            reuslt.add(new ArrayList<Integer>());
        }
        reuslt.get(level).add(root.val);
        dfs(root.left, level + 1, reuslt);
        dfs(root.right, level + 1, reuslt);
    }

    //7. get number of node of level k(recursive)
    public int getNumOfLevelKRec(TreeNode root, int k)
    {
        if (root == null || k <= 0)
        {
            return 0;
        }
        if (k == 1)
        {
            return 1;
        }
        return getNumOfLevelKRec(root.left, k - 1) + getNumOfLevelKRec(root.right, k - 1);
    }

    //7. get number of nodes of level k(iterative)
    public int getNumOfLevelK(TreeNode root, int k)
    {
        if (root == null)
        {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int i = 1;
        int currentNodeNum = 1;
        int nextNodeNum = 0;

        while (!queue.isEmpty() && i != k)
        {
            TreeNode node = queue.remove();
            currentNodeNum--;
            if (node.left != null)
            {
                nextNodeNum++;
                queue.add(node.left);
            }
            if (node.right != null)
            {
                nextNodeNum++;
                queue.add(node.right);
            }
            if (currentNodeNum == 0)
            {
                currentNodeNum = nextNodeNum;
                nextNodeNum = 0;
                i++;
            }
        }
        return currentNodeNum;
    }

    //8. get leaf node number(recursive)
    public int getLeafNumRec(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        if (root.left == null && root.right == null)
        {
            return 1;
        }
        return getLeafNumRec(root.left) + getLeafNumRec(root.right);
    }

    //8. get leaf node number(iterative)
    public int getLeafNum(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int numberLeaf = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode node = queue.poll();
            if (node.left != null)
            {
                queue.add(node.left);
            }
            if (node.right != null)
            {
                queue.add(node.right);
            }
            if (node.left == null && node.right == null)
            {
                numberLeaf++;
            }
        }
        return numberLeaf;
    }

    //9. detect whether two trees are the same(recursive)
    public boolean isSameRec(TreeNode root1, TreeNode root2)
    {
        if (root1 == null)
        {
            return root2 == null;
        }

        if (root2 == null)
        {
            return root1 == null;
        }

        if (root1.val != root2.val)
        {
            return false;
        }

        return isSameRec(root1.left, root2.left) && isSameRec(root1.right, root2.right);
    }

    //9. detect whether two trees are the same(iterative)
    public boolean isSame(TreeNode root1, TreeNode root2)
    {
        if (root1 == null)
        {
            return root2 == null;
        }
        if (root2 == null)
        {
            return root1 == null;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root1);
        stack2.push(root2);
        while (!stack1.isEmpty() && !stack2.isEmpty())
        {
            TreeNode node1 = stack1.pop();
            TreeNode node2 = stack2.pop();
            if (node1 == null && node2 == null)
            {
                return true;
            }
            else if (node1 != null && node2 != null && node1.val == node2.val)
            {
                //TODO: can stack push null?
                stack1.push(node1.left);
                stack1.push(node1.right);
                stack2.push(node2.left);
                stack2.push(node2.right);
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}
