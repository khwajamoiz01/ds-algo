package geeks.maths;

//https://stackoverflow.com/questions/43923906/what-are-0xaa-and-0x55-doing/43924111

public class SwapAllOddAndEvenBits {
    static int swapBits(int x) {
        // Get all even bits of x
        int even_bits = x & 0xAAAAAAAA;
        System.out.println("even_bits : " + even_bits);
        // Get all odd bits of x
        int odd_bits = x & 0x55555555;
        System.out.println("odd_bits : " + odd_bits);

        // Right shift even bits
        even_bits >>= 1;

        // Left shift even bits
        odd_bits <<= 1;

        // Combine even and odd bits
        return (even_bits | odd_bits);
    }

    public static void main(String[] args) {
        System.out.println(swapBits(23));
        System.out.println(swapBits(43));
    }

}
