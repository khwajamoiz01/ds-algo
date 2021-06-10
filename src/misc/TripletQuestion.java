package misc;

import java.util.*;
//-1 0 1
//0 1-1

public class TripletQuestion {
    static class Triplet {
        int i, j, k;

        Triplet(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplet triplet = (Triplet) o;
            int[] ar1 = new int[3];
            ar1[0] = i;
            ar1[1] = j;
            ar1[2] = k;
            int[] ar2 = new int[3];
            ar2[0] = triplet.i;
            ar2[1] = triplet.j;
            ar2[2] = triplet.k;
            Arrays.sort(ar1);
            Arrays.sort(ar2);
            for (int i = 0; i < 3; i++) {
                if (ar1[i] != ar2[i])
                    return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, k);
        }
    }

    static class Pair {
        int i, j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        //int[] ar = {-1, 0, 1, 2, -1, -4};
        int[] ar = {1, 2, 3, 4};
        process(ar);
    }

    private static void process(int[] ar) {

        Map<Integer, List<Pair>> pairSum = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length; j++) {
                int sum = ar[i] + ar[j];
                Pair pair = new Pair(i, j);
                if (!pairSum.containsKey(sum)) {
                    pairSum.put(sum, new ArrayList<>());
                }
                pairSum.get(sum).add(pair);
            }
        }
        Set<Triplet> set = new HashSet<>();
        for (int i = 0; i < ar.length; i++) {
            if (pairSum.containsKey(-ar[i])) {
                List<Pair> pairs = pairSum.get(-ar[i]);
                for (Pair p : pairs) {
                    if ((p.i > i && p.j > i))
                        set.add(new Triplet(ar[i], ar[p.i], ar[p.j]));
                }
            }
        }
        for (Triplet t : set) {
            System.out.println("[" + t.i + "," + t.j + "," + t.k + "]");

        }
    }
}
//A solution set is: [   [-1, 0, 1],   [-1, -1, 2] ]












