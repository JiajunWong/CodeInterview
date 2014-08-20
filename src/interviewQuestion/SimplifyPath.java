package interviewQuestion;

import java.util.LinkedList;

public class SimplifyPath
{
    public String simplifyPath(String path)
    {
        if (path.length() == 0)
        {
            return path;
        }
        LinkedList<String> stack = new LinkedList<String>();
        String[] split = path.split("/");
        for (String s : split)
        {
            if (s.length() == 0 || s.equals("."))
            {
                continue;
            }
            else if (s.equals(".."))
            {
                if (!stack.isEmpty())
                {
                    stack.pop();
                }
            }
            else
            {
                stack.push(s);
            }
        }

        if (stack.isEmpty())
        {
            stack.push("");
        }
        String result = "";
        while (!stack.isEmpty())
        {
            result += "/" + stack.removeLast();
        }

        return result;
    }

    public static void main(String[] args)
    {
        String path = "";
        LinkedList<String> stack = new LinkedList<String>();
        stack.push(path);
        if (stack.isEmpty())
        {
            System.out.println("yes");
        }
        else
        {
            System.out.println("no");
        }
    }
}
