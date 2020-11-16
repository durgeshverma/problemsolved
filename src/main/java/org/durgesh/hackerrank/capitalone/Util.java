package org.durgesh.hackerrank.capitalone;

import java.util.List;

/**
 * Created by durgeshverma on 11/11/20.
 */
public class Util {
    public static String convert2String(List<Long> result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(String.valueOf(result.get(i)));
            if (i != result.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static void printArray(int[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(String.valueOf(result[i]));
            if (i != result.length - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static long nCr(long n, long r) {
        long min = Math.min(r, n-r);
        long max = Math.max(r, n-r);
        long productMax1toN = product(max+1, n);
        long result = productMax1toN / fact(min);
        return result;
    }

    public static long product(long st, long en) {
        long res = 1;
        for (long i = st; i <= en; i++) {
            res = res * i;
        }
        return res;
    }

    // Returns factorial of n
    public static long fact(long n) {
        long res = 1;
        for (long i = 2; i <= n; i++) {
            res = res * i;
        }
        return res;
    }

    public static boolean allLettersSame(String s) {
        return s.chars().allMatch(c -> c == s.charAt(0));
    }
}
