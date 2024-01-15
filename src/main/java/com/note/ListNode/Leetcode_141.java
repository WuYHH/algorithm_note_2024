package com.note.ListNode;

import com.note.common.ListNode;
import com.note.common.ListNodeUtil;

import java.util.List;

import static com.note.common.ListNodeUtil.generateListNode;

/**
 * @author wuyh-e
 * @date 2024/1/15
 */
public class Leetcode_141 {

    /**
     * 不创建虚拟节点
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode test2(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        // 确定新链表的头部
        ListNode head;
        if (head1.val < head2.val) {
            head = head1;
            head1 = head1.next;
        } else {
            head = head2;
            head2 = head2.next;
        }

        //
        ListNode p = head;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
//                p.next.next = null;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        // 将剩余部分连接到新链表
        if (head1 != null) {
            p.next = head1;
        }
        if (head2 != null) {
            p.next = head2;
        }

        return head;

    }

    public static ListNode test(ListNode head1, ListNode head2){
        if (head1 == null && head2 == null) {
            return null;
        }

        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode p = dummyNode;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
           if (p1.val > p2.val) {
               p.next = p2;
               p2 = p2.next;
           } else {
               p.next = p1;
               p1 = p1.next;
           }
           p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummyNode.next;

    }
    public static void main(String[] args) {
        ListNode head1 = generateListNode(new int[]{1, 3, 5, 6});
        ListNode head2 = generateListNode(new int[]{2, 4, 7, 8});
        ListNode test = test2(head1, head2);
        ListNodeUtil.print(test);
    }
}
