package linked.q2;

import linked.ListNode;

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode xian = head;
        ListNode hou = head;
        for (int i = 0; i < n; i++) {
            xian = xian.next;
        }
        //如果xian为null 则要移除的是头节点
        if (xian == null) {
            return head.next;
        }

        //双指针向后读取 当xian指针读到最后，后指针就是要被删除的指针
        while (xian.next != null) {
            hou = hou.next;
            xian = xian.next;
        }
        hou.next = hou.next.next;
        return head;
    }

}
