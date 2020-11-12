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
public class HourGlassesSum {

    static int sum2DArray(int[][] arr, int r, int c) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (int i = r; i < r+3; i++) {
            if (i != r+1) {
                for (int j = c; j < c+3; j++) {
                    sum += arr[i][j];
                    sb.append(arr[i][j]).append(" ");
                }
            } else {
                sum += arr[i][c+1];
                sb.append("  ").append(arr[i][c+1]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println("sum of hourglass at row " + r + " and col " + c + " is - \t" + sum + "\n" + sb.toString());
        return sum;
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int r, c;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                int curr = sum2DArray(arr, i, j);
                if (curr > sum) {
                    r = i;
                    c = j;
                    sum = curr;
                }
            }
        }
        return sum;
    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[][] {
                {1, 1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 2, 4, 4, 0},
                {0, 0, 0, 2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };

//        for (int i = 0; i < 6; i++) {
//            String[] arrRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 6; j++) {
//                int arrItem = Integer.parseInt(arrRowItems[j]);
//                arr[i][j] = arrItem;
//            }
//        }

        int result = hourglassSum(arr);
        System.out.println("max sum = " + result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
