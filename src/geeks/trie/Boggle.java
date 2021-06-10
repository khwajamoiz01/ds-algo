/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.trie;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author khwaja.ali
 * @version $Id: Boggle.java, v 0.1 2020-04-11 6:58 pm khwaja.ali Exp 3
 */
//verify trie sol with geeks
//https://www.geeksforgeeks.org/boggle-set-2-using-trie/
//https://www.geeksforgeeks.org/boggle-find-possible-words-board-characters/
public class Boggle {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int w = sc.nextInt();
                Set<String> words = inputDict(sc, w);
                int n = sc.nextInt();
                int m = sc.nextInt();
                char[][] boggle = inputBoggle(sc, n, m);

                Set<String> res = new TreeSet<>();
                boolean[][] vis = new boolean[n][m];
                //searchDFS(words, n, m, boggle, res, vis);////approach1
                searchTrie(n, m, boggle, words, vis, res);
                printOutput(res);
            }
        }
    }

    static int[][] directions = {{-1, +1}, {-1, 0}, {-1, +1}, {0, +1}, {+1, +1}, {+1, 0}, {+1, -1}, {0, -1}};

    private static boolean isSafe(int n, int m, int u, int v) {
        return u >= 0 && u < n && v >= 0 && v < m;
    }

    static void searchTrie(int n, int m, char[][] boggle, Set<String> words, boolean[][] vis, Set<String> res) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                searchTrieUtil(trie.root.children[boggle[i][j]], i, j, n, m, boggle, "", vis, res);
            }
        }
    }

    private static void searchTrieUtil(TrieNode node, int i, int j, int n, int m, char[][] boggle, String word,
                                       boolean[][] vis, Set<String> res) {
        if (node == null) {
            return;
        }
        word += boggle[i][j];
        vis[i][j] = true;
        if (node.isLeaf) {
            res.add(word);
        }
        for (int[] dir : directions) {
            int u = i + dir[0];
            int v = j + dir[1];
            if (isSafe(n, m, u, v) && !vis[u][v]) {
                searchTrieUtil(node.children[boggle[u][v]], u, v, n, m, boggle, word, vis, res);
            }
        }
        vis[i][j] = false;
    }

    private static void searchDFS(Set<String> words, int n, int m, char[][] boggle, Set<String> res, boolean[][] vis) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                searchDFSUtil(i, j, n, m, boggle, words, "", vis, res);
            }
        }
    }


    static void searchDFSUtil(int i, int j, int n, int m, char[][] ar,
                              Set<String> words, String word, boolean[][] vis, Set<String> res) {

        word += ar[i][j];
        vis[i][j] = true;
        if (words.contains(word)) {
            res.add(word);
        }

        for (int[] dir : directions) {
            int u = i + dir[0];
            int v = j + dir[1];
            if (u >= 0 && u < n && v >= 0 && v < m && !vis[u][v]) {
                searchDFSUtil(u, v, n, m, ar, words, word, vis, res);
            }
        }
        vis[i][j] = false;
    }


    private static void printOutput(Set<String> res) {
        if (res.isEmpty()) {
            System.out.println(-1);
        } else {
            for (String s : res) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static Set<String> inputDict(Scanner sc, int w) {
        Set<String> words = new HashSet<>();
        for (int i = 0; i < w; i++) {
            words.add(sc.next());
        }
        return words;
    }

    private static char[][] inputBoggle(Scanner sc, int n, int m) {
        char[][] ar = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ar[i][j] = sc.next().charAt(0);
            }
        }
        return ar;
    }

}