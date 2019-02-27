package linked.q4;

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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    public void diaoyong() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        ListNode hhh = mergeTwoLists(head, head2);
        for (ListNode h = hhh; h != null;) {
            System.out.println(h.val);
            h = h.next;
        }
    }

    public static void main(String[] args) {
        new Solution().diaoyong();
    }
}
