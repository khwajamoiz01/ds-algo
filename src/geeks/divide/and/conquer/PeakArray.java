package geeks.divide.and.conquer;

//https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
//https://practice.geeksforgeeks.org/problems/peak-element/1
//accepted on practice, verify though
public class PeakArray {

    public int peakElement(int[] ar, int n) {
        int i = 0, j = n - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            boolean l = mid - 1 >= i ? ar[mid] >= ar[mid - 1] : true;
            boolean r = mid + 1 <= j ? ar[mid] >= ar[mid + 1] : true;
            if (l == false)
                j = mid - 1;
            else if (r == false)
                i = mid + 1;
            else return mid;
        }
        return -1;
    }

}
