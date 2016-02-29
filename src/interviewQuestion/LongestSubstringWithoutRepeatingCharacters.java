package interviewQuestion;

import java.util.*;

/*
Given a string, find the length of the longest substring without repeating characters.

For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*/
public class LongestSubstringWithoutRepeatingCharacters
{
    public static int lengthOfLongestSubstring(String s)
    {
        int length = s.length();
        if (length == 0)
        {
            return 0;
        }
        int[] countTable = new int[256];
        Arrays.fill(countTable, -1);
        int max = 1; //the result
        int start = 0; //everytime the unique string start position
        int end = 1;

        countTable[s.charAt(0)] = 0;
        while (end < length)
        {
            int elementInArray = countTable[s.charAt(end)];
            //Has not reached a duplicate char
            if (elementInArray >= start)
            {
                start = elementInArray + 1;
            }
            max = Math.max(max, end - start + 1);
            countTable[s.charAt(end)] = end;
            end++;
        }
        return max;
    }

    //http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/
    public static int lengthOfLongestSubstring2(String s)
    {
        if (s == null || s.length() == 0)
        {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int pre = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (!map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i), i);
            }
            else
            {
                pre = Math.max(pre, map.size());
                i = map.get(s.charAt(i));
                map.clear();
            }
        }
        return Math.max(pre, map.size());
    }

    public HashSet<String> longestPalindrome(String s)
    {
        HashSet<String> hashSet = new HashSet<String>();
        if (s == null || s.length() == 0)
            return hashSet;
        String result = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++)
        {
            String p1 = exp(s, i, i);
            String p2 = exp(s, i - 1, i);
            hashSet.add(p1);
            hashSet.add(p2);
        }
        return hashSet;
    }

    public String exp(String s, int l, int r)
    {
        while (l >= 0 && r < s.length())
        {
            if (s.charAt(l) == s.charAt(r))
            {
                l--;
                r++;
            }
            else
            {
                break;
            }
        }
        return s.substring(l + 1, r);
    }

    int sorted_search(int[] elements, int target)
    {
        if (elements == null || elements.length <= 0)
            return -1;

        for (int i : elements)
        {
            System.out.print(i);
        }

        System.out.println();

        int left = 0;
        int right = elements.length - 1;

        while (left < right)
        {
            int mid = (right - left) / 2 + left;
            if (elements[mid] > target)
            {
                right = mid - 1;
            }
            else if (elements[mid] < target)
            {
                left = mid + 1;
            }
            else
            {
                return mid;
            }
        }

        return -1;
    }

    static int check_log_history(String[] events)
    {
        final String ACQUIRE = "ACQUIRE";
        final String RELEASE = "RELEASE";

        Stack<String> stack = new Stack<>();
        ArrayList<String> arrays = new ArrayList();
        for (String s : events)
        {
            String[] tems = s.split(" ");
            if (tems[1].equals(ACQUIRE))
            {
                if (!stack.contains(tems[2]))
                {
                    stack.push(tems[2]);
                }
                else
                {
                    System.out.println((Integer.valueOf(tems[0]) + 1) + "(acquiring an already held lock.");
                    return Integer.valueOf(tems[0] + 1);
                }
            }
            else
            {
                if (stack.isEmpty() || !stack.contains(tems[2]))
                {
                    System.out.println((Integer.valueOf(tems[0]) + 1) + "(releasing a lock not acquired before");
                    return Integer.valueOf(tems[0] + 1);
                }
                String id = stack.pop();
                if (!id.equals(tems[0]))
                {
                    //TODO
                    System.out.println((Integer.valueOf(tems[0] + 1) + "()"));
                    return Integer.valueOf(tems[0] + 1);
                }
            }
        }

        if (!stack.isEmpty())
        {
            return events.length;
        }

        return 0;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
    }

}
