package geeks.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://www.geeksforgeeks.org/number-of-palindromic-paths-in-a-matrix/
//solution seems correct, same as geeks, practice gives TLE
//Time Complexity - O((R x C)2)
public class PallPaths {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int r = sc.nextInt();
                int c = sc.nextInt();
                char[][] ar = new char[r][c];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        ar[i][j] = sc.next().charAt(0);
                    }
                }
                int res = pallPaths(ar, 0, 0, r - 1, c - 1, r, c, new HashMap<>());
                System.out.println(res);
            }
        }
    }

    static int pallPaths(char[][] ar, int rs, int cs, int re, int ce, int R, int C, Map<String, Integer> dp) {
        if (rs >= R || cs >= C)
            return 0;
        if (re < 0 || ce < 0)
            return 0;
        if (rs > re || cs > ce)
            return 0;
        if (ar[rs][cs] != ar[re][ce])
            return 0;
        int dist = (re - rs) + (ce - cs);
        if (dist == 0 || dist == 1)
            return 1;
        String key = rs + " " + cs + " " + re + " " + ce;
        if (!dp.containsKey(key)) {
            int res = 0;
            res += pallPaths(ar, rs + 1, cs, re - 1, ce, R, C, dp);
            res += pallPaths(ar, rs + 1, cs, re, ce - 1, R, C, dp);
            res += pallPaths(ar, rs, cs + 1, re - 1, ce, R, C, dp);
            res += pallPaths(ar, rs, cs + 1, re, ce - 1, R, C, dp);
            dp.put(key, res);
        }
        return dp.get(key);
    }

}

