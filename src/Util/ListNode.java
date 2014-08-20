package util;

public class ListNode
{
    public int val;
    public ListNode next;

    public ListNode(int val)
    {
        this.val = val;
        next = null;
    }

    public static ListNode lazyInit()
    {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        return one;
    }

    public static ListNode autoInit(int len)
    {
        if (len <= 0)
        {
            throw new IllegalArgumentException();
        }

        ListNode result = new ListNode(0);
        ListNode cur = result;
        for (int i = 0; i < len; i++)
        {
            ListNode node = new ListNode(i + 1);
            cur.next = node;
            cur = cur.next;
        }
        return result.next;
    }

    public static void printList(ListNode head)
    {
        while (head != null)
        {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }
}
