package string.q6;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月21日 上午9:44:25          Administrator        2.1         To create
 * </p>
 * 2018年11月21日 上午9:44:25          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class Solution {
    /**
     * 设计的太棒了
     * @param str
     * @return
    	* @author tsj
    	* @Date 2018年12月10日上午11:28:00
     */
    public int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty())
            return 0;

        int i = 0;
        long sum = 0;
        int sign = 1;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            sum = sum * 10 + (str.charAt(i++) - '0');
            if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        return (int) (sum) * sign;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("18446744073709551617"));
    }
}
