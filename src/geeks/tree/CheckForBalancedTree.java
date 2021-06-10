package geeks.tree;

//https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
//https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
//practice accepted, cleaner solution than geeks
public class CheckForBalancedTree {

    static class Pointer {
        boolean value;
    }

    boolean isBalanced(BTNode root) {
        Pointer p = new Pointer();
        p.value = true;
        isBalancedUtil(root, p);
        return p.value;
    }

    private int isBalancedUtil(BTNode node, Pointer p) {
        if (node == null)
            return 0;
        int l = isBalancedUtil(node.left, p);
        int r = isBalancedUtil(node.right, p);
        int diff = Math.abs(l - r);
        if (diff > 1)
            p.value = false;
        return Math.max(l, r) + 1;
    }
}
