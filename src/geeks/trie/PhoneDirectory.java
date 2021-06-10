package geeks.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://www.geeksforgeeks.org/implement-a-phone-directory/
//Below codes is accepted on practice but refer and verify from geeks
public class PhoneDirectory {

    static TrieNode buildTrie(String[] ar) {
        TrieNode head = new TrieNode();
        for (int i = 0; i < ar.length; i++) {
            TrieNode cur = head;
            for (int j = 0; j < ar[i].length(); j++) {
                if (cur.children[ar[i].charAt(j)] == null)
                    cur.children[ar[i].charAt(j)] = new TrieNode();
                cur = cur.children[ar[i].charAt(j)];
            }
            cur.isLeaf = true;
        }
        return head;
    }

    static List<String> buildResult(TrieNode head, String q) {
        String prefix = "";
        TrieNode cur = head;
        for (int i = 0; i < q.length(); i++) {
            TrieNode child = cur.children[q.charAt(i)];
            if (child == null)
                return null;
            prefix += q.charAt(i);
            cur = child;
        }
        List<String> res = new ArrayList<>();
        preorder(cur, res, prefix);
        return res;
    }

    static void preorder(TrieNode cur, List<String> res, String prefix) {
        if (cur == null)
            return;

        if (cur.isLeaf) {
            res.add(prefix);
        }
        for (int i = 0; i < 256; i++) {
            preorder(cur.children[i], res, prefix + (char) i);
        }

    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                String[] ar = new String[n];
                for (int i = 0; i < n; i++) {
                    ar[i] = sc.next();
                }
                String q = sc.next();
                TrieNode head = buildTrie(ar);
                for (int i = 0; i < q.length(); i++) {
                    List<String> result = buildResult(head, q.substring(0, i + 1));
                    if (result == null)
                        System.out.print(0);
                    else {
                        for (String s : result) {
                            System.out.print(s + " ");
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

}
