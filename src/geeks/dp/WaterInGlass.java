package geeks.dp;

import java.util.Scanner;

//https://www.geeksforgeeks.org/find-water-in-a-glass/
//geeks approach is space optimized
public class WaterInGlass {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int k = sc.nextInt();
                int r = sc.nextInt();
                int c = sc.nextInt();
                double[][] ar = new double[r + 1][r + 1];
                ar[1][1] = k;
                boolean refilled;
                for (int i = 1; i < r; i++) {
                    refilled = false;
                    for (int j = 1; j <= i; j++) {
                        if (ar[i][j] > 1) {
                            double diff = ar[i][j] - 1;
                            ar[i + 1][j] += diff / 2;
                            ar[i + 1][j + 1] += diff / 2;
                            ar[i][j] = 1;
                            refilled = true;
                        }
                    }
                    if (!refilled)
                        break;
                }
                System.out.println(Math.min(1, ar[r][c]));
            }
        }
    }
}
