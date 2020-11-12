package org.durgesh.fbprep.leetcode;

/**
 * Created by durgeshverma on 2/9/20.
 */
public class MergeSortLinkedList {
    public static ListNode middleNode(ListNode l) {
        if (l == null) return l;
        ListNode singleMove = l;
        ListNode doubleMove = l;
        while (doubleMove.next != null && doubleMove.next.next != null) {
            singleMove = singleMove.next;
            doubleMove = doubleMove.next.next;
        }
        return singleMove;
    }
    public static ListNode sortedMerge(ListNode a, ListNode b) {
        ListNode result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }
    public static ListNode mergeSort(ListNode l) {
        if (l == null || l.next == null) return l;
        ListNode mid = middleNode(l);
        ListNode lright = mid.next;
        mid.next = null;
        ListNode lleft = l;
        return sortedMerge(mergeSort(lleft), mergeSort(lright));
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode head = l1;
        l1.next = new ListNode(2);
        l1 = l1.next;
        l1.next = new ListNode(8);
        l1 = l1.next;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(1);
        l1 = l1.next;
        l1.next = new ListNode(6);

        l1 = mergeSort(head);
        ListNode.print(l1);
    }
}
