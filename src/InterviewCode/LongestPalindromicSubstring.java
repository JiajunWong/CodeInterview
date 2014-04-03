package InterviewCode;

public class LongestPalindromicSubstring
{
    public static String longestPalindrome(String s)
    {
        int length = s.length();
        int maxLength = 1;
        int longestStartPosition = 0;
        boolean[][] table = new boolean[1000][1000];
        for (int row = 0; row < 1000; row++)
        {
            for (int col = 0; col < 1000; col++)
            {
                table[row][col] = false;
            }
        }

        for (int i = 0; i < length - 1; i++)
        {
            table[i][i] = true;
        }

        for (int i = 0; i < length - 2; i++)
        {
            if (s.charAt(i) == s.charAt(i + 1))
            {
                table[i][i + 1] = true;
                maxLength = 2;
                longestStartPosition = i;
            }
        }

        for (int len = 3; len <= length; len++)
        {
            for (int i = 0; i < length - len + 1; i++)
            {
                int j = len + i - 1;
                if (s.charAt(i) == s.charAt(j) && table[i + 1][j - 1])
                {
                    table[i][j] = true;
                    maxLength = len;
                    longestStartPosition = i;
                }
            }
        }

        System.out.println(longestStartPosition + " " + maxLength);
        
        return s.substring(longestStartPosition, longestStartPosition + maxLength);
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String result = longestPalindrome(s);
        System.out.println(result);
    }

}
