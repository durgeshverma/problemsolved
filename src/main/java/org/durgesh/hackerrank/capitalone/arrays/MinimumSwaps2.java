package org.durgesh.hackerrank.capitalone.arrays;

import org.durgesh.hackerrank.capitalone.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by durgeshverma on 11/11/20.
 */
public class MinimumSwaps2 {
    static void swap(int[] q, int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }
    static int minimumSwaps(int[] q) {
        Util.printArray(q);
        int c = 0;
        for (int i = 0; i < q.length; i++) {
            int rightPos = i+1;
            if (q[i] != rightPos) {//if current element is not at rightPos
                for (int j = i; j < q.length; j++) {
                    if (q[j] == rightPos) {
                        swap(q, i, j);
                        c++;
                        break;
                    }
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[] q = new int[]{7, 1, 3, 2, 4, 5, 6};
        int ms = minimumSwaps(q);
        System.out.println("minimum swaps=" + ms);
        Util.printArray(q);
        q = new int[]{4, 3, 1, 2};
        ms = minimumSwaps(q);
        System.out.println("minimum swaps=" + ms);
        Util.printArray(q);
        q = new int[]{2, 3, 4, 1, 5};
        ms = minimumSwaps(q);
        System.out.println("minimum swaps=" + ms);
        Util.printArray(q);
        q = new int[]{1, 3, 5, 2, 4, 6, 7};
        ms = minimumSwaps(q);
        System.out.println("minimum swaps=" + ms);
        Util.printArray(q);
    }
}
