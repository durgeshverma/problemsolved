package org.durgesh.fbprep.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by durgeshverma on 2/9/20.
 */
public class MergeTwoLists {

    public static void fill(List<ListNode> lst, ListNode l) {
        while (l != null) {//move to last node of l
            lst.add(l);
            l = l.next;
        }
    }
    public static ListNode toListNode(List<ListNode> lst) {
        ListNode head = lst.get(0);
        ListNode l = head;
        for (int i=1; i<lst.size(); i++) {
            l.next = lst.get(i);
            l = l.next;
        }
        return head;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        List<ListNode> lst = new ArrayList();
        fill(lst, l1);
        fill(lst, l2);

        lst = lst.stream().sorted((o1, o2) -> o1.val==o2.val?0:(o1.val<o2.val?-1:1)).collect(Collectors.toList());

        return toListNode(lst);
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(8);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(1);

        //l1 = mergeTwoLists(l1, l2);
        l1 = sortedMerge(l1, l2);
        ListNode.print(l1);
    }
}
