package org.durgesh.fbprep.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by durgeshverma on 2/9/20.
 */
public class MergeTwoArrays {
    public static <T> Object[] concatenate(T[] a, T[] b) {
        // Function to merge two arrays of
        // same type
        return Stream.of(a, b)
                .flatMap(Stream::of)
                .sorted()
                .toArray();

        // Arrays::stream can also be used in place
        // of Stream::of in the flatMap() above.
    }

    public static void main (String[] args) {
        Integer[] a = new Integer[]{1,2,4};
        Integer[] b = new Integer[]{3,5,6};

        Object[] c = concatenate(a,b);

        System.out.println("Merged object array : "
                + Arrays.toString(c));
    }
}
