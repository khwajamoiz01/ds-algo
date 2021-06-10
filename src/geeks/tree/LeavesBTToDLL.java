package geeks.tree;

//https://www.geeksforgeeks.org/connect-leaves-doubly-linked-list/
public class LeavesBTToDLL {
    static class Pointer {
        BTNode head, prev = null;
    }

    static BTNode convertToDLL(BTNode root) {
        if (root == null)
            return null;
        Pointer p = new Pointer();
        convertUtil(root, p);
        return p.head;
    }

    static boolean convertUtil(BTNode root, Pointer p) {
        if (root == null)
            return false;
        //get this value before changing pointers otherwise if you check while returning then,  leaf wont be returned as leaf
        boolean isLeaf = root.left == null && root.right == null;
        boolean l = convertUtil(root.left, p);
        if (isLeaf) {
            if (p.head == null) {
                p.head = root;
            }
            if (p.prev != null) {
                p.prev.right = root;
                root.left = p.prev;
            }
            p.prev = root;
        }
        boolean r = convertUtil(root.right, p);
        root.left = l ? null : root.left;
        root.right = r ? null : root.right;
        return isLeaf;
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(2);
        root.left = new BTNode(1);
        root.right = new BTNode(3);
        convertToDLL(root);
    }
}
