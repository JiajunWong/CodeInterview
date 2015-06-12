package interviewQuestion;

import java.util.LinkedList;
import java.util.List;

public class LengthOfLastWord
{
    public List<String> letterCombinations(String digits)
    {
        List<String> rec = new LinkedList<String>();
        if (digits == null || digits.length() == 0)
        {
            return rec;
        }
        String[] letters = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        StringBuilder string = new StringBuilder();
        letterCombinations(digits, 0, letters, string, rec);
        return rec;
    }

    private void letterCombinations(String digits, int number, String[] letters, StringBuilder string, List<String> rec)
    {
        if (digits.length() == number)
        {
            rec.add(string.toString());
            return;
        }
        String letter = letters[digits.charAt(number) - '2'];
        for (int i = 0; i < letter.length(); i++)
        {
            string.append(letter.charAt(i));
            letterCombinations(digits, number + 1, letters, string, rec);
            string.deleteCharAt(string.length() - 1);
        }
    }
}
