/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.pattern.matching;

import java.util.Arrays;

/**
 * @author khwaja.ali
 * @version $Id: ZAlgo.java, v 0.1 2020-04-09 6:54 pm khwaja.ali Exp 3
 */
//INCOMPLETE
public class ZAlgo {

    static int[] getZAr(String str) {
        //a a b c a a b x a a a  z
        //0 1 2 3 4 5 6 7 8 9 10 11
        int n = str.length();
        int[] Z = new int[n];
        int L = 0, R = 0;
        for (int i = 1; i < n; ++i) {
            if (i > R) {
                L = R = i;
                while (R < n && str.charAt(R - L) == str.charAt(R)) {
                    R++;
                }
                Z[i] = R - L;
                R--;
            } else { //if(i <= R)
                //abaababaa
                //012345678
                int k = i - L;
                if (Z[k] < R - i + 1) {//(i + z[k] <= R
                    Z[i] = Z[k];
                } else {
                    L = i;
                    while (R < n && str.charAt(R - L) == str.charAt(R)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                }
            }
        }
        return Z;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getZAr("aabcaabxaaaz")));
    }
}