package interviewQuestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePartitioning
{
    public List<List<String>> partition(String s)
    {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0)
        {
            return result;
        }
        ArrayList<String> array = new ArrayList<String>();
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        dfs(s, 0, map, result, array);
        return result;
    }

    private void dfs(String s, int index, HashMap<String, Boolean> map, ArrayList<List<String>> result, ArrayList<String> array)
    {
        if (index == s.length())
        {
            result.add(new ArrayList<String>(array));
            return;
        }
        for (int i = index; i < s.length(); i++)
        {
            boolean isPalindrome = false;
            String subString = s.substring(index, i + 1);
            if (map.get(subString) != null)
            {
                isPalindrome = map.get(subString);
            }
            else
            {
                isPalindrome = checkIsPalindrome(subString);
                map.put(subString, isPalindrome);
            }
            if (isPalindrome)
            {
                array.add(subString);
                dfs(s, i + 1, map, result, array);
                array.remove(array.size() - 1);
            }
        }
    }

    private boolean checkIsPalindrome(String s)
    {
        if (s.length() == 0)
        {
            return true;
        }
        for (int i = 0; i < s.length() / 2; i++)
        {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
            {
                return false;
            }
        }
        return true;
    }
}
