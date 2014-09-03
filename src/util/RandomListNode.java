package util;

public class RandomListNode
{
    public int label;
    public RandomListNode next, random;

    public RandomListNode(int val)
    {
        this.label = val;
        next = null;
        random = null;
    }

    public static RandomListNode autoInit(int len)
    {
        if (len < 0)
        {
            throw new IllegalArgumentException();
        }

        if (len == 0)
        {
            return null;
        }

        RandomListNode result = new RandomListNode(0);
        RandomListNode cur = result;
        int count = len;
        while (count > 0)
        {
            int v = (int) (Math.random() * 100 + 1);
            RandomListNode node = new RandomListNode(v);
            cur.next = node;
            cur = cur.next;
            count--;
        }

        cur = result.next;
        for (int i = 0; i < len; i++)
        {
            cur.random = randomPopupRandomNode(result.next, len);
            cur = cur.next;
        }
        return result.next;
    }

    public static void printList(RandomListNode head)
    {
        RandomListNode cur = head;
        while (cur != null)
        {
            System.out.print(cur.label + " -> ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        while (cur != null)
        {
            System.out.print(cur.random.label + " -> ");
            cur = cur.next;
        }
    }

    public static RandomListNode randomPopupRandomNode(RandomListNode head, int len)
    {
        int v = (int) (Math.random() * len);
        RandomListNode node = getNodeAtK(head, v);
        return node;
    }

    public static RandomListNode getNodeAtK(RandomListNode head, int k)
    {
        RandomListNode cur = head;
        while (k > 0)
        {
            cur = cur.next;
            k--;
        }
        return cur;
    }

    public static int getLength(RandomListNode head)
    {
        int count = 0;
        RandomListNode cur = head;
        while (cur != null)
        {
            count++;
            cur = cur.next;
        }
        return count;
    }
}
