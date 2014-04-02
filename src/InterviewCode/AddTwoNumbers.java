package InterviewCode;

import Util.ListNode;

public class AddTwoNumbers
{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int addOne = 1;
        boolean shouldAddOne = false;
        ListNode temp = null;
        ListNode result = temp;
//
//        if (l1.next == null && l2.next == null)
//        {
//            int total = l1.val + l2.val;
//            if (total < 10)
//                result = new ListNode(l1.val + l2.val);
//            else
//            {
//                int val = total % 10;
//                result.val = val;
//                result.next = new ListNode(addOne);
//            }
//            return result;
//        }

        while (l1 != null && l2 != null)
        {
            if (shouldAddOne)
            {
                temp.val = temp.val + addOne;
                shouldAddOne = false;
            }

            int total = l1.val + l2.val + temp.val;
            int val = total % 10;
            temp.val = val;

            if (total >= 10)
            {
                shouldAddOne = true;
            }

            l1 = l1.next;
            l2 = l2.next;
            temp.next = new ListNode(0);
            temp = temp.next;
        }

        //one list is null now
        if (l1 == null && l2 != null)
        {
            while (l2 != null)
            {
                if (shouldAddOne)
                    temp.val = l2.val + addOne;
                else
                    temp.val = l2.val;
                l2 = l2.next;
                temp.next = new ListNode(0);
                temp = temp.next;
            }
        }
        else if (l2 == null && l1 != null)
        {
            while (l1 != null)
            {
                if (shouldAddOne)
                    temp.val = l1.val + addOne;
                else
                    temp.val = l1.val;
                l1 = l1.next;
                temp.next = new ListNode(0);
                temp = temp.next;
            }
        }
        else
        {
            if (shouldAddOne)
            {
                temp.val = temp.val + addOne;
                temp.next = new ListNode(0);
                temp = temp.next;
            }
        }
        temp = null;

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        ListNode node1 = new ListNode(0);
        ListNode node2 = new ListNode(0);

        ListNode result = addTwoNumbers(node1, node2);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

}
