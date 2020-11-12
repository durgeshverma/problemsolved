package org.durgesh.fbprep.leetcode;

/**
 * Created by durgeshverma on 2/9/20.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static void print(ListNode l) {
        while (l != null) {//move to last node of l
            System.out.print(l.val + " ");
            l = l.next;
        }
    }

    public static ListNode createListNode(int[] a) {
        ListNode l1 = new ListNode(a[0]);
        ListNode head = l1;
        for (int i = 1; i < a.length; i++) {
            l1.next = new ListNode(a[i]);
            l1 = l1.next;
        }
        return head;
    }
}