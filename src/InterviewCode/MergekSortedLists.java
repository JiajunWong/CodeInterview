package InterviewCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import Util.ListNode;

public class MergekSortedLists
{
    public ListNode mergeKLists(ArrayList<ListNode> lists)
    {
        if (lists.size() == 0)
        {
            return null;
        }

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>()
        {
            @Override
            public int compare(ListNode o1, ListNode o2)
            {
                if (o1.val > o2.val)
                {
                    return 1;
                }
                else if (o1.val == o2.val)
                {
                    return 0;
                }
                else
                {
                    return -1;
                }
            }
        });

        for (ListNode listNode : lists)
        {
            if (listNode != null)
                priorityQueue.add(listNode);
        }

        ListNode head = new ListNode(0);
        ListNode pre = head;

        while (priorityQueue.size() > 0)
        {
            ListNode listNode = priorityQueue.poll();
            pre.next = listNode;
            if (listNode.next != null)
            {
                priorityQueue.add(listNode.next);
            }
            pre = pre.next;
        }

        return head.next;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
