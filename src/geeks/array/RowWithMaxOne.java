package geeks.array;

import java.util.Scanner;

//https://www.geeksforgeeks.org/find-the-row-with-maximum-number-1s/
public class RowWithMaxOne {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int m = sc.nextInt();
                int[][] ar = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        ar[i][j] = sc.nextInt();
                          }
                }
                int row = 0;
                int j = 0;
                while (j < m && ar[0][j] == 0) {
                    j++;
                }
                //if no zero found then j = m
                int i = 1;
                while (i < n) {
                    while (j >= 1 && ar[i][j - 1] == 1) {
                        j--;
                        row = i;
                    }
                    i++;
                }
                System.out.println(row);
            }
        }
    }

}
