package InterviewCode;

import Util.RandomListNode;

//http://www.cnblogs.com/TenosDoIt/p/3387000.html
//TODO: wrong answer;
public class CopyListWithRandomPointer
{
    public RandomListNode copyRandomList(RandomListNode head)
    {
        if (head == null)
        {
            return null;
        }
        RandomListNode result = null;
        RandomListNode pOld = head;
        RandomListNode oldNext = null;
        RandomListNode pNew = result;

        do
        {
            oldNext = pOld.next;
            pNew = new RandomListNode(head.label);
            pOld.next = pNew;
            pNew.next = oldNext;

            if (result == null)
            {
                result = pNew;
            }
            pOld = oldNext;
        }
        while (pOld != null);
        pOld = head;
        while (pOld != null)
        {
            if (pOld.random != null)
            {
                pOld.next.random = pOld.random.next;
                pOld = pOld.next.next;
            }
        }
        pOld = head;
        pNew = result;
        while (pNew.next != null)
        {
            pOld.next = pNew.next;
            pOld = pOld.next;
            pNew.next = pOld.next;
            pNew = pNew.next;
        }
        return result;
    }
}
