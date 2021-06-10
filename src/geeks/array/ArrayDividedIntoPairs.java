package geeks.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArrayDividedIntoPairs {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] ar = new int[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.nextInt();
                }
                int k = sc.nextInt();
                if (n % 2 == 1) {
                    System.out.println("False");
                    continue;
                }
                Map<Integer, Integer> map = new HashMap<>();
                int count = 0;
                for (int i = 0; i < n; i++) {
                    int rem = ar[i] % k;
                    int key2 = rem == 0 ? 0 : k - rem;
                    int freq2 = map.getOrDefault(key2, 0);
                    if (freq2 > 0) {
                        map.put(key2, freq2 - 1);
                        count++;
                    } else {
                        int freq1 = map.getOrDefault(rem, 0);
                        map.put(rem, freq1 + 1);
                    }
                }
                System.out.println(count == n / 2 ? "True" : "False");
            }
        }
    }

}
