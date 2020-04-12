/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package codeforces;


import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: B1330.java, v 0.1 2020-04-07 10:21 pm khwaja.ali Exp 3
 */
//Solution is correct but can be done in O(n) also - https://codeforces.com/blog/entry/75559
public class B1330 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                TreeSet<Integer> left = new TreeSet<>();
                boolean[] l = new boolean[n];
                TreeSet<Integer> right = new TreeSet<>();
                boolean[] r = new boolean[n];

                for (int i = 0; i < n; i++) {
                    left.add(ar[i]);
                    if (left.size() == i + 1 && left.first() == 1 && left.last() == i + 1) {
                        l[i] = true;
                    }
                }
                for (int i = 0; i < n; i++) {
                    right.add(ar[n - i - 1]);
                    if (right.size() == i + 1 & right.first() == 1 && right.last() == i + 1) {
                        r[n - i - 1] = true;
                    }
                }
                List<String> res = new ArrayList<>();
                for (int i = 0; i < n - 1; i++) {
                    if (l[i] && r[i + 1]) {
                        res.add((i + 1) + " " + (n - i - 1));
                    }
                }
                System.out.println(res.size());
                for (String str : res) {
                    System.out.println(str);
                }
            }
        }
    }
}