/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.tree;

/**
 * @author khwaja.ali
 * @version $Id: NumberOfTurns.java, v 0.1 2020-01-01 14:10 khwaja.ali Exp 3
 */
//https://www.geeksforgeeks.org/number-turns-reach-one-node-binary-tree/
//https://practice.geeksforgeeks.org/problems/number-of-turns-in-binary-tree/1
public class NumberOfTurns {

    /******************below solution accepted on practice*****************/
    static int process(BTNode root, int first, int sec) {
        BTNode lca = findLCA(root, first, sec);
        int turnsInLeft = countTurns(lca.left, first, sec, false, 'L', 0);
        int turnsInRight = countTurns(lca.right, first, sec, false, 'R', 0);

        if (turnsInLeft != -1 && turnsInRight != -1)
            return turnsInLeft + turnsInRight + 1;
        if (turnsInLeft != -1)
            return turnsInLeft;
        return turnsInRight;
    }

    static int countTurns(BTNode root, int first, int sec, boolean flag, char child, int turns) {
        if (root == null)
            return -1;
        if (flag)
            turns++;
        if (root.data == first || root.data == sec) {
            return turns;
        }
        int l = countTurns(root.left, first, sec, child == 'R', 'L', turns);
        int r = countTurns(root.right, first, sec, child == 'L', 'R', turns);
        return l != -1 ? l : r;
    }

    static BTNode findLCA(BTNode root, int first, int sec) {
        if (root == null)
            return null;
        if (root.data == first || root.data == sec)
            return root;
        BTNode l = findLCA(root.left, first, sec);
        BTNode r = findLCA(root.right, first, sec);
        if (l != null && r != null)
            return root;
        return l != null ? l : r;
    }

    /******************below solution fails on practice*****************/
    /**
     static class Pointer {
     int left, right;
     }

     static int NumberOfTurns(BTNode root, int first, int sec) {
     BTNode lca = findLCA(root, first, sec);
     Pointer p = new Pointer();

     boolean presentInLeft = isPresentInLeft(lca.left, first, sec, p, false);
     boolean presentInRight = isPresentInRight(lca.right, first, sec, p, false);
     //System.out.println(presentInLeft + " " + presentInRight + " " + p.left + " " + p.right);
     if (presentInLeft && presentInRight)
     return p.left + p.right + 1;
     if (presentInLeft)
     return p.left;
     if (presentInRight)
     return p.right;
     return -1;
     }

     static boolean isPresentInLeft(BTNode root, int first, int sec, Pointer p, boolean flag) {
     if (root == null)
     return false;
     if (flag)
     p.left++;
     if (root.data == first || root.data == sec)
     return true;
     return isPresentInLeft(root.left, first, sec, p, false) ||
     isPresentInLeft(root.right, first, sec, p, true);
     }

     static boolean isPresentInRight(BTNode root, int first, int sec, Pointer p, boolean flag) {
     if (root == null)
     return false;
     if (flag)
     p.right++;
     if (root.data == first || root.data == sec)
     return true;
     return isPresentInRight(root.left, first, sec, p, true) ||
     isPresentInRight(root.right, first, sec, p, false);
     }

     static BTNode findLCA(BTNode root, int first, int sec) {
     if (root == null)
     return null;
     if (root.data == first || root.data == sec)
     return root;
     BTNode l = findLCA(root.left, first, sec);
     BTNode r = findLCA(root.right, first, sec);
     if (l != null && r != null)
     return root;
     return l != null ? l : r;
     }*/
}