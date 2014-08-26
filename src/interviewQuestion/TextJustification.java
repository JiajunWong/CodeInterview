package interviewQuestion;

import java.util.ArrayList;

public class TextJustification
{
    public ArrayList<String> fullJustify(String[] words, int L)
    {
        ArrayList<String> ret = new ArrayList<String>();
        if (words == null || words.length == 0)
            return ret;

        int start = 0, end = pack(words, start, L);
        ret.add(convert(words, start, end, L));
        while (end != words.length - 1)
        {
            start = end + 1;
            end = pack(words, start, L);
            ret.add(convert(words, start, end, L));
        }
        return ret;
    }

    // pack a line and return the end of this line  
    private int pack(String[] words, int start, int L)
    {
        int next = start; // the index of the next word  
        int length = words[next].length();

        // always try to include the next word plus a padding space (greedy packing)  
        while (next + 1 < words.length && length + 1 + words[next + 1].length() <= L)
            length += words[++next].length() + 1;
        return next;
    }

    // convert multiple words along with extra padding space into a string of length L  
    private String convert(String[] words, int start, int end, int L)
    {
        StringBuilder sb = new StringBuilder();

        // if this line only contains one word  
        if (start == end)
        {
            sb.append(words[start]);
            for (int i = 0; i < L - words[start].length(); i++)
            {
                sb.append(" ");
            }
            return sb.toString();
        }
        // if the line is the last line, the space distribution rule is different  
        else if (end == words.length - 1)
        {
            int curLen = 0;
            for (int i = start; i < end; i++)
            {
                sb.append(words[i]);
                sb.append(" ");
                curLen += words[i].length() + 1;
            }
            sb.append(words[end]);
            curLen += words[end].length();

            for (int i = 0; i < L - curLen; i++)
            {
                sb.append(" ");
            }
            return sb.toString();
        }

        // calculate the lengths of padding space  
        int totalLen = 0, numOfSpaces = end - start;
        for (int i = start; i <= end; i++)
            totalLen += words[i].length();
        int lenOfPaddingSpace = (L - totalLen) / numOfSpaces;
        int numOfExtraSpaces = (L - totalLen) % numOfSpaces;

        // construct the line  
        int count = 0; // count of the extra spaces  
        for (int i = start; i < end; i++)
        {
            sb.append(words[i]);
            for (int j = 0; j < lenOfPaddingSpace; j++)
                sb.append(" ");
            if (count < numOfExtraSpaces)
                sb.append(" ");
            count++;
        }
        sb.append(words[end]);

        return sb.toString();
    }
}
