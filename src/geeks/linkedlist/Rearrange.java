package geeks.linkedlist;

//https://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/
//verify merging with geeks
public class Rearrange {

    Node reorderlist(Node head) {
        if (head == null || head.next == null)
            return head;
        Node mid = mid(head);
        Node first = head;
        Node sec = mid.next;
        mid.next = null;
        sec = reverse(sec);
        return merge(first, sec);
    }

    Node merge(Node first, Node sec) {
        Node fc = first;
        Node sc = sec;
        while (sc != null) {
            Node fn = fc.next;
            Node sn = sc.next;
            fc.next = sc;
            fc.next.next = fn;
            sc = sn;
            fc = fn;
        }
        return first;
    }

    Node reverse(Node node) {
        if (node == null)
            return null;
        Node cur = node;
        Node prev = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    //75 122 59 196 30 38 36 194
    Node mid(Node head) {
        Node x = head;
        Node xx = head.next;
        while (xx != null && xx.next != null) {
            x = x.next;
            xx = xx.next.next;
        }
        return x;
    }

}
