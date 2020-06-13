/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Time complexity - O(n)
 * Space complexity - O(n)
 * In place - No
 * Stable - Yes as insertion sort is stable
 *
 * @author khwaja.ali
 * @version $Id: Bucket.java, v 0.1 2020-05-01 3:36 pm khwaja.ali Exp 3
 */
public class Bucket {

    public static void sort(double[] ar) {
        int n = ar.length;
        List<Double>[] bucket = new List[n];

        //O(n)
        for (int i = 0; i < n; i++) {
            //its like adding in the bucket by finding the ar[i] percent of n
            int j = (int) (n * ar[i]);
            if (bucket[j] == null)
                bucket[j] = new ArrayList<>();
            bucket[j].add(ar[i]);
        }
        //Average time taken when input is uniformly distributed
        //O(n)
        for (int i = 0; i < n; i++) {
            if (bucket[i] == null)
                continue;
            //Insertion sort is preferable, which can be called over a linked list
            Collections.sort(bucket[i]);
        }

        //O(n)
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (bucket[i] == null)
                continue;
            for (double j : bucket[i]) {
                ar[index++] = j;
            }
        }
    }

    public static void main(String[] args) {
        double ar[] = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
        Bucket.sort(ar);
        System.out.println(Arrays.toString(ar));
    }

}