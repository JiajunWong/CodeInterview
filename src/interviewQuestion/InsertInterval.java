package interviewQuestion;

import java.util.List;
import java.util.ListIterator;

import util.Interval;


public class InsertInterval
{
    public List<Interval> insert(List<Interval> intervals, Interval newInterval)
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
}
