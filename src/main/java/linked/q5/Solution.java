package linked.q5;

import java.util.ArrayList;
import java.util.List;

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

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //快指针前进两个
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //将剩余节点反转
        ListNode first = slow;
        ListNode reset = null;
        while (first != null) {
            ListNode second = first.next;
            first.next = reset;
            reset = first;
            first = second;
        }
        //比较
        while (reset != null) {
            if (reset.val != head.val)
                return false;
            reset = reset.next;
            head = head.next;
        }
        return true;
    }

    public void diaoyong() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
        boolean flag = isPalindrome(head);
        System.out.println(flag);
        /*for (ListNode h = hhh; h != null;) {
            System.out.println(h.val);
            h = h.next;
        }*/
    }

    public static void main(String[] args) {
        Float[] a = new Float[4026];
        for (int i = 0; i < a.length; i++) {
            a[i] = 11111111f;
        }
        List<Float[]> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(a);
        }
        long t2 = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            Float[] b = list.get(i);
            //            Float[] c = list.get(++i);
            //
            //            calcSimilarity(b, c);
            for (int j = i + 1; j < list.size(); j++) {
                calcSimilarity(b, list.get(j));
                //                calcSimilarity(c, list.get(j));
            }
        }
        long t3 = System.currentTimeMillis();
        System.out.println("结果耗时" + (t3 - t2));
    }

    public static double calcSimilarity(Float[] sourceData, Float[] candidateData) {
        double similarity = 0;
        for (int i = 0; i < sourceData.length; i++) {
            similarity += Math.sqrt(sourceData[i] * candidateData[i]);
        }
        // The degree of similarity
        return similarity;
    }
}
