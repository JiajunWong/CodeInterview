package InterviewCode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses
{
    public List<String> restoreIpAddresses(String s)
    {
        ArrayList<String> result = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12)
        {
            return result;
        }
        dfs(s, "", result, 0);
        return result;
    }

    private void dfs(String s, String tmp, ArrayList<String> result, int count)
    {
        if (count == 3 && isValid(s))
        {
            result.add(tmp + s);
            return;
        }
        for (int i = 1; i < 4 && i < s.length(); i++)
        {
            String substr = s.substring(0, i);
            if (isValid(substr))
            {
                dfs(s.substring(i), tmp + substr + '.', result, count + 1);
            }
        }
    }

    public boolean isValid(String s)
    {
        if (s.charAt(0) == '0')
            return s.equals("0");
        int num = Integer.parseInt(s);
        return num <= 255 && num > 0;
    }
}
