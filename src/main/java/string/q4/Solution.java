package string.q4;

import java.util.Arrays;

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
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sArray = new int[26];
        int[] tArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i) - 97]++;
            tArray[t.charAt(i) - 97]++;
        }
        return Arrays.equals(sArray, tArray);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
    }
}
