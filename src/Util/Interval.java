package Util;


public class Interval
{
    int start;
    int end;

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
}
