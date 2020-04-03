/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.array;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author khwaja.ali
 * @version $Id: WordBnAC.java, v 0.1 2020-03-23 11:02 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/remove-a-and-bc-from-a-given-string/
//Below is an possible solutions which seems correct
public class WordBnAC {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                char[] ar = sc.next().toCharArray();
                int j = 0;
                int i = 0;
                for (; i < ar.length; i++) {
                    if (ar[i] == 'b') {
                    } else if (i < (ar.length - 1)
                            && ar[i] == 'a' && ar[i + 1] == 'c') {
                        i++;
                    } else {
                        ar[j++] = ar[i];
                    }
                }
                for (int k = 0; k < j; k++) {
                    System.out.print(ar[k]);
                }
                System.out.println();
            }
        }
    }

    void test() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
    }
}