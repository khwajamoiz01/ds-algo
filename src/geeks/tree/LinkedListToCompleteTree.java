package geeks.tree;

import geeks.linkedlist.Node;

import java.util.ArrayDeque;
import java.util.Queue;

//https://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
public class LinkedListToCompleteTree {
    public static BTNode convert(Node head, BTNode tree) {
        if (head == null)
            return null;
        tree = new BTNode(head.data);
        Queue<BTNode> q = new ArrayDeque<>();
        q.offer(tree);
        Node cur = head.next;
        while (cur != null) {
            BTNode t = q.poll();
            t.left = new BTNode(cur.data);
            q.offer(t.left);
            cur = cur.next;
            if (cur == null)
                break;
            t.right = new BTNode(cur.data);
            q.offer(t.right);
            cur = cur.next;
        }
        return tree;
    }
}

