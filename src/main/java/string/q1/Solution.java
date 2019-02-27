package string.q1;

/**
 * <p>
 * Description: Solution.java
 * Company:     中国移动通信集团设计院有限公司
 * Copyright:   CMDI. All Rights Reserved.
 * @author Administrator
 * @version 2.1

 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2018年11月5日 上午11:10:36          Administrator        2.1         To create
 * </p>
 * 2018年11月5日 上午11:10:36          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public class Solution {
    public String reverseString(String s) {
        char[] array = s.toCharArray();
        int n = array.length / 2;
        int z = array.length - 1;
        for (int i = 0; i < n; i++) {
            char tmp = array[i];
            array[i] = array[z - i];
            array[z - i] = tmp;
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseString("hello"));
    }
}
