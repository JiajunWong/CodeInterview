package Util;

public class ListNode
{
    public int val;
    public ListNode next;

    public ListNode(int val)
    {
        this.val = val;
        next = null;
    }

    public void print()
    {
        System.out.print(val + " ");
        while (next != null)
        {
            System.out.print(next.val + " ");
            next = next.next;
        }
    }
}
