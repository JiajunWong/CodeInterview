package interviewQuestion;

import util.RandomListNode;

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
}
