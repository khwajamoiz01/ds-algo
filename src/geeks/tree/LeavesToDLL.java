package geeks.tree;

public class LeavesToDLL {

    static class Pointer {
        BTNode head, prev = null;
    }

    public BTNode convertToDLL(BTNode root) {
        if (root == null)
            return null;
        Pointer p = new Pointer();
        convertUtil(root, p);
        return p.head;
    }

    private BTNode convertUtil(BTNode cur, Pointer p) {
        if (cur == null)
            return null;
        BTNode left = convertUtil(cur.left, p);
        if (cur.left == null && cur.right == null) {
            if (p.head == null)
                p.head = cur;
            if (p.prev != null) {
                p.prev.right = cur;
                cur.left = p.prev;
            }
            p.prev = cur;
            return null;
        }
        BTNode right = convertUtil(cur.right, p);
        cur.left = left;
        cur.right = right;
        return cur;
    }

}
