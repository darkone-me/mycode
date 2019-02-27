package string.q2;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月5日 上午11:25:00          Administrator        2.1         To create
 * </p>
 * 2018年11月5日 上午11:25:00          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class Solution {
    public int reverse(int x) {
        boolean flag = true;
        String str = String.valueOf(x);
        if (str.startsWith("-")) {
            str = str.replace("-", "");
        } else {
            flag = false;
        }
        char[] array = str.toCharArray();
        int n = array.length / 2;
        int z = array.length - 1;
        for (int i = 0; i < n; i++) {
            char tmp = array[i];
            array[i] = array[z - i];
            array[z - i] = tmp;
        }

        if (flag) {
            str = "-" + String.valueOf(array);
        } else {
            str = String.valueOf(array);
        }
        long result = Long.parseLong(str);
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
    }
}
