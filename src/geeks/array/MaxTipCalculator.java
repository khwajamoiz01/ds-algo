/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.array;

import java.util.*;

/**
 * @author khwaja.ali
 * @version $Id: MaxTipCalculator.java, v 0.1 2019-12-15 13:06 khwaja.ali Exp 3
 */
public class MaxTipCalculator {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int x = sc.nextInt();
                int y = sc.nextInt();
                int ax[] = new int[n];
                for (int i = 0; i < n; i++)
                    ax[i] = sc.nextInt();
                int ay[] = new int[n];
                for (int i = 0; i < n; i++)
                    ay[i] = sc.nextInt();
//                System.out.println(getMax(ax, x, ay, y, n));
                System.out.println(getMax(ax, x, ay, y, n));
            }
        }

    }

    private static int getMax(int[] ax, int x, int[] ay, int y, int n) {
        if (n == 0)
            return 0;
        selectionSort(ax, ay, n);
        System.out.println(Arrays.toString(ax));
        System.out.println(Arrays.toString(ay));

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (ax[i] > ay[i] && x > 0) {
                max += ax[i];
                x--;
            } else if (ax[i] < ay[i] && y > 0) {
                max += ay[i];
                y--;
            } else if (x > 0) {
                max += ax[i];
                x--;
            } else {
                max += ay[i];
                y--;
            }
        }
        return max;
    }

    private static void selectionSort(int[] ax, int[] ay, int n) {
        if (n == 0)
            return;

        for (int i = 0; i < n - 1; i++) {
            int max = Math.abs(ax[i] - ay[i]);
            int p = i;
            for (int j = i + 1; j < n; j++) {
                int d = Math.abs(ax[j] - ay[j]);
                if (d > max) {
                    p = j;
                    max = d;
                }
            }
            int tmp1 = ax[p];
            ax[p] = ax[i];
            ax[i] = tmp1;

            int tmp2 = ay[p];
            ay[p] = ay[i];
            ay[i] = tmp2;
        }
    }
}