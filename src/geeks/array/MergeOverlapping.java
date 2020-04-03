/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.array;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: MergeOverlapping.java, v 0.1 2020-03-27 3:40 pm khwaja.ali Exp 3
 */
public class MergeOverlapping {
    static class Pair {
        int s, e;

        Pair(int ss, int ee) {
            s = ss;
            e = ee;
        }
    }

    static class StartComparator implements Comparator<Pair> {
        public int compare(Pair p1, Pair p2) {
            return p1.s - p2.s;
        }
    }

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                List<Pair> pairs = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    int s = sc.nextInt();
                    int e = sc.nextInt();
                    pairs.add(new Pair(s, e));
                }
                /*Collections.sort(pairs, new EndComparator()); wont work because
                    1, 3
                    2, 5
                    7, 9
                    1, 10
                * */
                Collections.sort(pairs, new StartComparator());

                List<Pair> res = new ArrayList<>();
                for (int i = 0; i < n; ) {
                    int j = i;
                    int maxE = pairs.get(j).e;
                    while (j + 1 < n && maxE >= pairs.get(j + 1).s) {
                        ++j;
                        maxE = Math.max(maxE, pairs.get(j).e);
                    }
                    res.add(new Pair(pairs.get(i).s, maxE));
                    i = j + 1;
                }
                for (Pair pair : res) {
                    System.out.print(pair.s + " " + pair.e + " ");
                }
                System.out.println();
            }
        }

    }
}