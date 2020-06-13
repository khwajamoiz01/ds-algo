/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

import java.util.HashSet;
import java.util.Set;

/**
 * @author khwaja.ali
 * @version $Id: DuplicateSubtree.java, v 0.1 2020-04-01 8:33 pm khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/check-binary-tree-contains-duplicate-subtrees-size-2/
public class DuplicateSubtree {

    public static boolean dupSub(BTNode root) {
        dupSub = false;
        dupSubUtil(root, new HashSet<>());
        return dupSub;
    }

    static boolean dupSub;

    //WRONG see geeks as one traversal can lead to multiple tree structures
    static String dupSubUtil(BTNode root, Set<String> subtrees) {
        if (root == null)
            return "";

        String left = dupSubUtil(root.left, subtrees);
        String right = dupSubUtil(root.right, subtrees);
        String str = left + root.data + right;
        if (str.length() > 1 && subtrees.contains(str)) {
            dupSub = true;
        }
        subtrees.add(str);
        return str;
    }

    public static void main(String[] args) {
        System.out.println(Long.parseLong("101101101101101101101", 2));
    }
}