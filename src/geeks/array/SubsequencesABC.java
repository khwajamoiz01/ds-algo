/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.array;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: SubsequencesABC.java, v 0.1 2019-12-25 17:08 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
public class SubsequencesABC {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                char[] ar = sc.next().toCharArray();
                if (ar.length < 3) {
                    System.out.println(0);
                    continue;
                }
                int a = 0;
                int ab = 0;
                int abc = 0;
                //a b c a b c
                //0 1 2 3 4 5
                //, , , aabc, ,  and
                /*
                0 a1
                1 a1, ab1
                2 a1, ab1, abc1
                3 a3, ab1, abc1
                4 a2, ab5, abc1
                5
                 */
                for (int i = 0; i < ar.length; i++) {
                    if (ar[i] == 'a') {
                        a = 2 * a + 1;
                    } else if (ar[i] == 'b') {
                        ab = a + 2 * ab;
                    } else {
                        abc = ab + 2 * abc;
                    }
                }

                System.out.println(abc);
            }
        }
    }

    void test() {
        String a = null;
        a.contains("a");
        Map<String, String> map = null;
        for (Map.Entry<String, String> s : map.entrySet()) {
            PriorityQueue<String> sss = new PriorityQueue<>();
        }
    }

    static class C implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return 0;
        }
    }
}

