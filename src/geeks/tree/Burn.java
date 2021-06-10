package geeks.tree;

import java.util.ArrayDeque;
import java.util.Queue;

//https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/
//https://ide.geeksforgeeks.org/cAtrQRYOuE
public class Burn {

    static void doBurn(BTNode node, int target) {
        Queue<BTNode> queue = new ArrayDeque<>();
        burnTreeUtil(node, target, queue);
        while (!queue.isEmpty()) {
            printQueue(queue);
            System.out.println();
        }
    }

    private static boolean burnTreeUtil(BTNode root, int target, Queue<BTNode> q) {
        if (root == null)
            return false;
        if (root.data == target) {
            System.out.println(root.data);
            if (root.left != null)
                q.offer(root.left);
            if (root.right != null)
                q.offer(root.right);
            return true;
        }
        boolean left = burnTreeUtil(root.left, target, q);
        if (left) {
            printQueue(q);
            System.out.println(root.data);
            if (root.right != null) {
                q.offer(root.right);
            }
            // Return statement it prevents further further function call
            return true;
        }

        boolean right = burnTreeUtil(root.right, target, q);
        if (right) {
            printQueue(q);
            System.out.println(root.data);
            if (root.left != null) {
                q.offer(root.left);
            }
            return true;
        }
        return false;
    }

    private static void printQueue(Queue<BTNode> q) {
        int h = q.size();
        while (h-- > 0) {
            BTNode node = q.poll();
            System.out.print(node.data + " ");
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.left = new BTNode(12);
        root.right = new BTNode(13);

        root.right.left = new BTNode(14);
        root.right.right = new BTNode(15);

        root.right.left.left = new BTNode(21);
        root.right.left.right = new BTNode(22);
        root.right.right.left = new BTNode(23);
        root.right.right.right = new BTNode(24);
        doBurn(root, 14);
    }
}
