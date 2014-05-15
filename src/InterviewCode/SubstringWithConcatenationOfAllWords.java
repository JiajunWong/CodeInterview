package InterviewCode;

import java.util.ArrayList;
import java.util.HashMap;

public class SubstringWithConcatenationOfAllWords
{
    public ArrayList<Integer> findSubstring(String S, String[] L)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (L.length == 0)
        {
            return result;
        }
        int wordLength = L[0].length();
        int totalLength = wordLength * L.length;

        if (S.length() < totalLength)
        {
            return result;
        }

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++)
        {
            if (hashMap.containsKey(L[i]))
            {
                hashMap.put(L[i], hashMap.get(L[i]) + 1);
            }
            else
            {
                hashMap.put(L[i], 1);
            }
        }

        for (int i = 0; i <= S.length() - totalLength; i++) // <=
        {
            String subString = S.substring(i, totalLength + i);
            @SuppressWarnings("unchecked")
            HashMap<String, Integer> map = (HashMap<String, Integer>) hashMap.clone();
            while (true)
            {
                String word = subString.substring(0, wordLength);
                if (map.containsKey(word))
                {
                    int num = map.get(word) - 1;
                    if (num < 0)
                    {
                        break;
                    }
                    map.put(word, num);
                    subString = subString.substring(wordLength);
                    if (subString.isEmpty())
                    {
                        result.add(i);
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
