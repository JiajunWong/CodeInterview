package interviewQuestion;

import java.util.Stack;
import java.util.StringTokenizer;

//http://codereview.stackexchange.com/questions/37364/reversing-words-in-a-string
public class ReverseWordsInAString
{
    public String reverseWords(String s)
    {
        StringTokenizer tokenizer = new StringTokenizer(s, " ");
        Stack<String> stack = new Stack<String>();
        StringBuilder stringBuilder = new StringBuilder();
        while (tokenizer.hasMoreElements())
        {
            String str = tokenizer.nextToken();
            if (!str.equals(""))
            {
                stack.push(str);
            }
        }
        while (!stack.isEmpty())
        {
            stringBuilder.append(stack.pop());
            if (!stack.isEmpty())
                stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
