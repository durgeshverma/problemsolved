package org.durgesh.hackerrank.capitalone.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/**
 * Created by durgeshverma on 11/11/20.
 */
public class CountingValleys {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    public static int countingValleys(int steps, String path) {
        int valleyCount = 0;
        int mountainCount = 0;
        int v = 0;
        int m = 0;
        int level = 0;//at sea level
        char[] chars = path.toCharArray();
        for (int i = 0; i < steps; i++) {
            if (chars[i] == 'U') level++;
            else if (chars[i] == 'D') level--;
            if (chars[i] == 'D' && level == -1) {
                v++;//start count valley if below sea level
            }
            if (chars[i] == 'U' && level == 1) {
                m++;//start count mountain if above sea level
            }
            if (chars[i] == 'U' && level == 0) valleyCount = v;//end count valley when it returns to sea level
            if (chars[i] == 'D' && level == 0) mountainCount = m;//end count mountain when it returns to sea level
            System.out.println("step " + chars[i] + "; level=" + level + "; v=" + v + "; valleys=" + valleyCount + "; mountains=" + mountainCount);
        }
        return valleyCount;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int steps = Integer.parseInt(bufferedReader.readLine().trim());
//
//        String path = bufferedReader.readLine();

        int steps = 8;
        String path = "DDUUUUDD";
        int result = countingValleys(steps, path);
        System.out.println("number of valleys = " + result);

        path = "DDUUUUDD";
        result = countingValleys(steps, path);
        System.out.println("number of valleys = " + result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
