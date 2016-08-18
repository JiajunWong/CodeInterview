package interviewQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import util.TreeNode;


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
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        queue.add(root);
        int num = 0;
        while (!queue.isEmpty())
        {
            num = queue.size();
            arrayList.clear();
            for (int i = 0; i < num; i++)
            {
                TreeNode treeNode = queue.remove();
                arrayList.add(treeNode.val);
                if (treeNode.left != null)
                {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null)
                {
                    queue.add(treeNode.right);
                }
            }
            result.add(new ArrayList<>(arrayList));
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

    //Surrounded Regions
    public void solve(char[][] board)
    {
        if (board.length == 0 || board[0].length == 0)
        {
            return;
        }
        Queue<Integer> rowQueue = new LinkedList<Integer>();
        Queue<Integer> colQueue = new LinkedList<Integer>();

        for (int row = 0; row < board.length; row++)
        {
            if (board[row][0] == 'O')
            {
                rowQueue.offer(row);
                colQueue.offer(0);
            }
            if (board[row][board[0].length - 1] == 'O')
            {
                rowQueue.offer(row);
                colQueue.offer(board[0].length - 1);
            }
        }

        for (int col = 1; col <= board[0].length - 2; col++)
        {
            if (board[0][col] == 'O')
            {
                rowQueue.offer(0);
                colQueue.offer(col);
            }
            if (board[board.length - 1][col] == 'O')
            {
                rowQueue.offer(board.length - 1);
                colQueue.offer(col);
            }
        }

        while (!rowQueue.isEmpty())
        {
            int row = rowQueue.poll();
            int col = colQueue.poll();
            board[row][col] = 'Y';

            if (row >= 1 && board[row - 1][col] == 'O')
            {
                rowQueue.offer(row - 1);
                colQueue.offer(col);
            }

            if (row <= board.length - 2 && board[row + 1][col] == 'O')
            {
                rowQueue.offer(row + 1);
                colQueue.offer(col);
            }

            if (col >= 1 && board[row][col - 1] == 'O')
            {
                rowQueue.offer(row);
                colQueue.offer(col - 1);
            }

            if (col <= board[0].length - 2 && board[row][col + 1] == 'O')
            {
                rowQueue.offer(row);
                colQueue.offer(col + 1);
            }
        }

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (board[i][j] == 'Y')
                {
                    board[i][j] = 'O';
                }
                else if (board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
            }
        }
    }

    //Word Ladder
    public int ladderLength(String start, String end, Set<String> dict)
    {
        if (start.length() != end.length() || dict.size() == 0)
        {
            return 0;
        }
        Queue<String> wordQueue = new LinkedList<String>();
        Queue<Integer> disQueue = new LinkedList<Integer>();
        wordQueue.offer(start);
        disQueue.offer(1);

        while (!wordQueue.isEmpty())
        {
            String s = wordQueue.poll();
            int dis = disQueue.poll();
            if (s.equals(end))
            {
                return dis;
            }
            for (int i = 0; i < s.length(); i++)
            {
                char[] chars = s.toCharArray();
                for (char j = 'a'; j <= 'z'; j++)
                {
                    chars[i] = j;

                    String newword = new String(chars);
                    if (dict.contains(newword))
                    {
                        wordQueue.offer(newword);
                        disQueue.offer(dis + 1);
                        dict.remove(newword);
                    }
                }
            }
        }
        return 0;
    }

    //Binary Tree Zigzag Level Order Traversal 
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
