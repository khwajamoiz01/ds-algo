/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: StockBuySell.java, v 0.1 2019-12-08 17:41 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/stock-buy-sell/
//https://practice.geeksforgeeks.org/problems/stock-buy-and-sell2615/1/
//{100, 180, 260, 310, 40, 535, 695}
public class StockBuySell {

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int ar[] = new int[n];
                for (int i = 0; i < n; i++)
                    ar[i] = sc.nextInt();
                process(ar, n);
            }
        }
    }

    // {100, 180, 260, 310, 40, 535, 695}
    private static void process(int[] ar, int n) {
        if (n == 1)
            return;

        List<Pair> pairs = new ArrayList<>();
        int i = 0;
        while (i < n - 1) {
            while (i < n - 1 && ar[i + 1] <= ar[i])
                i++;

            if (i == n - 1)
                break;

            int j = i--;
            while (j < n - 1 && ar[j + 1] >= ar[j])
                j++;
            pairs.add(new Pair(i + 1, j));
            i = j;
        }

        for (Pair pair : pairs) {
            System.out.print(pair + " ");
        }
        System.out.println();
    }

    public static class Pair {
        int a, b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "(" + a + " " + b + ")";
        }
    }
}