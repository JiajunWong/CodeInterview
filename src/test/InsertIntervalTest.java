package test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import util.Interval;

public class InsertIntervalTest
{
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval)
    {
        if (intervals == null || newInterval == null)
        {
            return intervals;
        }
        if (intervals.size() == 0)
        {
            intervals.add(newInterval);
            return intervals;
        }

        ListIterator<Interval> iterator = intervals.listIterator();
        while (iterator.hasNext())
        {
            Interval item = iterator.next();
            //before
            if (newInterval.end < item.start)
            {
                iterator.previous();
                iterator.add(newInterval);
                return intervals;
            }
            else
            {
                if (newInterval.start > item.end)
                {
                    continue;
                }
                else
                {
                    newInterval.start = Math.min(newInterval.start, item.start);
                    newInterval.end = Math.max(newInterval.end, item.end);
                    iterator.remove();
                }
            }
        }
        intervals.add(newInterval);
        return intervals;
    }

    public static void main(String[] args)
    {
        ArrayList<Interval> intervals = Interval.autoInit(10);
        Interval cur = new Interval(15, 55);
        Interval.printIntervals((ArrayList<Interval>) insert(intervals, cur));
    }
}
