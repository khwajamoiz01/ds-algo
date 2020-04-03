/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package geeks.heap;

/**
 * @author khwaja.ali
 * @version $Id: Heap.java, v 0.1 2019-12-15 19:38 khwaja.ali Exp 3
 */
public interface IMinHeap<T extends Comparable> {

    T getMin();

    T removeMin();

    void insert(T k);

    void decreaseKey(int i, T val);

    void deleteKey(int i);

    boolean isEmpty();
}