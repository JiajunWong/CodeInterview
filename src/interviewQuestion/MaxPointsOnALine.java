package interviewQuestion;

import java.util.HashMap;

import util.Point;

//http://rleetcode.blogspot.com/2014/01/max-points-on-linejava.html
public class MaxPointsOnALine
{
    public int maxPoints(Point[] points)
    {
        if (points == null || points.length == 0)
        {
            return 0;
        }

        HashMap<Double, Integer> map = new HashMap<Double, Integer>();;
        int max = 1;

        for (int i = 0; i < points.length; i++)
        {
            // shared point changed, map should be cleared and server the new point
            map.clear();

            // maybe all points contained in the list are same points,and same points' k is 
            // represented by Integer.MIN_VALUE
            map.put((double) Integer.MIN_VALUE, 1);

            int dup = 0;

            for (int j = i + 1; j < points.length; j++)
            {

                if (points[j].x == points[i].x && points[j].y == points[i].y)
                {
                    dup++;
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

            for (int temp : map.values())
            {

                // duplicate may exist
                if (temp + dup > max)
                {
                    max = temp + dup;
                }
            }

        }

        return max;
    }
}
