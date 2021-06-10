package geeks.array;

//https://practice.geeksforgeeks.org/problems/print-this-pattern0709/1/
public class PatternBoundary {

    void printPattern(int N) {
        for (int i = 0; i < 2 * N - 1; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                System.out.print(getBoundary(i, j, N));
            }
            System.out.println();
        }
    }

    int getBoundary(int i, int j, int n) {
        if (i >= n)
            i = 2 * n - 1 - i - 1;
        if (j >= n)
            j = 2 * n - 1 - j - 1;
        return n - Math.min(i, j);
    }

}
