package misc;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class WalmartQ2 {
    public static void main(String[] args) {
        String input = "aaaabc";
        process(input, input.length());
    }

    static class Element implements Comparable<Element> {
        char ch;
        int freq;

        Element(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        @Override
        public int compareTo(Element o) {
            return this.freq - o.freq;
        }
    }

    private static void process(String input, int length) {
        if (input == null)
            return;
        Queue<Element> q = new PriorityQueue<>(Comparator.reverseOrder());
        int[] freq = new int[256];
        for (char ch : input.toCharArray()) {
            freq[ch]++;
        }
        for (int i = 0; i < 256; i++) {
            if (freq[i] == 0)
                continue;
            q.offer(new Element((char) i, freq[i]));
        }
        char ignore = '$';
        while (!q.isEmpty()) {

            Element e = q.poll();
            if (e.ch == ignore) {
                if (q.isEmpty()) {
                    System.out.println("NP");
                    return;
                }
                Element next = q.poll();
                q.offer(e);
                e = next;
            }
            if (e.ch != ignore) {
                System.out.print(e.ch);
                e.freq--;
                if (e.freq != 0)
                    q.offer(e);
                ignore = e.ch;
            }
        }
    }
}
