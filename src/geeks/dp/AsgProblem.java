/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: AsgProblem.java, v 0.1 2020-04-04 1:40 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/hungarian-algorithm-assignment-problem-set-1-introduction/
//my impl is not efficient
public class AsgProblem {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[][] ar = new int[n][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        ar[i][j] = sc.nextInt();
                    }
                }
                boolean[] asg = new boolean[n];//for marking people
                System.out.println(minAsg(ar, asg, n, n));
            }
        }
    }

    /**
     *
     */
    static int minAsg(int[][] ar, boolean[] asg, int P, int J) {
        if (J == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int ppl = 0; ppl < P; ppl++) {
            if (!asg[ppl]) {
                asg[ppl] = true;
                min = Math.min(min, ar[ppl][J - 1] + minAsg(ar, asg, P, J - 1));
                asg[ppl] = false;
            }
        }
        return min;
    }


}