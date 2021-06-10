package geeks.divide.and.conquer;

//https://www.geeksforgeeks.org/modular-exponentiation-recursive/
public class ModularExponentiation {
    public static void main(String[] args) {
        System.out.println(find(2312, 3434, 6789));
        System.out.println(find(-3, 5, 89));
        System.out.println(find(-2, 2, 10));
    }

    private static int find(int a, int b, int c) {
        if (a == 0)
            return 0;
        if (b == 0)
            return 1;
        int half = find(a, b / 2, c);
        int res = (half * half) % c;
        if (b % 2 == 1)
            res = (res * (a % c)) % c;
        return (res + c) % c;
    }
}
