package InterviewCode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters
{
    public static int lengthOfLongestSubstring(String s)
    {
        if (s.length() == 0 || s.length() == 1)
        {
            return s.length();
        }

        HashMap<Character, Boolean> hashMap = new HashMap<Character, Boolean>();
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++)
        {
            for (int j = i; j < s.length() - 1; j++)
            {
                if (hashMap.containsKey(s.charAt(j)))
                {
                    if (hashMap.size() > result)
                    {
                        result = hashMap.size();
                    }
                    hashMap.clear();
                    break;
                }
                else
                {
                    hashMap.put(s.charAt(j), true);
                }
            }
        }
        return result;
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
