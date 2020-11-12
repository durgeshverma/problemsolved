package org.durgesh.fbprep.leetcode;

import java.util.Arrays;

/**
 * Created by durgeshverma on 2/10/20.
 */
public class QuickSort {

    public static void sort(int[] a, int s, int e) {
        if (a == null || a.length == 0 || a.length == 1) {
            return;
        }
        if (s < e) {
            int mid = partition(a, s, e);
            sort(a, s, mid - 1);
            sort(a, mid + 1, e);
        }
    }

    public static int partition(int[] a, int s, int e) {
        int pivot = a[e];
        int i = s-1;

        for(int j = s; j<=e-1; j++) {
            if (a[j] < pivot) {
                i++;
                int x = a[i];
                a[i] = a[j];
                a[j] = x;
            }
        }
        //move pivot
        int x = a[i+1];
        a[i+1] = a[e];
        a[e] = x;

        return i+1;
    }

    public static void main(String[] args) {
        int[] head = new int[]{3,2,8,4,1,6,9};
        sort(head, 0, head.length-1);
        Arrays.stream(head).forEach(e -> System.out.print(e + " "));
    }

}
