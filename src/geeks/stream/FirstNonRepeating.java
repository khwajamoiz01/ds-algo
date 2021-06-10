package geeks.stream;

import geeks.linkedlist.DLLNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/
//https://practice.geeksforgeeks.org/problems/first-non-repeating-character-in-a-stream1216/1
//below seems correct and consistent with geeks c++ sol but not getting submitted on practice.
public class FirstNonRepeating {

    static class Node {
        char data;
        Node next, prev;

        Node(char data) {
            this.data = data;
        }
    }

    public String firstNonRepeating(String A) {
        if (A == null)
            return "#";
        char[] ar = A.toCharArray();
        int[] freq = new int[256];
        Map<Character, Node> map = new HashMap<>();
        Node head = null, tail = null;
        StringBuilder result = new StringBuilder();
        for (char c : ar) {
            int f = freq[c];
            if (f == 0) {
                Node node = new Node(c);
                if (head == null) {
                    head = node;
                    tail = node;
                } else {
                    tail.next = node;
                    node.prev = tail;
                    tail = node;
                }
                map.put(c, node);
            } else if (f == 1) {
                Node node = map.remove(c);
                if (node == head)
                    head = head.next;
                else if (node == tail)
                    tail = tail.prev;

                if (node.next != null)
                    node.next.prev = node.prev;
                if (node.prev != null)
                    node.prev.next = node.next;

                node.next = null;
                node.prev = null;
            }
            freq[c]++;

            result.append(head == null ? "#" : head.data);
        }
        return result.toString();
    }
}
