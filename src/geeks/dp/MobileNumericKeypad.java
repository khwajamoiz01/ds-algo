package geeks.dp;

import java.util.HashMap;
import java.util.Map;

//https://practice.geeksforgeeks.org/problems/mobile-numeric-keypad5456/1
//https://www.geeksforgeeks.org/mobile-numeric-keypad-problem/
public class MobileNumericKeypad {

    static int[][] keypad =
            {{1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9},
                    {-1, 0, -1}};

    public long getCount(int N) {

        long count = 0;
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 2; j++) {
                count += getCountUtil(i, j, N, new HashMap<String, Long>());
            }
        }
        return count;
    }

    public long getCountUtil(int i, int j, int n, Map<String, Long> dp) {
        if (i < 0 || i > 3 || j < 0 || j > 2)
            return 0;
        if (i == 3 && (j == 0 || j == 2))
            return 0;
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        String key = i + "_" + j + "_" + n;
        if (!dp.containsKey(key)) {
            long count = 0;
            count += getCountUtil(i, j, n - 1, dp);
            count += getCountUtil(i, j - 1, n - 1, dp);
            count += getCountUtil(i - 1, j, n - 1, dp);
            count += getCountUtil(i, j + 1, n - 1, dp);
            count += getCountUtil(i + 1, j, n - 1, dp);
            dp.put(key, count);
        }
        return dp.get(key);
    }

}
