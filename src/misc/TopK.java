/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package misc;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: TopK.java, v 0.1 2020-04-19 12:48 pm khwaja.ali Exp 3
 */
//https://leetcode.com/problems/top-k-frequent-elements/submissions/
public class TopK {
    public static void main(String[] args) {
        Object ob = new Object();
        int k = 2;
        int[] arr = {4, 1, -1, 2, -1, 2, 3};
        System.out.println(topKFrequent3(arr, k));
    }

    //3rd approach is more efficient but this is online algorithm

    public static List<Integer> topKFrequent4(int[] ar, int k) {
        Map<Integer, Integer> freq = new HashMap();
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return freq.get(o2) - freq.get(o1);
                    }
                });
        for (int i = 0; i < ar.length; i++) {
            freq.put(ar[i], freq.getOrDefault(ar[i], 0) + 1);
            pq.remove(ar[i]);
            pq.add(ar[i]);
        }

        List<Integer> res = new LinkedList();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            res.add(pq.poll());
        }
        return res;
    }

    //Advantages of this method
    //no need to create Key class having equals, hashcode and compareTo
    //freq is retrieved from the map
    //freq from the map is used in PQ comparison
    //but this algorithm isn't online
    //O(N) + O(n) + O(klog(n)
    public static List<Integer> topKFrequent3(int[] ar, int k) {
        Map<Integer, Integer> freq = new HashMap();
        //O(N)
        for (int n : ar) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return freq.get(o2) - freq.get(o1);
                    }
                });
        //O(n) where n is the num of unique elements
        for (int key : freq.keySet()) {
            pq.add(key);
        }

        //O(klog(n)
        List<Integer> res = new LinkedList();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            res.add(pq.poll());
        }
        return res;
    }

    public static List<Integer> topKFrequent2(int[] ar, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Key> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < ar.length; i++) {
            freq.put(ar[i], freq.getOrDefault(ar[i], 0) + 1);
            Key newKey = new Key(ar[i], freq.get(ar[i]));
            pq.remove(newKey);
            pq.add(newKey);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            res.add(pq.poll().data);
        }
        return res;
    }

    public static List<Integer> topKFrequent1(int[] ar, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        Integer[] top = new Integer[k + 1];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < ar.length; i++) {
            freq.put(ar[i], freq.getOrDefault(ar[i], 0) + 1);
            int j = find(top, ar[i]);
            top[k] = null;
            j = (j == -1) ? k - 1 : j - 1;
            while (j >= 0) {
                if (top[j] == null) {
                } else if (freq.get(top[j]) < freq.get(ar[i])) {
                    top[j + 1] = top[j];
                } else if (freq.get(top[j]) == freq.get(ar[i]) && top[j] > ar[i]) {
                    top[j + 1] = top[j];
                } else
                    break;
                j--;
            }
            top[j + 1] = ar[i];
        }
        for (int l = 0; l < k && top[l] != null; l++) {
            res.add(top[l]);
        }
        return res;
    }


    static class Key implements Comparable<Key> {
        int data;
        int freq;

        Key(int d, int f) {
            this.data = d;
            this.freq = f;
        }

        public boolean equals(Object ob) {
            if (this == ob)
                return true;
            if (ob == null || this.getClass() != ob.getClass())
                return false;
            return this.data == ((Key) ob).data;
        }

        public int hashCode() {
            return Objects.hash(this.data);
        }

        public int compareTo(Key ob) {
            if (this == ob)
                return 0;
            if (this.freq != ob.freq)
                return this.freq - ob.freq;
            return ob.data - this.data;
        }
    }


    static int find(Integer[] top, int e) {
        for (int i = 0; i < top.length; i++) {
            if (top[i] != null && top[i] == e)
                return i;
        }
        return -1;
    }


}