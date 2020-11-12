package org.durgesh.hackerrank.capitalone;

/**
 * Created by durgeshverma on 11/11/20.
 */
public class Util {
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
}
