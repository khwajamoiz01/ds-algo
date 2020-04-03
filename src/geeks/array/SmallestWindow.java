/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.array;

import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;

import java.util.*;
import java.util.function.Consumer;

/**
 * The type Top k element.
 *
 * @author khwaja.ali
 * @version $Id : TopKElement.java, v 0.1 2019-12-21 16:22 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/smallest-window-contains-characters-string/
public class SmallestWindow {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String str = sc.next();
                Set<Character> distinct = new HashSet<>();
                StringBuilder patSB = new StringBuilder();
                for (char ch : str.toCharArray()) {
                    distinct.add(ch);
                }
                for (Character ch : distinct) {
                    patSB.append(ch);
                }
                String window = getSmallestWindow(str, patSB.toString());
                System.out.println(window);
            }
        }
    }

    private static String getSmallestWindow(String str, String pat) {
        {
            int len1 = str.length();
            int len2 = pat.length();

            int[] strFreq = new int[256];
            int[] patFreq = new int[256];

            for (int i = 0; i < len2; i++) {
                patFreq[pat.charAt(i)]++;
            }

            int start = 0;
            int count = 0;
            int min = len1;
            int startMin = -1;
            for (int i = 0; i < len1; i++) {
                strFreq[str.charAt(i)]++;
                //abcadce, xy
                if (strFreq[str.charAt(i)] <= patFreq[str.charAt(i)]) {
                    count++;
                }
                if (count == len2) {
                    while (strFreq[str.charAt(start)] > patFreq[str.charAt(start)]) {
                        strFreq[str.charAt(start)]--;
                        start++;
                    }
                    if (i - start + 1 < min) {
                        min = i - start + 1;
                        startMin = start;
                    }
                }
            }
            return count == len2 ? str.substring(startMin, startMin + min) : "-1";
        }
    }

}