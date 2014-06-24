package InterviewCode;

import java.util.HashSet;

public class LongestConsecutiveSequence
{
    public int longestConsecutive(int[] num)
    {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : num)
        {
            set.add(i);
        }
        int max = 1;
        for (int i = 0; i < num.length; i++)
        {
            int next = num[i] - 1;
            int count = 1;
            set.remove(num[i]);
            while (set.contains(next))
            {
                set.remove(next);
                count++;
                next--;
            }
            next = num[i] + 1;
            while (set.contains(next))
            {
                set.remove(next);
                count++;
                next++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
