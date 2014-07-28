package InterviewCode;

import java.util.ArrayList;

public class PermutationsII
{
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        dfs(num, 0, result);
        return result;
    }

    private void dfs(int[] num, int start, ArrayList<ArrayList<Integer>> result)
    {
        if (start >= num.length)
        {
            ArrayList<Integer> item = convertArrayToList(num);
            result.add(item);
        }

        for (int i = start; i < num.length; i++)
        {
            if (!isContainsDuplicate(num, start, i))
            {
                swap(num, start, i);
                dfs(num, start + 1, result);
                swap(num, start, i);
            }
        }
    }

    private ArrayList<Integer> convertArrayToList(int[] num)
    {
        ArrayList<Integer> item = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++)
        {
            item.add(num[i]);
        }
        return item;
    }

    private boolean isContainsDuplicate(int arr[], int start, int end)
    {
        for (int i = start; i < end; i++)
        {
            if (arr[i] == arr[end])
            {
                return true;
            }
        }
        return false;
    }

    private void swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
