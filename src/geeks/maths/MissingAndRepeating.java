package geeks.maths;

//https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
//https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
public class MissingAndRepeating {

    int[] findTwoElement(int ar[], int n) {
        int xor = 0;
        for (int i = 0; i < ar.length; i++) {
            xor ^= ar[i];
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int rsb = xor & -xor;
        int a = 0, b = 0;
        for (int i = 0; i < ar.length; i++) {
            if ((rsb & ar[i]) == 0)
                a ^= ar[i];
            else
                b ^= ar[i];
        }
        for (int i = 1; i <= n; i++) {
            if ((rsb & i) == 0)
                a ^= i;
            else
                b ^= i;
        }


        int[] res = new int[2];
        //finding which of the two is repeating one
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == a) {
                res[0] = a;
                res[1] = b;
                return res;
            }
        }
        return new int[]{b, a};
    }
}

