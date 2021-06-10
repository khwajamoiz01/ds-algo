package geeks.array;

import java.util.ArrayList;

//https://practice.geeksforgeeks.org/problems/transform-the-array4344/1/
//failing on practice, seems correct, cross check with successful submissions using stack

public class DoubleAndZeroShift {
    void swap(int[] ar, int i, int j) {
        if (i == j)
            return;
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    public ArrayList<Integer> valid(int[] ar, int n) {
        int pv = -1;
        int j = -1;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == 0)
                continue;
            swap(ar, ++j, i);
            if (pv == -1) {
                pv = j;
                continue;
            }
            if (ar[pv] == ar[j]) {
                ar[pv] += ar[j];
                ar[j] = 0;
                j--;
            } else {
                pv = j;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(ar[i]);
        }
        return res;
    }
}

