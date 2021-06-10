package geeks.array;

//https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
public class SortedArraySearch {

    public static int matSearch(int[][] ar, int N, int M, int x) {
        int si = 0, sj = M - 1;
        while (si < N && sj >= 0) {
            if (ar[si][sj] < x)
                si++;
            else if (ar[si][sj] > x)
                sj--;
            else return 1;
        }
        return 0;
    }

}
