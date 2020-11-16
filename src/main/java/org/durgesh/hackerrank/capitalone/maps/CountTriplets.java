package org.durgesh.hackerrank.capitalone.maps;

import org.durgesh.hackerrank.capitalone.Util;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by durgeshverma on 11/15/20.
 */
public class CountTriplets {
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

    static long countTripletsPerformance(List<Long> arr, long r) throws Exception {
        Map<Long, Long> map = arr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
        System.out.println("******************");
        long count = 0;
        if (r == 1) {
            if (map.size() == 1) return nCr(arr.size(), 3);//all 1's
            for (long n : map.keySet()) {
                long combinations = nCr(map.getOrDefault(n, 0L), 3);;
                System.out.println("T["+n+"]="+combinations);
                count += combinations;
            }
        } else {
            for (long n : map.keySet()) {
                long first = n;
                long second = first * r;
                long third = first * r * r;
                String key = first + "," + second + "," + third;
                long combinations = map.getOrDefault(first, 0L) * map.getOrDefault(second, 0L) * map.getOrDefault(third, 0L);
                System.out.println("T["+key+"]="+combinations);
                count += combinations;
            }
        }
        return count;
    }

    static long countTripletsNoSort(List<Long> arr, long r) throws Exception {
        long stTime = System.currentTimeMillis();
        Map<Long, List<Long>> indexMap = new HashMap<>();
        long ix = 0;
        for (long n : arr) {
            List<Long> indexes = indexMap.get(n);
            if (indexes == null) {
                indexes = new ArrayList<>();
                indexMap.put(n, indexes);
            }
            indexes.add(ix++);
        }
        long count = 0;
        List<String> completed = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            long first = arr.get(i);
            long second = first * r;
            long third = first * r * r;
            String key = first+","+second+","+third;
            if (completed.contains(key)) continue;
            List<Long> secIndexes = indexMap.get(second);
            if (secIndexes != null) {
                for (long si : secIndexes) {
                    long cf = indexMap.getOrDefault(first, new ArrayList<>()).stream().filter(e -> e < si).count();
                    long ct = indexMap.getOrDefault(third, new ArrayList<>()).stream().filter(e -> e > si).count();
                    //System.out.println("si="+si+";cf="+cf+";ct="+ct);
                    count += (cf * ct);
                }
                completed.add(key);
            }
        }
        long enTime = System.currentTimeMillis();
        System.out.println("took " + (enTime-stTime) + " msecs");
        return count;
    }

    static long countTripletsNoSortPerformance(List<Long> arr, long r) throws Exception {
        long stTime = System.currentTimeMillis();
        Map<Long, Long> freqMap = new HashMap<>();
        for (long n : arr) {
            freqMap.put(n, freqMap.getOrDefault(n, 0L)+1);
        }
        long count = 0;
        Map<Long, Long> traversedMap = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            long first = arr.get(i)/r;
            long second = arr.get(i);
            long third = second * r;
            long ct=0, cf=0;
            freqMap.put(second, freqMap.getOrDefault(second, 0L)-1);//reduce freq of current
            if (traversedMap.containsKey(first) && second%r==0) {//get count of first from traversedMap
                cf = traversedMap.get(first);
            }
            if (freqMap.containsKey(third)) {//get count of third from freqMap
                ct = freqMap.get(third);
            }
            traversedMap.put(second, traversedMap.getOrDefault(second, 0L)+1);//increment freq of current
            count += (cf * ct);
        }
        long enTime = System.currentTimeMillis();
        System.out.println("took " + (enTime-stTime) + " msecs");
        return count;
    }

    static long countTripletsCopy(List<Long> arr, long r) throws Exception {
        long stTime = System.currentTimeMillis();
        Map<Long, Long> leftMap = new HashMap<>();
        Map<Long, Long> rightMap = new HashMap<>();
        for (long n : arr) {
            rightMap.put(n, rightMap.getOrDefault(n, 0L)+1);
        }
//        Map<String, String> mymap = new HashMap<>();
//        Map<String, Long> mymap2 = new HashMap<>();
        long count = 0;
        for (int i = 0; i < arr.size(); i++) {
            long mid = arr.get(i);
            long c1=0, c3=0;
            rightMap.put(mid, rightMap.getOrDefault(mid, 0L)-1);
            if (leftMap.containsKey(mid/r) && mid%r==0) {
                c1 = leftMap.get(mid/r);
            }
            if (rightMap.containsKey(mid*r)) {
                c3 = rightMap.get(mid*r);
            }
//            String key = "[" + (mid/r) + "," + mid + "," + (mid*r) + "]";
//            mymap.put(key, mymap.getOrDefault(key, "") + "("+c1+"*"+c3+")+");
//            mymap2.put(key, mymap2.getOrDefault(key, 0L) + (c1*c3));
            count += c1 * c3;
            leftMap.put(mid, leftMap.getOrDefault(mid, 0L)+1);
        }
        long enTime = System.currentTimeMillis();
        System.out.println("took " + (enTime-stTime) + " msecs");
//        for (String key : mymap2.keySet()) {
//            if (mymap2.get(key) != null && mymap2.get(key) > 0) {
//                System.out.println(key+"="+mymap2.get(key));
//            }
//        }
        return count;
    }

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) throws Exception {
//        System.out.println("enter...");
        if (r==1) return nCr(arr.size(), 3);
        arr = arr.stream().sorted().collect(Collectors.toList());
//        write2File(Util.convert2String(arr));
        long max = arr.get(arr.size()-1);
        long count = 0;
        List<String> tracking = new ArrayList<>();
        int i = 0;
        while (i < arr.size() - 2) {
            long first = arr.get(i);
            long second = first * r;
            long third = first * r * r;
            String key = first + "," + second + "," + third;
//            System.out.println("key -->("+key+")");
            if (second > max || third > max) {
//                if (second > max) System.out.println("got second " + second + " > " + max + "... break");
//                else System.out.println("got third " + third + " > " + max + "... break");
                break;
            }
            if (tracking.contains(key)) {
//                System.out.println("key [" + key + "] exists, skipping...");
                continue;//skip if already counted the triplets
            }
            else tracking.add(key);
            int[] t = new int[3];
            t[0] = 1;//counting first
            int nexti = -1;
            for (int j = i+1; j < arr.size(); j++) {
                if (arr.get(j) == first) t[0]+=1;
                if (nexti == -1 && arr.get(j) > first && arr.get(j) <= second) {
                    nexti = j;//first occurence
//                    System.out.println("recording nexti="+nexti + ";val@j="+arr.get(j)+";"+arr.get(j-1));
                }
                if (arr.get(j) == second) t[1]+=1;
                if (arr.get(j) == third) t[2]+=1;
                if (arr.get(j) > third) {
//                    System.out.println("got " + arr.get(j) + " > " + third + "... break");
                    break;
                }
            }
//            System.out.println("T["+key+"]="+t[0]+","+t[1]+","+t[2]);
            count += (t[0] * t[1] * t[2]);
            if (nexti != -1) {
//                System.out.println("nexti="+nexti);
                i = nexti;
            } else {
                i++;
            }
        }
        return count;
    }

    static long countTripletsBasic(List<Long> arr, long r) throws Exception {
        System.out.println("enter...");
        if (r==1) return nCr(arr.size(), 3);
        long count = 0;
        Map<String, List<String>> tracking = new HashMap<>();
        for (int i = 0; i < arr.size() - 2; i++) {
            long first = arr.get(i);
            long second = first * r;
            long max = first * r * r;
            String key = first + "," + second + "," + max;
            String value = String.valueOf(i);
            boolean got2 = false;
            boolean got3 = false;
            for (int j = i+1; j < arr.size(); j++) {
                if (!got2 && arr.get(j) == second) {
                    value += ","+j;
                    got2 = true;
                }
                if (!got3 && arr.get(j) == max) {
                    value += ","+j;
                    got3 = true;
                }
                if (got2 && got3) {
                    if (tracking.containsKey(key)) {
                        tracking.get(key).add(value);
                    } else {
                        List<String> lst = new ArrayList<>();
                        lst.add(value);
                        tracking.put(key, lst);
                    }
                    break;
                }
            }
        }
        for (String key : tracking.keySet()) {
            count += tracking.get(key).size();
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
//        long result = countTripletsPerformance(Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3);
//        System.out.println("result="+result);
//        System.out.println("=========================");
//        result = countTripletsPerformance(Arrays.asList(1L, 2L, 2L, 4L), 2);
//        System.out.println("result="+result);
//        System.out.println("=========================");
//        result = countTripletsPerformance(Arrays.asList(1L, 5L, 5L, 25L, 125L), 5);
//        System.out.println("result="+result);

        List<Long> iArr = readFile();
//        List<Long> iArr = Arrays.asList(1L, 2L, 1L, 2L, 4L);
//        long result = countTripletsPerformance(iArr, 2);//737,002,028
        long result = countTripletsNoSortPerformance(iArr, 3);
        System.out.println("$$$$$$$$$$$$$$$ result="+result);
        result = countTripletsCopy(iArr, 3);//2,325,652,489
        System.out.println("############### result="+result);

        //13621903916
        //2325652489 -- correct
        //3989045830

    }

    public static List<Long> readFile() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                new FileInputStream("/Users/durgeshverma/IdeaProjects/leetcode/input.txt")));
        List<Long> arr = Stream.of(bufferedReader.readLine().split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
        bufferedReader.close();
        return arr;
    }

    public static void write2File(String s) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/durgeshverma/IdeaProjects/leetcode/output.txt"));
        bufferedWriter.write(s);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}
