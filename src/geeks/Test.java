package geeks;

import geeks.tree.BTNode;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    static class Pointer {
        int index;
    }

    public BTNode preorderToBst(int[] ar) {
        Pointer p = new Pointer();
        p.index = 0;
        return preorderToBstUtil(p, ar, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    //10, 5, 1, 7, 40, 50
    private BTNode preorderToBstUtil(Pointer p, int[] ar, int minValue, int maxValue) {
        if (p.index >= ar.length)
            return null;
        if (ar[p.index] <= minValue || ar[p.index] >= maxValue)
            return null;
        BTNode root = new BTNode(ar[p.index]);
        p.index++;
        root.left = preorderToBstUtil(p, ar, minValue, root.data);
        root.right = preorderToBstUtil(p, ar, root.data, maxValue);
        return root;
    }

    public int KthSmallest(int[] ar, int n, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int i;
        for (i = 0; i < k; i++) {
            maxHeap.offer(ar[i]);
        }
        for (; i < n; i++) {
            if (ar[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(ar[i]);
            }
        }
        return maxHeap.peek();
    }

    int minOpsToSorted(int[] ar, int n) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, ar[i]);
            max = Math.max(max, ar[i]);
        }
        return -1;
    }

    int minJumps(int[] ar, int n) {
        int minJumps = Integer.MAX_VALUE;
        int jumps = 0;
        for (int i = 0; i < n; i++) {
            int maxReach = i;
            int maxReachPos = -1;
            for (int j = i + 1; j < i + ar[i]; j++) {
                if (i + ar[j] > maxReach) {
                    maxReach = i + ar[i];
                    maxReachPos = j;
                }
                if (maxReach >= n - 1)
                    return minJumps;
            }
            i = maxReachPos;

        }
        return minJumps;
    }

    //AAABAAA
    //[0, 1, 2, 0, 1, 2, 3]
    int[] lps(String pat) {
        int l = pat.length();
        int[] lps = new int[l];
        int i = 1, j = 0;
        while (i < pat.length()) {
            if (pat.charAt(j) == pat.charAt(i)) {
                lps[i] = ++j;
                i++;
            } else if (j != 0) {
                j = lps[j - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
        return lps;
    }

    void partition(int[] ar, int s, int e) {
        int pivot = ar[e];
        int j = s;
        for (int i = s; i < e; i++) {
            if (ar[i] < pivot) {
                int t = ar[j];
                ar[j] = ar[i];
                ar[i] = t;
                j++;
            }
        }
        ar[j] = pivot;
    }

    int powXYRec(int x, int y) {
        if (y == 0)
            return 1;
        int temp = powXYRec(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        return x * temp * temp;
    }

    long powXYIter(int x, int y) {
        int mod = 1000000007;
        long pow = x;
        for (int i = 2; i <= y; i = i * 2) {
            pow = (pow * pow) % mod;
        }
        if (y % 2 != 0)
            pow = (pow * x) % mod;
        System.out.println(pow);
        return pow;
    }

    void test() {
        Integer.toBinaryString(1);
        Set<ArrayList<Integer>> res = new TreeSet<>();
        res.add(new ArrayList<>());
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>(res);

    }

    static ArrayList<Integer> verticalOrder(BTNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        verticalUtil(root, map, 0);
        ArrayList<Integer> result = new ArrayList<>();
        System.out.println(map);
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            entry.getValue().stream().map(result::add).collect(Collectors.toList());
        }
        return result;
    }

    static void verticalUtil(BTNode root, Map<Integer, List<Integer>> map, int dist) {
        if (root == null)
            return;
        if (!map.containsKey(dist)) {
            map.put(dist, new ArrayList<Integer>());
        }
        map.get(dist).add(root.data);
        verticalUtil(root.left, map, dist - 1);
        verticalUtil(root.right, map, dist + 1);
    }

    public static void main(String[] args) {
        int[] ar = null;
    }
}