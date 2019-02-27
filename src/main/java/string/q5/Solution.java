package string.q5;

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
    public boolean isPalindrome(String s) {
        char[] array = s.toUpperCase().toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if ((array[start] > 'Z' || array[start] < 'A') && (array[start] < '0' || array[start] > '9')) {
                start++;
                continue;
            }
            if ((array[end] > 'Z' || array[end] < 'A') && (array[end] < '0' || array[end] > '9')) {
                end--;
                continue;
            }
            if (array[start] != array[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome("0P"));
    }
}
