package com.note.common;

/**
 * @author wuyh-e
 * @date 2024/1/15
 */
public class ListNodeUtil {

    public static void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
    // 生成链表
    public static ListNode generateListNode(int[] arr) {
        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        for (int i = 0; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            p.next = node;
            p = p.next;
        }
        return dummyNode.next;
    }
}
