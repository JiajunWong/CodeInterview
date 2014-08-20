package interviewQuestion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder
{
    public int ladderLength(String start, String end, Set<String> dict)
    {
        if (start.length() != end.length())
        {
            return 0;
        }
        if (dict.size() == 0)
        {
            return 0;
        }
        Queue<String> wordQueue = new LinkedList<String>();
        Queue<Integer> distanceQueue = new LinkedList<Integer>();
        wordQueue.add(start);
        distanceQueue.add(1);
        while (!wordQueue.isEmpty())
        {
            String curWord = wordQueue.poll();
            Integer curDistance = distanceQueue.poll();
            if (curWord.equals(end))
            {
                return curDistance;
            }
            for (int i = 0; i < curWord.length(); i++)
            {
                char[] chars = curWord.toCharArray();
                //watch out! here is char for a to z!!!
                for (char c = 'a'; c <= 'z'; c++)
                {
                    chars[i] = c;

                    String newWord = new String(chars);
                    if (dict.contains(newWord))
                    {
                        wordQueue.add(newWord);
                        distanceQueue.add(curDistance + 1);
                        dict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
