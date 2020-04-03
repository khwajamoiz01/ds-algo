/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.array;

import java.util.*;


/**
 * @author khwaja.ali
 * @version $Id: Difference.java, v 0.1 2020-03-29 1:52 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/count-pairs-difference-equal-k/
public class Difference {


    //Imp TC
    //[2, 1, 3], k = 1
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                int k = sc.nextInt();
                System.out.println(process(ar, n, k));
            }
        }
    }

    static int process(int[] ar, int n, int k) {
        Map<Integer, Integer> elems = new HashMap<>();
        for (int i = 0; i < n; i++) {
            elems.put(ar[i], elems.getOrDefault(ar[i], 0) + 1);
        }
        int count = 0;
        if (k == 0) {
            for (Map.Entry<Integer, Integer> entry : elems.entrySet()) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            }
            return count;
        }
        for (int i = 0; i < n; i++) {
            if (elems.getOrDefault(ar[i] - k, 0) > 0) {
                count++;
            }
            if (elems.getOrDefault(ar[i] + k, 0) > 0) {
                count++;
            }
            elems.put(ar[i], 0);
        }
        return count;
    }

    void test() {
    }

}