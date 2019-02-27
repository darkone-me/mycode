package string.q9;

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

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        System.out.println(String.valueOf(strs));
        StringBuffer result = new StringBuffer();
        for (int i = 0;; i++) {
            String str = strs[0];
            if (str.length() == 0) {
                return "";
            }
            for (int j = 1; j < strs.length; j++) {
                String str2 = strs[j];
                if (str2.length() == 0) {
                    return "";
                }
                if (str.length() > i && str2.length() > i) {
                    if (str.charAt(i) != str2.charAt(i)) {
                        return result.toString();
                    }
                } else {
                    return result.toString();
                }
            }
            result.append(str.charAt(i));
        }
    }

    public static void main(String[] args) {

        String[] strs = new String[] { "flower", "flow", "flight" };
        System.out.println(new Solution().longestCommonPrefix(strs));
    }
}
