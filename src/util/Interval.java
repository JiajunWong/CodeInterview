package util;

import java.util.ArrayList;
import java.util.Arrays;

public class Interval
{
    public int start;
    public int end;

    public Interval()
    {
        start = 0;
        end = 0;
    }

    public Interval(int start, int end)
    {
        this.start = start;
        this.end = end;

        if (end < start)
        {
            throw new IllegalArgumentException("end must larger than start");
        }
    }

    public static ArrayList<Interval> autoInit(int len)
    {
        ArrayList<Interval> result = new ArrayList<Interval>();
        int[] seeds = new int[len * 2 + 1];
        for (int i = 0; i <= len * 2; i++)
        {
            seeds[i] = (int) (Math.random() * 100 + 1);
        }
        Arrays.sort(seeds);
        for (int i = 0; i < seeds.length - 1; i++)
        {
            Interval cur = new Interval(seeds[i], seeds[i + 1]);
            result.add(cur);
            i++;
        }
        return result;
    }

    public static void printIntervals(ArrayList<Interval> intervals)
    {
        for (Interval interval : intervals)
        {
            System.out.print("[" + interval.start + " " + interval.end + "] ");
        }
    }

    public static void main(String[] args)
    {
        printIntervals(autoInit(10));
    }
}
