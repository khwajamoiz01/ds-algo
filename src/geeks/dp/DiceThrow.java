/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.dp;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: DiceThrow.java, v 0.1 2020-01-27 12:29 khwaja.ali Exp 3
 */
public class DiceThrow {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int m = sc.nextInt();
                int n = sc.nextInt();
                int x = sc.nextInt();
                Map<Key, Long> dp = new HashMap<>();
                System.out.println(sumWays(new Key(n, x), m, dp));
            }
        }
    }

    static long sumWays(Key k, int m, Map<Key, Long> dp) {
        if (k.x == 0 && k.n == 0)
            return 1;
        if (k.n == 0 || k.x <= 0)
            return 0;

        if (!dp.containsKey(k)) {
            long w = 0;
            for (int i = 1; i <= m; i++) {
                w += sumWays(new Key(k.n - 1, k.x - i), m, dp);
            }
            dp.put(k, w);
        }
        return dp.get(k);
    }

    static class Key {
        int n, x;

        Key(int n, int x) {
            this.n = n;
            this.x = x;
        }

        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || o.getClass() != this.getClass())
                return false;
            Key key = (Key) o;
            return this.n == key.n && this.x == key.x;
        }

        public int hashCode() {
            return Objects.hash(n, x);
        }
    }

    void test() {
        Deque<String> deq;
    }
}