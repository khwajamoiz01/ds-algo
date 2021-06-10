package geeks.string;

//https://www.geeksforgeeks.org/round-the-given-number-to-nearest-multiple-of-10/
//https://practice.geeksforgeeks.org/problems/nearest-multiple-of-102437/1/
public class NearestMultipleOfTen {

    String process(String n) {
        char[] ar = n.toCharArray();
        int l = n.length();
        if (ar[l - 1] <= '5') {
            ar[l - 1] = '0';
            return new String(ar);
        } else {
            ar[l - 1] = '0';
            for (int i = l - 2; i >= 0; i--) {
                if (ar[i] < '9') {
                    ar[i]++;
                    return new String(ar);
                } else {
                    ar[i] = '0';
                }
            }
            return '1' + new String(ar);
        }
    }

}
