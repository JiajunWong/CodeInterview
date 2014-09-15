package interviewQuestion;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses
{
    public boolean isValid(String s)
    {
        char[] charArray = s.toCharArray();

        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');

        Stack<Character> stack = new Stack<Character>();
        for (char c : charArray)
        {
            if (hashMap.keySet().contains(c))
            {
                stack.push(c);
            }
            else if (hashMap.values().contains(c))
            {
                if (!stack.isEmpty() && hashMap.get(stack.peek()) == c)
                {
                    stack.pop();
                }
                else
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s)
    {
        //stack
        //(, [, { -> push
        //), ], } -> pop
        if (s == null || s.length() < 2)
        {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
            {
                stack.push(c);
            }
            else
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                char last = stack.pop();
                if (c == ')')
                {
                    if (last != '(')
                    {
                        return false;
                    }
                }
                else if (c == ']')
                {
                    if (last != '[')
                    {
                        return false;
                    }
                }
                else
                {
                    if (last != '{')
                    {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
