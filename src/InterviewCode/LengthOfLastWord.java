package InterviewCode;

public class LengthOfLastWord
{
    public static int lengthOfLastWord(String s)
    {
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
        {
            if (s.charAt(0) == ' ')
                return 0;
            else
                return 1;
        }

        int index = s.length() - 1;
        int result = 0;

        while (index >= 0 && s.charAt(index) == ' ')
        {
            --index;
        }

        while (index >= 0 && s.charAt(index) != ' ')
        {
            ++result;
            --index;
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        String s = "a ";
        System.out.println(lengthOfLastWord(s));
    }

}
