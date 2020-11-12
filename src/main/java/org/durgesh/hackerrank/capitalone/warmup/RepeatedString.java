package org.durgesh.hackerrank.capitalone.warmup;

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
public class RepeatedString {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long result = 0;
        long nFull = n / s.length();
        long nPartial = n % s.length();
        long repInInput = s.chars().filter(i -> i == 'a').count();
        if (nPartial > 0) {
            result = s.substring(0, Long.valueOf(nPartial).intValue()).chars().filter(i -> i == 'a').count();
        }
        return result + (repInInput * nFull);
    }

//    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = scanner.nextLine();
//
//        long n = scanner.nextLong();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString("aba", 10);
        System.out.println("number of a repeatation = " + result);

        result = repeatedString("a", 1000000000000L);
        System.out.println("number of a repeatation = " + result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}
