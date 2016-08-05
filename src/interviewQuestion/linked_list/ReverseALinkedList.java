package interviewQuestion.linked_list;

import util.ListNode;

/**
 * Created by Jiajun Wang on 7/17/16.
 */
public class ReverseALinkedList
{
    public static ListNode reverseALinkedList(ListNode head)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;

        while (cur.next != null)
        {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }
        System.out.println("cur: " + cur.val);
        return dummy.next;
    }

    public static void main(String[] params)
    {
        ListNode test = ListNode.autoInit(15);
        ListNode.printList(test);
        System.out.println();
        ListNode.printList(reverseALinkedList(test));
    }
}
