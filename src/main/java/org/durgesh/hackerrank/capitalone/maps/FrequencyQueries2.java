package org.durgesh.hackerrank.capitalone.maps;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * TODO: when withRevMap = false
 *      tc #11 is timing out (12 secs), but results match with expected output
 * TODO: when withRevMap = true
 *      tc #4,5,6,8,9,10,12 are failing (wrong answer)
 * Created by durgeshverma on 11/16/20.
 */
public class FrequencyQueries2 {

    private static Map<Integer, Integer> revMap = new HashMap<>();//key=freq, value=# of elements of this freq
    private static boolean withRevMap = false;

    static void updateRevMap(int oldFreq, int newFreq) {
        if (!withRevMap) return;
        if (oldFreq == 1) {
            revMap.remove(oldFreq);
        } else if (oldFreq > 1 && revMap.containsKey(oldFreq)) {
            revMap.replace(oldFreq, revMap.get(oldFreq)-1);
        }
        revMap.put(newFreq, revMap.getOrDefault(newFreq, 0)+1);
    }

    static void insert(int n, Map<Integer, Integer> freqMap) {
        int freq = freqMap.getOrDefault(n, 0);
        freqMap.put(n, freq+1);
        updateRevMap(freq, freq+1);
    }

    static void deleteOne(int n, Map<Integer, Integer> freqMap) {
        if (freqMap.containsKey(n)) {
            int freq = freqMap.get(n);
            if (freq == 1) {
                freqMap.remove(n);
            } else {
                freqMap.put(n, freq-1);
            }
            updateRevMap(freq, freq-1);
        }
    }

    static int identifyFreq(int z, Map<Integer, Integer> freqMap) {
        if (withRevMap) {
            return revMap.containsKey(z)?1:0;
        }
//        int match = freqMap.values().stream().filter(i -> i==z).findFirst().orElse(-1);
//        return match==-1?0:1;
        return find(z, freqMap)?1:0;
    }

    static boolean find(int z, Map<Integer, Integer> freqMap) {
        for (int val : freqMap.values()) {
            if (z == val) return true;
        }
        return false;
    }

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        if (withRevMap) revMap.clear();
        List<Integer> output = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (List<Integer> l : queries) {
            int op = l.get(0);
            int n = l.get(1);
            switch (op) {
                case 1:
                    insert(n, freqMap);
                    break;
                case 2:
                    deleteOne(n, freqMap);
                    break;
                case 3:
                    output.add(identifyFreq(n, freqMap));
                    break;
                default:
                    System.out.println("wrong operation " + op);
            }
        }
        return output;
    }

    public static void main(String[] args) throws Exception {
//        runSampleTCs();
        runFailedTC();
    }

    static void runFailedTC() throws Exception {
        try(final BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/durgeshverma/IdeaProjects/leetcode/src/main/resources/frequeries/11.txt"))) {

            int q = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> queries = new ArrayList<>();

            IntStream.range(0, q).forEach(i -> {
                try {
                    queries.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList())
                    );
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });

            long st = System.currentTimeMillis();
            List<Integer> ans = freqQuery(queries);
            System.out.println("took " + (System.currentTimeMillis() - st) + " msecs");
            write2File(ans);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void write2File(List<Integer> ans) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/durgeshverma/IdeaProjects/leetcode/src/main/resources/frequeries/ro11.txt"))) {
            bufferedWriter.write(
                    ans.stream()
                            .map(Object::toString)
                            .collect(Collectors.joining("\n"))
                            + "\n"
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void runSampleTCs() {
//        [0, 1]
//        [0, 1]
//        [0, 1, 1]
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1,5));
        queries.add(Arrays.asList(1,6));
        queries.add(Arrays.asList(3,2));
        queries.add(Arrays.asList(1,10));
        queries.add(Arrays.asList(1,10));
        queries.add(Arrays.asList(1,6));
        queries.add(Arrays.asList(2,5));
        queries.add(Arrays.asList(3,2));

        List<Integer> result = freqQuery(queries);
        System.out.println(result);

        queries.clear();
        queries.add(Arrays.asList(3,4));
        queries.add(Arrays.asList(2,1003));
        queries.add(Arrays.asList(1,16));
        queries.add(Arrays.asList(3,1));
        result = freqQuery(queries);
        System.out.println(result);

        queries.clear();
        queries.add(Arrays.asList(1,3));
        queries.add(Arrays.asList(2,3));
        queries.add(Arrays.asList(3,2));
        queries.add(Arrays.asList(1,4));
        queries.add(Arrays.asList(1,5));
        queries.add(Arrays.asList(1,5));
        queries.add(Arrays.asList(1,4));
        queries.add(Arrays.asList(3,2));
        queries.add(Arrays.asList(2,4));
        queries.add(Arrays.asList(3,2));
        result = freqQuery(queries);
        System.out.println(result);
    }
}
