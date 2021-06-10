package geeks.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.geeksforgeeks.org/longest-sub-array-sum-k/
public class LongestSubArraySum {
    //1 -1 0
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                int sum = 0;
                int lsa = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, -1);
                for (int i = 0; i < n; i++) {
                    sum += ar[i];
                    int diffSum = sum - k;
                    //its before for finding the sub arrays with sum = 0
                    if (!map.containsKey(sum)) {
                        map.put(sum, i);
                    }
                    if (map.containsKey(diffSum)) {
                        lsa = Math.max(lsa, i - map.get(diffSum));
                    }
                }
                System.out.println(lsa);
            }
        }
    }

}
