package geeks.array;

//https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-group-all-1s-together2451/1/
//https://www.geeksforgeeks.org/minimum-swaps-required-group-1s-together/
public class MinSwapToGroup {

    // Function for finding maximum and value pair
    public static int minSwaps (int ar[], int n) {
        int countOne = 0;
        for (int i = 0; i < n; i++) {
            if (ar[i] == 1) {
                countOne++;
            }
        }
        if (countOne == 0)
            return -1;
        int curZ = 0;
        for (int i = 0; i < countOne; i++) {
            if (ar[i] == 0) {
                curZ++;
            }
        }
        int minZ = curZ;
        for (int i = countOne; i < n; i++) {
            if (ar[i] == 0) {
                curZ++;
            }
            if (ar[i - countOne] == 0) {
                curZ--;
            }
            minZ = Math.min(minZ, curZ);
        }
        return minZ;
    }

}
