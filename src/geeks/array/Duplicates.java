/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.array;

/**
 * @author khwaja.ali
 * @version $Id: Duplicates.java, v 0.1 2019-12-14 19:35 khwaja.ali Exp 3
 */
public class Duplicates {

    //FOLLOW THIS - https://www.geeksforgeeks.org/duplicates-array-using-o1-extra-space-set-2/
    //OR https://www.geeksforgeeks.org/duplicates-in-an-array-in-on-time-and-by-using-o1-extra-space-set-3/
    public static void main(String[] args) {
        int[] ar = {2, 3, 0, 2, 3, 0};
        int n = ar.length;

        boolean found = false;
        for (int i = 0; i < n; i++) {
            ar[i] += n;
        }
        for (int i = 0; i < n; i++) {
            int pos = Math.abs(ar[i]) - n;
            if (pos >= n)
                pos -= n;
            if (ar[pos] < 0) {
                found = true;
                System.out.print(pos + " ");
                ar[pos] = -1 * ar[pos] + n;
            } else if (ar[pos] < 2 * n) {
                ar[pos] = -ar[pos];
            }

        }
        if (!found)
            System.out.print(-1 + " ");
    }

    public void duplicates(int[] ar) {

        int n = ar.length;

        for (int i = 0; i < n; i++) {
            int pos = ar[i] % n;
            ar[pos] += n;
        }
    }

}