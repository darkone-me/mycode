package string.q3;

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
    public int firstUniqChar(String s) {
        int result = -1;
        for (char i = 'a'; i <= 'z'; i++) {
            int index = s.indexOf(i);
            if (index != -1 && index == s.lastIndexOf(i)) {
                result = result == -1 ? index : result > index ? index : result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstUniqChar("z"));
    }
}
