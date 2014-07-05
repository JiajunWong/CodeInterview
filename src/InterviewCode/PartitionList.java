package InterviewCode;

import Util.ListNode;

public class PartitionList
{
    public ListNode partition(ListNode head, int x)
    {
        if (head == null || head.next == null)
        {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode post = new ListNode(0);
        ListNode cur = head, tem1 = pre, tem2 = post;
        while (cur != null)
        {
            if (cur.val < x)
            {
                pre.next = new ListNode(cur.val);//!!!!!!!!!!only copy the val!!!!!!!!
                pre = pre.next;
            }
            else
            {
                post.next = new ListNode(cur.val);
                post = post.next;
            }
            cur = cur.next;
        }
        if (pre != null)
        {
            pre.next = tem2.next;
        }
        return tem1.next;
    }

}
