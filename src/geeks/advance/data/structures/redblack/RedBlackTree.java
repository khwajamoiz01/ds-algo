/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package geeks.advance.data.structures.redblack;

/**
 * @author khwaja.ali
 * @version $Id: redblack.java, v 0.1 2020-04-27 7:18 pm khwaja.ali Exp 3
 */
//https://www.youtube.com/watch?v=UaLIHuR1t8Q&t=2056s
public class RedBlackTree {
    /*
    Insertion pseudo code -

    If tree is empty
        create a black root node
    else
        Insert a new red leaf node as bst insertion
        If parent is red
            If parent's sibling is red
                make parent and its sibling as black
                if grand father is not root
                    make grand father as red
                    recursively check for grand father
            Else if parent's sibling is black or empty
                rotate and recolour


     */
}