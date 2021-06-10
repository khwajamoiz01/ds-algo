package geeks.tree;

/** https://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/
also see {@link InorderSuccessor}
 */
public class InorderSuccessorPredecessor {
    public static void findPreSuc(BTNode root, Res p, Res s, int key) {
        if (root == null)
            return;
        if (root.data > key) {
            s.succ = root;
            findPreSuc(root.left, p, s, key);
        } else if (root.data < key) {
            p.pre = root;
            findPreSuc(root.right, p, s, key);
        } else {
            if (root.right != null) {
                BTNode suc = root.right;
                while (suc.left != null)
                    suc = suc.left;
                s.succ = suc;
            }
            if (root.left != null) {
                BTNode pre = root.left;
                while (pre.right != null)
                    pre = pre.right;
                p.pre = pre;
            }
        }
    }

    static class Res {
        BTNode succ;
        BTNode pre;
    }
}


