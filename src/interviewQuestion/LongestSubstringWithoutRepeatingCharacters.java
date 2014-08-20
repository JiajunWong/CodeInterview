package interviewQuestion;

import java.util.Arrays;
import java.util.HashMap;

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

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        String string = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
        int size = lengthOfLongestSubstring(string);
        System.out.println(size);
    }

}
