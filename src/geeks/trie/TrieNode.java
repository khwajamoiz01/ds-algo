/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.trie;

import java.util.List;

/**
 * @author khwaja.ali
 * @version $Id: TrieNode.java, v 0.1 2020-04-11 7:32 pm khwaja.ali Exp 3
 */
public class TrieNode {
    static final int ALPHABETS = 256;

    TrieNode[] children;
    boolean isLeaf;

    public TrieNode() {
        children = new TrieNode[ALPHABETS];
    }

}