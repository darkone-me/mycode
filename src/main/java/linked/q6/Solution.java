package linked.q6;

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

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void diaoyong() {
        int[] array = new int[] { 10, 17, 8, 4, 26, 5, 35, 33, -7, -16, 27, -12, 6, 29, -12, 5, 9, 20, 14, 14, 2, 13, -24, 21, 23, -21, 5 };
        ListNode head = new ListNode(-21);
        for (int i = 0; i < array.length; i++) {
            head.next = new ListNode(array[i]);
            head = head.next;
        }
        boolean flag = hasCycle(head);
        System.out.println(flag);
        /*for (ListNode h = hhh; h != null;) {
            System.out.println(h.val);
            h = h.next;
        }*/
    }

    public static void main(String[] args) {
        new Solution().diaoyong();
    }
}
