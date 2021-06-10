package geeks.tree;

//https://www.geeksforgeeks.org/count-the-number-of-binary-search-trees-present-in-a-binary-tree/
//no practice option, verify solution
public class CountBST {
    public static void main(String[] args) {
        //*** below approach fails for the given input ***//
        BTNode root = BTNode.build(10)
                .withLeft(BTNode.build(100))
                .withRight(BTNode.build(15)
                        .withLeft(BTNode.build(2))
                        .withRight(BTNode.build(17)));
        System.out.println(countBSTInBT2(root));

        //*** min & max counters needs to be started from bottom ***//.
    }
    static class Pointer {
        int min, max;
    }

    static int countBSTInBT2(BTNode root) {
        Pointer2 p = new Pointer2();
        countBstUtil2(root, Integer.MIN_VALUE, Integer.MAX_VALUE, p);
        return p.res;
    }

    static boolean countBstUtil2(BTNode root, int min, int max, Pointer2 p) {
        if (root == null)
            return true;

        boolean left = countBstUtil2(root.left, min, root.data, p);
        boolean right = countBstUtil2(root.right, root.data, max, p);
        if (left && right) {
            p.res++;
        }
        return left && right && root.data >= min && root.data <= max;
    }

    static class Pointer2 {
        int res;
    }

}
