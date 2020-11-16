package org.durgesh.hackerrank.capitalone.maps;

import org.durgesh.hackerrank.capitalone.Util;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.regex.*;
import java.util.stream.Collectors;

/**
 * Created by durgeshverma on 11/12/20.
 */
public class Anagrams {
    static int calcCombinations(String s) {
        int len = s.length();
        int count = 0;
        while (len > 1) {
            if (len == 2) {
                count += Util.nCr(len--, 1);
            } else {
                count += Util.nCr(len--, 2);
            }
        }
        return count;
    }

    static int sherlockAndAnagrams(String s1) {
        int count = 0;
        Map<String, Integer> repeatCharsMap = new HashMap<>();

        //collect substrings and their count of repetitions
        for(int i = 0; i < s1.length(); i++) {
            for (int j = i; j < s1.length(); j++) {

                char[] sub = s1.substring(i, j+1).toCharArray();
                Arrays.sort(sub);
                String subStr = new String(sub);

                if (repeatCharsMap.containsKey(subStr)) {
                    repeatCharsMap.put(subStr, repeatCharsMap.get(subStr)+1);
                } else {
                    repeatCharsMap.put(subStr, 1);
                }
            }
        }

        //there are (r*(r-1)/2) combinations of possible strings from r repetitions
        for (String s : repeatCharsMap.keySet()) {
            int repetition = repeatCharsMap.get(s);
            count += (repetition * (repetition - 1)) / 2;
        }

        return count;
    }

    // Complete the twoStrings function below.
    static int sherlockAndAnagramsX(String s1) {
        List<Character> uLetters = new ArrayList<>();
        Map<Character, Integer> repeatCharsMap = new HashMap<>();
        char[] s1Chars = s1.toCharArray();
        for (int i = 0; i < s1Chars.length; i++) {
            if (uLetters.contains(s1Chars[i])) {
                if (repeatCharsMap.containsKey(s1Chars[i])) {
                    repeatCharsMap.put(s1Chars[i], repeatCharsMap.get(s1Chars[i])+1);
                } else {
                    repeatCharsMap.put(s1Chars[i], 1);
                }
            } else {
                uLetters.add(s1Chars[i]);
            }
        }
        if (s1.length() == uLetters.size()) return 0;//unique letter, no anagram
        uLetters.clear();

        int count = repeatCharsMap.size();//min # with single letter anagrams
        System.out.println("with single letter anagrams=" + count);

        Iterator<Character> it = repeatCharsMap.keySet().iterator();
        while(it.hasNext()) {
            Character c = it.next();
            int st = s1.indexOf(c);
            int en = s1.lastIndexOf(c);
            if (en - st == 1) continue;//already counted
            String sub = s1.substring(st, en+1);
            System.out.println("sub="+sub);
            if (Util.allLettersSame(sub)) {
                count = calcCombinations(sub) - 1;
            } else {
                System.out.println("char " + c + " 1 more");
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        String s1 = "ifailuhkqq";
        int result = sherlockAndAnagrams(s1);
        System.out.println("result="+result);
    }
}