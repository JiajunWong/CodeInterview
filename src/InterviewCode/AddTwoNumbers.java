package InterviewCode;

import Util.ListNode;

public class AddTwoNumbers
{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode tem = new ListNode(0);
        ListNode result = tem;
        int offset = 0;

        while (l1 != null || l2 != null)
        {
            if (l1 != null)
            {
                offset += l1.val;
                l1 = l1.next;
            }
            if (l2 != null)
            {
                offset += l2.val;
                l2 = l2.next;
            }

            tem.next = new ListNode(offset % 10);
            tem = tem.next;
            offset /= 10;
        }
        
        if (offset == 1)
        {
            tem.next = new ListNode(1);
        }
        
        return result.next;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);

        ListNode result = addTwoNumbers(node1, node2);
        while (result != null)
        {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
