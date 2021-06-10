package geeks.tree;

//https://practice.geeksforgeeks.org/problems/fixed-two-nodes-of-a-bst/1
//https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
public class FixTwoNodes {
    static class Pointer {
        BTNode prev, first, sec;
    }

    BTNode correctBST(BTNode root) {
        Pointer p = new Pointer();
        correctBstUtil(root, p);

        int tmp = p.first.data;
        p.first.data = p.sec.data;
        p.sec.data = tmp;
        return root;
    }

    void correctBstUtil(BTNode root, Pointer p) {
        if (root == null)
            return;
        correctBstUtil(root.left, p);
        if (p.prev != null && p.prev.data > root.data) {
            if (p.first == null) {
                p.first = p.prev;
            }
            p.sec = root;
        }
        p.prev = root;
        correctBstUtil(root.right, p);
    }
}
