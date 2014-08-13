package InterviewCode;

public class CountAndSay
{
    public String countAndSay(int n)
    {
        if (n < 1)
            return "";
        String curRes = "1";
        for (int i = 2; i <= n; i++)
        {
            StringBuilder stringBuilder = new StringBuilder();
            int count = 1;
            for (int j = 1; j < curRes.length(); j++)
            {
                if (curRes.charAt(j) == curRes.charAt(j - 1))
                {
                    count++;
                }
                else
                {
                    stringBuilder.append(count);
                    stringBuilder.append(curRes.charAt(j - 1));
                    count = 1;
                }
            }
            stringBuilder.append(count);
            stringBuilder.append(curRes.charAt(curRes.length() - 1));
            curRes = stringBuilder.toString();
        }
        return curRes;
    }
}
