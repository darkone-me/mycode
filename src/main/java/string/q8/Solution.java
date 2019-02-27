package string.q8;

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

    public String countAndSay(int n) {
        //没看懂这个题啥意思
        if (n == 1) {
            return "1";
        }
        //递归调用，然后对字符串处理
        String str = countAndSay(n - 1) + "*";//为了str末尾的标记，方便循环读数
        char[] c = str.toCharArray();
        int count = 1;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == c[i + 1]) {
                count++;//计数增加
            } else {
                //s.append(s);
                s.append("" + count + c[i]);//上面的*标记这里方便统一处理
                count = 1;//初始化
            }
        }
        return s.toString();
    }
}
