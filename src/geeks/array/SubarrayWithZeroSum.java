package geeks.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
//compare with SubarrayWithGivenSumNegative
public class SubarrayWithZeroSum {
    //doesn't run on practice due to TLE, but the code seems fine
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                long[] ar = new long[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextLong();
                }
                long sum = 0;
                int res = 0;
                Map<Long, Integer> map = new HashMap<>();
                map.put(0l, 1);
                for (int i = 0; i < n; i++) {
                    sum += ar[i];
                    int value = map.getOrDefault(sum, 0);
                    res += value;
                    map.put(sum, value + 1);
                }
                System.out.println(res);
            }
        }
    }

}
