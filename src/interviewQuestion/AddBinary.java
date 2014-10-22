package interviewQuestion;

/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100". 
*/
public class AddBinary
{
    public static String addBinary(String a, String b)
    {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--)
        {
            int x = i < 0 ? 0 : a.charAt(i) - '0';
            int y = j < 0 ? 0 : b.charAt(j) - '0';
            int num = (x + y + carry) % 2;
            carry = (x + y + carry) / 2;
            result.insert(0, num);
        }
        if (carry > 0)
        {
            result.insert(0, '1');
        }
        return result.toString();
    }

    public static void main(String[] args)
    {
        String a = "0";
        String b = "0";
        System.out.println(addBinary(a, b));
    }
}
