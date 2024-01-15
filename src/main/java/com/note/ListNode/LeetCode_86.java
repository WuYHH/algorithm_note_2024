package com.note.ListNode;

import com.note.common.ListNode;

import java.util.List;

import static com.note.common.ListNodeUtil.generateListNode;
import static com.note.common.ListNodeUtil.print;

/**
 * @author wuyh-e
 * @date 2024/1/15
 */
public class LeetCode_86 {

    public static ListNode test(ListNode head, int x) {
        if (x < -200 || x > 200) {
            return null;
        }
        ListNode dummyNode1 = new ListNode(-1);
        ListNode dummyNode2 = new ListNode(-1);
        ListNode curr1 = dummyNode1;
        ListNode curr2 = dummyNode2;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                curr1.next = p;
                curr1 = curr1.next;
            } else {
                curr2.next = p;
                curr2 = curr2.next;
            }
            // 断链
            ListNode tmp = p.next;
            p.next = null;
            p = tmp;
        }
        curr1.next = dummyNode2.next;
        return dummyNode1.next;
    }

    public static void main(String[] args) {
        ListNode head = generateListNode(new int[]{1, 4, 3, 2, 5, 2});
        ListNode test = test(head, 3);
        print(test);
    }
}
