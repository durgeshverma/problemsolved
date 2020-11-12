package org.durgesh.hackerrank.capitalone.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 * Created by durgeshverma on 11/11/20.
 */
public class ArrayLeftRotation {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int r = d % a.length;
        int[] reserve = new int[r];
        for (int i = 0; i < r; i++) {//backup that needs to shifted
            reserve[i] = a[i];
        }
        for (int i = r, j = 0; i < a.length; i++, j++) {//shift left
            a[j] = a[i];
        }
        for (int i = a.length-reserve.length, j = 0; i < a.length; i++, j++) {//append backup
            a[i] = reserve[j];
        }
        return a;
    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String[] nd = scanner.nextLine().split(" ");
//
//        int n = Integer.parseInt(nd[0]);
//
//        int d = Integer.parseInt(nd[1]);
//
//        int[] a = new int[n];
//
//        String[] aItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int aItem = Integer.parseInt(aItems[i]);
//            a[i] = aItem;
//        }

        int[] result = rotLeft(new int[] {1,2,3,4,5}, 2);
        Util.printArray(result);
//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write(" ");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
