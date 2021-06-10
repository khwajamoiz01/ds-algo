/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: ActivitySelection.java, v 0.1 2020-03-28 1:12 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
public class ActivitySelection {

    static class Pair {
        int s, e;
        Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    static class EndComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.e - b.e;
        }
    }

    /*
     * 1. Start time sorting failure - [[1, 10], [2, 3], [4, 5]]
     * 2. Time of activity sorting failure - [[1, 10], [9, 12], [11, 25]]
     * 3. End time sorting doesnt fail because its not possible to have multiple non overlapping intervals, overlapping with a interval with minimum end time
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                Pair[] pairs = new Pair[n];
                int[] st = new int[n];
                int[] et = new int[n];
                for (int i = 0; i < n; i++) {
                    st[i] = sc.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    et[i] = sc.nextInt();
                }
                for (int i = 0; i < n; i++) {
                    pairs[i] = new Pair(st[i], et[i]);
                }
                Arrays.sort(pairs, new EndComparator());
                int count = 1;
                int pet = pairs[0].e;
                for (int i = 1; i < n; i++) {
                    if (pairs[i].s >= pet) {
                        count++;
                        pet = pairs[i].e;
                    }
                }
                System.out.println(count);
            }
        }
    }

}
