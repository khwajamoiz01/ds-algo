package geeks.dp;

import java.util.Arrays;
import java.util.Comparator;

//https://www.geeksforgeeks.org/largest-subset-of-rectangles-such-that-no-rectangle-fit-in-any-other-rectangle/
public class LargestRectangleSubset {
    static class Rectangle {
        int height, width;

        Rectangle(int h, int w) {
            this.height = h;
            this.width = w;
        }
    }

    public static void main(String[] args) {
        Rectangle[] tc1 = new Rectangle[3];
        tc1[0] = new Rectangle(1, 3);
        tc1[1] = new Rectangle(2, 2);
        tc1[2] = new Rectangle(1, 3);
        System.out.println(process(tc1));

        Rectangle[] tc2 = new Rectangle[4];
        tc2[0] = new Rectangle(1, 5);
        tc2[1] = new Rectangle(2, 4);
        tc2[2] = new Rectangle(1, 1);
        tc2[3] = new Rectangle(3, 3);
        System.out.println(process(tc2));
    }

    static int process(Rectangle[] ar) {
        Arrays.sort(ar, Comparator.comparingInt(o -> o.width));
        return processDp(ar, ar.length, Integer.MIN_VALUE);
    }

    //in geeks previous value is used, which is same as current maxValue
    //no practice option, solutions (recursive eq only) seems fine
    private static int processDp(Rectangle[] ar, int n, int maxValue) {
        if (n == 0)
            return 0;
        if (ar[n - 1].height > maxValue) {
            int exclude = processDp(ar, n - 1, maxValue);
            int include = 1 + processDp(ar, n - 1, ar[n - 1].height);
            return Math.max(include, exclude);
        }
        return processDp(ar, n - 1, maxValue);
    }
}
