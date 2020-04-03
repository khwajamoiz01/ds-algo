/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.array;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: Rearrange.java, v 0.1 2019-12-22 22:10 khwaja.ali Exp 3
 */
public class Rearrange {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                PriorityQueue<Element> pq = new PriorityQueue<>(new FreqComparison());
                int[] freq = new int[26];
                for (char ch : s.toCharArray()) {
                    freq[ch - 'a']++;
                }
                for (int i = 0; i < 26; i++) {
                    if (freq[i] > 0) {
                        pq.add(new Element((char) (i + 'a'), freq[i]));
                    }
                }
//                StringBuilder sb = new StringBuilder();
                Element prev = null;
                while (!pq.isEmpty()) {
                    Element e = pq.poll();
//                    System.out.println(e.ch + ": " + e.freq);
//                    sb.append(e.ch);
                    e.freq--;
                    if (prev != null && prev.freq > 0)
                        pq.offer(prev);
                    prev = e;
                }
                if (prev.freq > 0)
                    System.out.println(0);
                else
                    System.out.println(1);
            }
        }
    }

    static class FreqComparison implements Comparator<Element> {

        @Override
        public int compare(Element o1, Element o2) {
            return o2.freq - o1.freq;
        }
    }

    static class Element {
        char ch;
        int freq;

        Element(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}
/*
hjhjhjhjhj fff
 */