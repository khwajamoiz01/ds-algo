package geeks.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://www.geeksforgeeks.org/construct-all-possible-bsts-for-keys-1-to-n/
public class AllPossibleBST {

    List<BTNode> construct(int n) {
        if (n == 0)
            return null;
        return constructUtil(1, n);
    }

    private List<BTNode> constructUtil(int i, int j) {
        if (i > j)
            return Collections.emptyList();

        List<BTNode> res = new ArrayList<>();
        for (int k = i; k <= j; k++) {
            List<BTNode> leftList = constructUtil(i, k - 1);
            List<BTNode> rightList = constructUtil(k + 1, j);
            for (BTNode left : leftList) {
                for (BTNode right : rightList) {
                    BTNode root = new BTNode(k);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
