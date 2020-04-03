/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.dp;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: WordBreak.java, v 0.1 2020-04-01 3:28 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/word-break-problem-using-backtracking/
public class WordBreak {
    static class MyOb {
        int i;

        MyOb(int i) {
            this.i = i;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyOb myOb = (MyOb) o;
            return i == myOb.i;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i);
        }
    }

    public static void main(String[] args) {
        Set<MyOb> sett = new HashSet<>();

        MyOb ob1 = new MyOb(1);
        MyOb ob2 = new MyOb(2);

        sett.add(ob1);
        sett.add(ob2);

        ob1.i = 5;
        ob2.i = 5;
        System.out.println(sett);

        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                Set<String> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    set.add(sc.next());
                }
                String s = sc.next();
                process(s, set, 0, "");
                System.out.println();
            }
        }
    }

    static void process(String s, Set<String> set, int start, String res) {
        String str = "";
        for (int i = start; i < s.length(); i++) {
            str += s.charAt(i);
            if (set.contains(str)) {
                if (i == s.length()) {
                    System.out.print("(" + res + str + ")");
                } else {
                    process(s, set, i + 1, res + str + " ");
                }
            }
        }
    }
}