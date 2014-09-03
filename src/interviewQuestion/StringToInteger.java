package interviewQuestion;

public class StringToInteger
{
    /*
     * 1.white space
     * 2.'+' or '-'
     * 3.calculate the number
     * 4.MAX_INT and MIN_INT
     * 5.null or empty string
     */
    public static int atoi(String str)
    {
        if (str == null || str.length() == 0)
            return 0;

        str = str.trim();
        char flag = '+';
        int i = 0;

        if (str.charAt(i) == '-')
        {
            flag = '-';
            i++;
        }
        else if (str.charAt(i) == '+')
            i++;

        double result = 0;
        while (i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0')
        {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
        {
            result = -result;
        }

        if (result > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }

        if (result < Integer.MIN_VALUE)
        {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        String s = "-b23afs3423f";
        int result = atoi(s);
        System.out.println(result);
    }

}
