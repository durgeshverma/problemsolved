package org.durgesh.hackerrank.capitalone.maps;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

/**
 * Created by durgeshverma on 11/12/20.
 */
public class TwoStrings {
    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        Set<Integer> s1Ints = s1.chars().boxed().collect(Collectors.toSet());
        Set<Integer> s2Ints = s2.chars().boxed().collect(Collectors.toSet());
        return s2Ints.stream().filter(i -> s1Ints.contains(i)).findFirst().isPresent()?"YES":"NO";
    }

    public static void main(String[] args) throws IOException {
        String s1 = "hello";
        String s2 = "world";
        String result = twoStrings(s1, s2);
        System.out.println("result="+result);

        s1 = "hi";
        s2 = "world";
        result = twoStrings(s1, s2);
        System.out.println("result="+result);
    }
}
