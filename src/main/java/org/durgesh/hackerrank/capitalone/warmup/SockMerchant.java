package org.durgesh.hackerrank.capitalone.warmup;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchantStream(int n, int[] ar) {
        return Arrays.stream(ar).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream().mapToInt(i -> i.intValue()/2).sum();
    }

    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(ar).forEach(i -> {
            if (map.get(i) == null) map.put(i, 1);
            else map.put(i, map.get(i)+1);
        });
        return map.values().stream().mapToInt(i -> i/2).sum();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
        int[] ar = new int[] {10,20,10,30,20,10};
//
//        String[] arItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arItem = Integer.parseInt(arItems[i]);
//            ar[i] = arItem;
//        }

        int result = sockMerchant(ar.length, ar);
        System.out.println("result=" + result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}