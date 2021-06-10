package geeks.tree;

import java.util.ArrayDeque;
import java.util.Queue;

//https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-complete-tree-or-not/
//no practice option, below seems correct but follow geeks solution
public class BinaryTreeCompleteness {

    boolean isComplete(BTNode node) {
        if (node == null)
            return true;
        Queue<BTNode> q = new ArrayDeque<>();
        q.offer(node);
        boolean onlyLeaf = false;
        while (!q.isEmpty()) {
            BTNode n = q.poll();
            if (onlyLeaf && (!isLeaf(n)))
                return false;

            if (n.right == null)
                onlyLeaf = true;
            if (n.left != null) {
                q.offer(n.left);
            }
            if (n.right != null) {
                q.offer(n.right);
                if (n.left == null)
                    return false;
            }
        }
        return true;
    }

    private boolean isLeaf(BTNode n) {
        return n.left == null && n.right == null;
    }
}
