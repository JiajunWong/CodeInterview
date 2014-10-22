package interviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case. 
*/
public class Anagrams
{
    public List<String> anagrams(String[] strs)
    {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();

        if (strs.length == 0 || strs == null)
        {
            return result;
        }

        for (int i = 0; i < strs.length; i++)
        {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String tempString = String.valueOf(chars);
            if (hashMap.containsKey(tempString))
            {
                hashMap.get(tempString).add(strs[i]);
            }
            else
            {
                ArrayList<String> arrayList = new ArrayList<String>();
                arrayList.add(strs[i]);
                hashMap.put(tempString, arrayList);
            }
        }

        Iterator<ArrayList<String>> iterator = hashMap.values().iterator();
        while (iterator.hasNext())
        {
            ArrayList<String> list = iterator.next();
            if (list.size() > 1)
            {
                result.addAll(list);
            }
        }

        return result;
    }
}
