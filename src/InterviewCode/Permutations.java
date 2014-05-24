package InterviewCode;

import java.util.ArrayList;

public class Permutations
{
    public ArrayList<ArrayList<Integer>> permute(int[] num)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>()); // add a empty list

        for (int i = 0; i < num.length; i++)
        {
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> array : result)
            {
                for (int j = 0; j < array.size() + 1; j++)
                {
                    array.add(j, num[i]);

                    ArrayList<Integer> temp = new ArrayList<Integer>(array);
                    current.add(temp);
                    array.remove(j);
                }
            }
            result = new ArrayList<ArrayList<Integer>>(current);
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
