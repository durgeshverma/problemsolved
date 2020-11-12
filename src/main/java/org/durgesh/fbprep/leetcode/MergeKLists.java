package org.durgesh.fbprep.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by durgeshverma on 2/9/20.
 */
public class MergeKLists {
    public static void main(String[] args) {
        ListNode result = mergeKLists(new ListNode[]{
                ListNode.createListNode(new int[]{-8,-7,-7,-5,1,1,3,4}),
                ListNode.createListNode(new int[]{-2}),
                ListNode.createListNode(new int[]{-10,-10,-7,0,1,3}),
                ListNode.createListNode(new int[]{2})});
        ListNode.print(result);
    }

    public static ListNode[] filterEmptyNodes(ListNode[] lists) {
        List<ListNode> al = new ArrayList<>();
        for (ListNode node : lists) {
            if (node != null) al.add(node);
        }
        return al.toArray(new ListNode[al.size()]);
    }

    public static ListNode mergeKListsRecur(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode[] head = new ListNode[lists.length/2];
        int i = 0;
        int j = 0;
        while (i<lists.length-1) {
            if (i+1 < lists.length) head[j++] = MergeTwoLists.sortedMerge(lists[i], lists[i+1]);
            i += 2;
        }
        if (i+1 == lists.length) {
            ListNode[] head2 = new ListNode[head.length+1];
            System.arraycopy(head, 0, head2, 0, head.length);
            head2[head.length] = lists[lists.length-1];
            head = head2;
        }
        return mergeKListsRecur(head);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        lists = filterEmptyNodes(lists);
        return mergeKListsRecur(lists);
    }
}