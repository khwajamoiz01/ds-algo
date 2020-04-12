/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.trie;

/**
 * @author khwaja.ali
 * @version $Id: Trie.java, v 0.1 2020-04-11 7:34 pm khwaja.ali Exp 3
 */
public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    void insert(String key) {
        TrieNode cur = root;
        for (char ch : key.toCharArray()) {
            int index = ch;
            if (cur.children[index] == null)
                cur.children[index] = new TrieNode();
            cur = cur.children[index];
        }
        cur.isLeaf = true;
    }
}