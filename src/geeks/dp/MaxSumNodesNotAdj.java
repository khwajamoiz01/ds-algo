package geeks.dp;

import geeks.tree.BTNode;

import java.util.Map;

//https://www.geeksforgeeks.org/maximum-sum-nodes-binary-tree-no-two-adjacent/
public class MaxSumNodesNotAdj {
    int maxSum(BTNode node, Map<BTNode, Integer> dp) {
        if (node == null)
            return 0;
        if (!dp.containsKey(node)) {
            int sumIncluded = node.data;
            if (node.left != null) {
                sumIncluded += maxSum(node.left.left, dp) + maxSum(node.left.right, dp);
            }
            if (node.right != null) {
                sumIncluded += maxSum(node.right.left, dp) + maxSum(node.right.right, dp);
            }
            int sumExcluded = maxSum(node.left, dp) + maxSum(node.right, dp);
            dp.put(node, Math.max(sumIncluded, sumExcluded));
        }
        return dp.get(node);
    }
}
