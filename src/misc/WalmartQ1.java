package misc;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/*
               a
            /      \
           b        c
         /  \      /  \
        d    e     f    g
       / \  / \   / \  / \
       h  i j  k l  m n  o

 */
public class WalmartQ1 {

    static class BTNode {
        public BTNode left;
        public BTNode right;
        public char data;

        public BTNode(char data) {
            this.data = data;
        }

        BTNode(BTNode left, BTNode right) {
            this.left = left;
            this.right = right;
        }

        public void setLeft(BTNode left) {
            this.left = left;
        }

        public void setRight(BTNode right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }

    public static void main(String[] args) {
        BTNode a = new BTNode('a');

        BTNode b = new BTNode('b');
        BTNode c = new BTNode('c');

        BTNode d = new BTNode('d');
        BTNode e = new BTNode('e');
        BTNode f = new BTNode('f');
        BTNode g = new BTNode('g');

        BTNode h = new BTNode('h');
        BTNode i = new BTNode('i');
        BTNode j = new BTNode('j');
        BTNode k = new BTNode('k');
        BTNode l = new BTNode('l');
        BTNode m = new BTNode('m');
        BTNode n = new BTNode('n');
        BTNode o = new BTNode('o');

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        d.left = h;
        d.right = i;
        e.left = j;
        e.right = k;
        f.left = l;
        f.right = m;
        g.left = n;
        g.right = o;
        print(a);
        reverseAlternateLevels(a);
        print(a);
    }

    private static void print(BTNode root) {
        if (root == null)
            return;
        Queue<BTNode> ql = new ArrayDeque<>();
        ql.offer(root);
        while (!ql.isEmpty()) {//or qr is not empty
            int s = ql.size();//4
            while (s-- > 0) {
                BTNode node1 = ql.poll();
                System.out.print(node1.data + " ");
                if (node1.left != null)
                    ql.offer(node1.left);
                if (node1.right != null)
                    ql.offer(node1.right);

            }
            System.out.println();
        }
    }

    private static void reverseAlternateLevels(BTNode root) {
        if (root == null)
            return;
        Queue<BTNode> ql = new ArrayDeque<>();
        ql.offer(root);
        Queue<BTNode> qr = new ArrayDeque<>();
        qr.offer(root);
        int level = 0;
        while (!ql.isEmpty()) {//or qr is not empty
            int s = ql.size();//1
            int levelCount = ql.size();//1
            while (s-- > 0) {
                BTNode node1 = ql.poll();
                if (node1.left != null)
                    ql.offer(node1.left);
                if (node1.right != null)
                    ql.offer(node1.right);

                BTNode node2 = qr.poll();
                if (node2.right != null)
                    qr.offer(node2.right);
                if (node2.left != null)
                    qr.offer(node2.left);

                if (level == 0) {
                    swap(node1.left, node2.right);
                } else if ((s >= levelCount / 2 && level % 2 == 0)) {
                    swap(node1.left, node2.right);
                    swap(node1.right, node2.left);
                }
            }
            level++;
        }
    }

    private static void swap(BTNode left, BTNode right) {
        //ignoring null for now
        char temp = left.data;
        left.data = right.data;
        right.data = temp;
    }
}
