package misc;

import geeks.linkedlist.Node;

import java.util.LinkedHashSet;
import java.util.*;
import java.util.Queue;

public class Temp {
    public static void main(String[] args) {
        Queue<Node> q;
        LinkedHashSet<Node> l = new LinkedHashSet<>();
        List<Integer> list = new ArrayList<Integer>();
        list.remove(2);
        String.format("");
        PriorityQueue<String> s;
        int[] ar = {8, 0, 0, 6, 7, 3, 12, 3, 6, 8, 6, 4, 7, 0, 0, 1, 2, 1, 0, 0};
        System.out.println(canReach(ar, ar.length));
    }

    static int canReach(int[] A, int n) {
        return canReachUtil(A, 0, n) ? 1 : 0;
    }

    static boolean canReachUtil(int[] ar, int i, int n) {
        if (i >= n - 1)
            return true;
        if (ar[i] == 0) {
            return false;
        }
        int max = i + ar[i];
        for (int j = i + 1; j < n && j <= i + ar[i]; j++) {
            max = Math.max(max, j + ar[j]);
        }
        if (max >= n - 1)
            return true;
        return canReachUtil(ar, max, n);
    }

}
