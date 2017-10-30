package com.liu.programminglearning.datastructure.linkedlist.doubly;

/**
 * Created by kunmingliu on 2017/10/30.
 */

public class Node {
    public int key;
    public int value;
    public Node prev;
    public Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}
