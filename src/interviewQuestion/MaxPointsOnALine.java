package interviewQuestion;

import java.util.HashMap;

import util.Point;


//http://rleetcode.blogspot.com/2014/01/max-points-on-linejava.html
public class MaxPointsOnALine
{
    public int maxPoints(Point[] points)
    {
        if (points == null)
        {
            return 0;
        }
        if (points.length <= 2)
        {
            return points.length;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++)
        {
            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
            int same = 0;
            for (int j = i + 1; j < points.length; j++)
            {
                if (points[j].x == points[i].x && points[j].y == points[i].x)
                {
                    same++;
                    continue;
                }
                double key = points[j].x - points[i].x == 0 ? Integer.MAX_VALUE : 0.0 + (double) (points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
                if (map.containsKey(key))
                {
                    map.put(key, map.get(key) + 1);
                }
                else
                {
                    map.put(key, 2);
                }
            }
            if (map.size() > 0)
                for (int tem : map.values())
                {
                    if (tem + same > max)
                    {
                        max = tem + same;
                    }
                }
            else
            {
                return same;
            }
        }
        return max;
    }
}
