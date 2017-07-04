package com.practice.ds.linkedList;

/**
 * Data structure for node
 * Created by Karshit Kumar on 02/07/17.
 */
public class Node<T> implements Comparable<T> {

    private T data;
    private Node<T> next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public int compareTo(T o) {
        if ((o instanceof String && o.equals(this.data)) || o == this.data) {
            return 0;
        } else {
            return 1;
        }
    }
}