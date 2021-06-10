package geeks.array;

import java.util.*;

//https://www.geeksforgeeks.org/merging-intervals/
//https://practice.geeksforgeeks.org/problems/overlapping-intervals/0
public class MergeIntervals {

    static class Pair {
        int i, j;
        Pair(int a, int b) {
            i = a;
            j = b;
        }
    }

    static class CustomComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.i != b.i ? a.i - b.i : a.j - b.j;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                Pair[] pairs = new Pair[n];
                for (int i = 0; i < n; i++) {
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    pairs[i] = new Pair(a, b);
                }

                Arrays.sort(pairs, new CustomComparator());
                List<Pair> res = new ArrayList<>();
                for (int i = 0; i < n; ) {
                    int curMax = pairs[i].j;
                    int j = i + 1;
                    while (j < n && pairs[j].i <= curMax) {
                        curMax = Math.max(curMax, pairs[j].j);
                        j++;
                    }
                    res.add(new Pair(pairs[i].i, curMax));
                    i = j;
                }
                for (Pair p : res) {
                    System.out.print(p.i + " " + p.j + " ");
                }
                System.out.println();
            }
        }
    }

}
