package com.practice.ds.linkedList;

/**
 * Linked list implementation with head and tail
 * Tail helps in doing insertion in O(1)
 * Created by Karshit Kumar on 02/07/17.
 */
public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public void append(T element) {
        Node<T> elem = new Node<T>(element);

        if (null == head) {
            head = elem;
            tail = elem;
        } else {
            tail.setNext(elem);
            tail = elem;
        }
    }

    public void push(T element) {
        Node<T> elem = new Node<T>(element);

        if (null == head) {
            append(element);
        } else {
            elem.setNext(head);
            head = elem;
        }
    }

    public void insertAfter(Node<T> prev, T element) {
        Node<T> elem = new Node<T>(element);

        if (null == head || null == prev || prev.equals(tail)) {
            append(element);
        } else {
            elem.setNext(prev.getNext());
            prev.setNext(elem);
        }
    }

    public void print() {
        Node<T> temp = head;

        while (null != temp) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void deleteNode(T key) {
        if (null == head) {
            System.out.println("Linked list is empty");
            return;
        }

        if (head.getData().equals(key)) {
            head = head.getNext();
            deleteNode(key);
        }

        Node<T> temp = head;

        while (null != temp && null != temp.getNext()) {
            if (temp.getNext().getData().equals(key)) {
                Node<T> nodeToBeDeleted = temp.getNext();
                temp.setNext(nodeToBeDeleted.getNext());

                if (nodeToBeDeleted.equals(tail)) {
                    tail = temp;
                }
                nodeToBeDeleted.setNext(null);
            }

            temp = temp.getNext();
        }

    }

    public void deleteNodeByPosition(int position) {
        if (position == 0 && head != null) {
            head = head.getNext();
            return;
        } else if (position == 0 || null == head) {
            System.out.println("Linked list is empty");
            return;
        }

        Node<T> temp = head;
        int count = 0;

        while (temp != null && temp.getNext() != null) {
            if (count == position - 1) {
                if (tail.equals(temp.getNext())) {
                    tail = temp;
                    tail.setNext(null);
                    return;
                }

                Node<T> nodeToBeDeleted = temp.getNext();
                temp.setNext(nodeToBeDeleted.getNext());
                nodeToBeDeleted.setNext(null);
            }

            count++;
            temp = temp.getNext();
        }
    }

    public int size() {
        int length = 0;
        Node<T> temp = head;

        while (temp != null) {
            length++;
            temp = temp.getNext();
        }

        return length;
    }

    public int sizeRecursive(Node<T> temp) {
        if (temp == null) {
            return 0;
        } else {
            return 1 + sizeRecursive(temp.getNext());
        }
    }

    public boolean find(T element) {
        if (null == head) {
            return false;
        }

        Node<T> temp = head;

        while (temp != null) {
            if (temp.getData().equals(element)) {
                return true;
            }

            temp = temp.getNext();
        }

        return false;
    }

    public boolean findRecursive(Node<T> temp, T element) {

        if (temp == null) {
            return false;
        }

        return (temp.getData().equals(element))
                || findRecursive(temp.getNext(), element);
    }

    public void swap(T x, T y) {
        if (x.equals(y)) {
            return;
        }

        Node<T> prevX = null, currX = head;
        Node<T> prevY = null, currY = head;

        while (currX != null && !currX.getData().equals(x)) {
            prevX = currX;
            currX = currX.getNext();
        }

        while (currY != null && (!currY.getData().equals(y))) {
            prevY = currY;
            currY = currY.getNext();
        }

        if (currX == null || currY == null) {
            System.out.println("Element not present");
            return;
        }

        if (tail.equals(currX)) {
            tail = currY;
        } else if (tail.equals(currY)) {
            tail = currX;
        }

        if (prevX != null) {
            prevX.setNext(currY);
        } else {
            head = currY;
        }

        if (prevY != null) {
            prevY.setNext(currX);
        } else {
            head = currX;
        }

        Node<T> temp = currX.getNext();
        currX.setNext(currY.getNext());
        currY.setNext(temp);
    }

    public T get(int position) {
        if (null == head || position < 1) {
            return null;
        }

        position--;
        int count = 0;
        Node<T> temp = head;

        while (count < position && temp != null) {
            count++;
            temp = temp.getNext();
        }

        if (temp != null) {
            return temp.getData();
        } else {
            return null;
        }
    }

    public T getMiddle() {
        if (null == head) {
            return null;
        }

        int length = size();
        int mid = Math.floorDiv(length, 2);
        Node<T> temp = head;

        for (int i = 0; i < mid && temp != null; i++) {
            temp = temp.getNext();
        }

        if (temp != null) {
            return temp.getData();
        } else {
            return null;
        }
    }

    public T getNthNodeFromEnd(int n) {
        if (n < 1 || head == null) {
            return null;
        }

        Node<T> temp1 = head, temp2 = head;

        for (int i = 1; i < n && temp1 != null; i++) {
            temp1 = temp1.getNext();
        }

        if (temp1 == null) {
            return null;
        }

        while (temp1.getNext() != null) {
            temp1 = temp1.getNext();
            temp2 = temp2.getNext();
        }

        return temp2.getData();
    }

    public void delete() {
        head = null;
        tail = null;
    }

    public int count(T key) {
        Node<T> temp = head;
        int count = 0;

        while (temp != null) {
            if (temp.getData().equals(key)) {
                count++;
            }

            temp = temp.getNext();
        }

        return count;
    }

}
