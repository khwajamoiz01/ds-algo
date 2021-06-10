package geeks.tree;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/print-k-sum-paths-binary-tree/
public class KSumPath {

    private static void process(BTNode root, int k) {
        if (root == null)
            return;
        List<BTNode> path = new ArrayList<>();
        processUtil(root, k, path);
    }

    private static void processUtil(BTNode root, int k, List<BTNode> path) {
        if (root == null)
            return;
        path.add(root);
        processUtil(root.left, k, path);
        processUtil(root.right, k, path);
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i).data;
            if (sum == k) {
                printPath(path, i, path.size() - 1);
            }
        }
        path.remove(root);
    }

    private static void printPath(List<BTNode> path, int i, int j) {
        for (int k = i; k <= j; k++) {
            System.out.print(path.get(k) + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(3);
        root.left.left = new BTNode(2);
        root.left.right = new BTNode(1);
        root.left.right.left = new BTNode(1);
        root.right = new BTNode(-1);
        root.right.left = new BTNode(4);
        root.right.left.left = new BTNode(1);
        root.right.left.right = new BTNode(2);
        root.right.right = new BTNode(5);
        root.right.right.right = new BTNode(2);
        process(root, 5);
    }
}
