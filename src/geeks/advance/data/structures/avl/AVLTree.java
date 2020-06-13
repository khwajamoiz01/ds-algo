/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.advance.data.structures.avl;

/**
 * @author khwaja.ali
 * @version $Id: AVLTree.java, v 0.1 2020-04-23 12:11 am khwaja.ali Exp 3
 */
//Not tested
public class AVLTree {

    private int height(Node n) {
        return n != null ? n.height : 0;
    }

    private int getDiff(Node n) {
        return n != null ? height(n.left) - height(n.right) : 0;
    }

    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;
        x.right = y;
        y.left = t2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        x.right = t2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    private int minData(Node right) {
        Node cur = right;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.data;
    }

    Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        } else if (key < node.data) {
            node.left = insert(node.left, key);
        } else {
            node.count++;
            return node;
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int diff = getDiff(node);
        //left left -> RR(z)
        if (diff > 1 && key < node.left.data) {
            return rightRotate(node);
        }

        //right right -> LR(z)
        if (diff < -1 && key > node.right.data) {
            return leftRotate(node);
        }

        //left right ->  LR(y) and RR(z)
        if (diff > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //right left -> RR(y) and LR(z)
        if (diff < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    Node delete(Node root, int key) {
        if (root == null) {
            return null;
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else if (key < root.data) {
            root.left = delete(root.left, key);
        } else {
            //in case only one child is present then in gfg it is not returned directly, but i think its fine to return
            if (root.count > 1) {
                root.count--;
                return root;//geeks solution returns null which is incorrect
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.data = minData(root.right);
                root.right = delete(root.right, root.data);
            }
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        int diff = getDiff(root);

        if (diff > 1 && getDiff(root.left) >= 0) {
            return rightRotate(root);
        }
        if (diff > 1 && getDiff(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (diff < -1 && getDiff(root.right) <= 0) {
            return leftRotate(root);
        }
        if (diff < -1 && getDiff(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

}