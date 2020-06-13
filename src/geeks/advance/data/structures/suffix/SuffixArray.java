/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.advance.data.structures.suffix;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author khwaja.ali
 * @version $Id: SuffixArray.java, v 0.1 2020-04-26 1:56 pm khwaja.ali Exp 3
 */
public class SuffixArray {

    static class Suffix {
        int index;
        String data;

        Suffix(int index, String data) {
            this.index = index;
            this.data = data;
        }

        public String toString() {
            return "[" + index + ": " + data + "]";
        }
    }

    Suffix[] suffixes;

    SuffixArray(String text) {
        int n = text.length();
        suffixes = new Suffix[n];
        for (int i = 0; i < n; i++) {
            suffixes[i] = new Suffix(i, text.substring(i));
        }
        Arrays.sort(suffixes, new Comparator<Suffix>() {
            public int compare(Suffix s1, Suffix s2) {
                return s1.data.compareTo(s2.data);
            }
        });
        System.out.println(Arrays.toString(suffixes));
    }

    void search(String pattern) {
        int m = pattern.length();
        int i = 0, j = suffixes.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            String suffix = suffixes[mid].data;
            int compare = pattern.compareTo(suffix.substring(0, Math.min(suffix.length(), m)));
            if (compare < 0) {
                j = mid - 1;
            } else if (compare > 0) {
                i = mid + 1;
            } else {
                System.out.println(pattern + " found at position" + suffixes[mid].index);
                return;
            }
        }
        System.out.println(pattern + " not found in the text");
    }

    public static void main(String[] args) {
        SuffixArray sa = new SuffixArray("banana");
        sa.search("nan");
        sa.search("abc");

    }

}