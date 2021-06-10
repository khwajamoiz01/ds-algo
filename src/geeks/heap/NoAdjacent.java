package geeks.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class NoAdjacent {

    static class Node implements Comparable<Node> {
        char ch;
        int freq;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        public int compareTo(Node node) {
            return node.freq - this.freq;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                int[] freq = new int[26];
                for (int i = 0; i < s.length(); i++) {
                    freq[s.charAt(i) - 'a']++;
                }
                PriorityQueue<Node> pq = new PriorityQueue<>();
                for (int i = 0; i < 26; i++) {
                    if (freq[i] > 0) {
                        pq.add(new Node((char) ('a' + i), freq[i]));
                    }
                }
                Node prev = null;
                while (!pq.isEmpty()) {
                    Node node = pq.poll();
                    //append to result
                    node.freq--;

                    if (prev != null && prev.freq > 0)
                        pq.offer(prev);
                    prev = node;
                }
                System.out.println(prev.freq == 0 ? 1 : 0);
            }
        }
    }

}
