package org.durgesh.fbprep.leetcode;

import java.util.Arrays;

/**
 * Created by durgeshverma on 2/9/20.
 */
public class AddTwoBinaryNumbers {
    public static int binaryToInt(String s) {
        int len = s.length();
        int val = 0;
        for (int i = 0; i<len; i++) {
            if (s.charAt(i) == '1') val += Math.pow(2, len-1-i);
        }
        return val;
    }
    public static void main (String[] args) {
        System.out.println(binaryToInt("1010") + binaryToInt("0010"));
    }
}
