package InterviewCode;

import java.util.Arrays;

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
        int max = 1;    //the result
        int start = 0;  //everytime the unique string start position
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
