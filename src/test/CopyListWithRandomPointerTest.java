package test;

import util.RandomListNode;

public class CopyListWithRandomPointerTest
{
    public static RandomListNode copyRandomList(RandomListNode head)
    {
        if (head == null)
        {
            return null;
        }

        if (head.next == null)
        {
            RandomListNode node = new RandomListNode(head.label);
            node.random = head.random;
            return node;
        }

        RandomListNode result = null;
        RandomListNode old = head;
        RandomListNode oldNext = null;
        RandomListNode pNew = result;

        do
        {
            oldNext = old.next;
            pNew = new RandomListNode(old.label);
            old.next = pNew;
            pNew.next = oldNext;

            if (result == null)
            {
                result = pNew;
            }
            old = oldNext;
        }
        while (old != null);
        old = head;
        while (old != null)
        {
            if (old.random != null)
            {
                old.next.random = old.random.next;
                old = old.next.next;
            }
        }
        old = head;
        pNew = result;
        while (pNew.next != null)
        {
            old.next = pNew.next;
            old = old.next;
            pNew.next = old.next;
            pNew = pNew.next;
        }
        return result;
    }

    public static void main(String[] args)
    {
        RandomListNode node = RandomListNode.autoInit(1);
        RandomListNode.printList(node);
        System.out.println();
        RandomListNode result = copyRandomList(node);
        RandomListNode.printList(result);
    }
}
