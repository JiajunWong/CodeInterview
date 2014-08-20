package interviewQuestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import util.Interval;


public class MergeIntervals
{
    public ArrayList<Interval> merge(ArrayList<Interval> intervals)
    {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Interval> result = new ArrayList<Interval>();

        if ((intervals == null) || (intervals.size() == 0))
            return result;

        Comparator<Interval> comparator = new Comparator<Interval>()
        {
            @Override
            public int compare(Interval i1, Interval i2)
            {
                if (i1.start < i2.start)
                {
                    return -1;
                }
                else if (i1.start > i2.start)
                {
                    return 1;
                }
                else
                {
                    if (i1.end < i2.end)
                    {
                        return -1;
                    }
                    else if (i1.end > i2.end)
                    {
                        return 1;
                    }
                    else
                    {
                        return 0;
                    }
                }
            }
        };

        Collections.sort(intervals, comparator);

        for (int i = 0; i < intervals.size(); i++)
        {
            Interval cur = intervals.get(i);
            if (result.isEmpty())
            {
                result.add(cur);
            }
            else
            {
                Interval last = result.get(result.size() - 1);
                if (last.end >= cur.start)
                {
                    last.end = Math.max(last.end, cur.end);
                }
                else
                {
                    result.add(cur);
                }
            }
        }
        return result;
    }
}
