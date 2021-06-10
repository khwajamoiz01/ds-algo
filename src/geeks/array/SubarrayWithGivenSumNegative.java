/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author khwaja.ali
 * @version $Id: SubarrayWithGivenSum.java, v 0.1 2019-12-22 16:18 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
public class SubarrayWithGivenSumNegative {
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

                Map<Integer, Integer> sumFreq = new HashMap<>();
                sumFreq.put(0, 1);

                int sum = 0;
                int count = 0;
                for (int i = 0; i < n; i++) {
                    sum += ar[i];
                    //count should be incremented first, otherwise output will be invalid whenever k = 0, refer case 1
                    if (sumFreq.containsKey(sum - k)) {
                        count += sumFreq.get(sum - k);
                    }
                    int value = sumFreq.getOrDefault(sum, 0) + 1;
                    sumFreq.put(sum, value);

                }
                System.out.println(count);
            }
        }
    }
}

/*
case 1:
Input
1
3
0 1 -1
0
Expected output
3
 */


/*
case 3:
Input
1
4
0 1 2 0
3
Expected output
4
 */
