package geeks.array;

import java.util.Arrays;

//https://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/
//https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
//failing on practice but solution is correct as per geeks and prev successful submissions
public class MinimizeHeightDiff {

    int getMinDiff(int[] ar, int n, int k) {
        Arrays.sort(ar);
        //System.out.println(Arrays.toString(ar));
        int min = ar[0] + k;
        int max = ar[n - 1] - k;
        min = Math.min(min, max);
        max = Math.max(min, max);

        for (int i = 1; i < n - 1; i++) {
            //System.out.println(min +", " + max);
            int sub = ar[i] - k;
            int add = ar[i] + k;
            if (sub >= min || add <= max) {
                continue;
            }
            int diffMin = Math.abs(min - sub);
            int diffMax = Math.abs(max - add);
            if (diffMin <= diffMax) {
                min = sub;
            } else {
                max = add;
            }
        }
        //System.out.println(min +", " + max);
        return Math.min(ar[n - 1] - ar[0], max - min);

    }

}
