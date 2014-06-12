package InterviewCode;

public class PlusOne
{
    public int[] plusOne(int[] digits)
    {
        int length = digits.length;
        if (digits == null || length == 0)
        {
            return digits;
        }
        int carry = 1;
        for (int i = length - 1; i >= 0; i--)
        {
            int num = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = num;
            if (carry == 0)
            {
                return digits;
            }
        }
        int[] res = new int[length + 1];
        res[0] = 1;
        return res;
    }
}
