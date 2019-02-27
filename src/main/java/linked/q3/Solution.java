package linked.q3;

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

    public ListNode reverseList(ListNode head) {
        //递归
        /*if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        //找到尾节点
        ListNode h = reverseList(next);
        //反转 节点 1)5.next = 4; 2) 4.next = 3;
        next.next = head;
        //将当前的尾节点清空 1) 4.next = null; 2) 3.next = null;
        head.next = null;
        return h;*/

        //迭代
        ListNode first = head;
        ListNode h = null;
        while (first != null) {
            ListNode second = first.next;
            first.next = h;
            h = first;
            //迭代，旧值变新值 再做处理
            first = second;
        }
        return h;
    }

    public void diaoyong() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode hhh = reverseList(head);
        for (ListNode h = hhh; h != null;) {
            System.out.println(h.val);
            h = h.next;
        }
    }

    public static void main(String[] args) {
        new Solution().diaoyong();
    }
}
