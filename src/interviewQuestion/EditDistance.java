package interviewQuestion;

public class EditDistance
{
    public int minDistance(String word1, String word2)
    {
        int[][] d = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word2.length(); i++)
        {
            d[0][i] = i;
        }
        for (int i = 0; i <= word1.length(); i++)
        {
            d[i][0] = i;
        }
        for (int i = 0; i < word1.length(); i++)
        {
            char a = word1.charAt(i);
            for (int j = 0; j < word2.length(); j++)
            {
                char b = word2.charAt(j);
                if (a == b)
                    d[i + 1][j + 1] = d[i][j];
                else
                {
                    int rep = d[i][j] + 1;
                    int del = d[i + 1][j] + 1;
                    int add = d[i][j + 1] + 1;

                    int min = rep > del ? del : rep;
                    min = min < add ? min : add;
                    d[i + 1][j + 1] = min;
                }
            }
        }
        return d[word1.length()][word2.length()];
    }
}
