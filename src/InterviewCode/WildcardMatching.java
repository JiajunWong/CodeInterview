package InterviewCode;

//http://offercoming.blogspot.com/2013/11/wildcard-matching.html
//http://blog.sina.com.cn/s/blog_b9285de20101gw2x.html
public class WildcardMatching
{
    public boolean isMatch(String s, String p)
    {
        int n = s.length();
        int m = p.length();

        int i = 0;
        int j = 0;
        int star = -1;
        int sp = 0;

        while (i < n)
        {
            //one * and multiple *, same effect
            while (j < m && p.charAt(j) == '*')
            {
                star = j++; //* match 0 character
                sp = i;
            }

            if (j == m || (p.charAt(j) != s.charAt(i) && p.charAt(j) != '?'))
            {
                if (star < 0)
                    return false;
                else
                {
                    j = star + 1;
                    i = ++sp; //* match 1 character
                }
            }
            else
            {
                i++;
                j++;
            }
        }

        while (j < m && p.charAt(j) == '*')
            j++;
        return j == m;
    }
}
