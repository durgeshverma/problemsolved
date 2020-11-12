package org.durgesh.fbprep.leetcode;

import java.util.Arrays;

/**
 * Created by durgeshverma on 2/9/20.
 */
public class MergeSortArray {
    public static int[] sortedMerge(int[] a, int[] b) {
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        int[] result = new int[a.length+b.length];
        int ai = 0;//1,3,5
        int bi = 0;//1,2,4,6,7
        int ri = 0;//1,1,2,3,4,5
        while(ai < a.length && bi < b.length) {
            if (a[ai] <= b[bi]) {
                result[ri] = a[ai];
                ai++;
            }
            else {
                result[ri] = b[bi];
                bi++;
            }
            ri++;
        }
        if (ai < a.length) {
            for (int i = ai; i < a.length; i++) {
                result[ri++] = a[i];
            }
        }
        if (bi < b.length) {
            for (int i = bi; i < b.length; i++) {
                result[ri++] = b[i];
            }
        }
        return result;
    }
    public static int[] mergeSort(int[] l) {
        if (l == null || l.length == 1) return l;
        int mid = l.length/2;

        int[] lleft = new int[mid];
        System.arraycopy(l, 0, lleft, 0, lleft.length);

        int[] lright = new int[l.length-mid];
        System.arraycopy(l, mid, lright, 0, lright.length);

        return sortedMerge(mergeSort(lleft), mergeSort(lright));
    }

    public static void main(String[] args) {
        int[] head = new int[]{3,2,8,4,1,6,9};

        head = mergeSort(head);
        Arrays.stream(head).forEach(e -> System.out.print(e + " "));
    }
}
