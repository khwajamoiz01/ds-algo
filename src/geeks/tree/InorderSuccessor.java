package geeks.tree;

/**
 * https://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 * also see {@link InorderSuccessorPredecessor}
 */
public class InorderSuccessor {

    public BTNode inorderSuccessor(BTNode root, BTNode x) {
        if (root == null)
            return null;
        if (x.right != null)
            return minBTNode(x.right);
        BTNode succ = null, cur = root;
        while (cur != null) {
            if (cur.data < x.data) {
                cur = cur.right;
            } else if (cur.data > x.data) {
                succ = cur;
                cur = cur.left;
            } else {
                break;
            }
        }
        return cur == x ? succ : null;
    }

    private BTNode minBTNode(BTNode Node) {
        BTNode cur = Node;
        while (cur != null && cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
}
