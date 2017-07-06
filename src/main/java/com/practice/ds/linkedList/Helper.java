package com.practice.ds.linkedList;

/**
 * Created by Karshit Kumar on 07/07/17.
 */
public final class Helper {

    public static <T> LinkedList<T> sortedMerge(LinkedList<T> first, LinkedList<T> second) {
        LinkedList<T> list = new LinkedList<T>();

        if (first == null) {
            return second;
        } else if (second == null) {
            return first;
        }

        Node<T> iter1 = first.getHead();
        Node<T> iter2 = second.getHead();

        while (iter1 != null && iter2 != null) {
            if (((Comparable) iter2.getData()).compareTo(iter1.getData()) > 0) {
                list.append(iter1.getData());
                iter1 = iter1.getNext();
            } else {
                list.append(iter2.getData());
                iter2 = iter2.getNext();
            }
        }

        if (iter1 != null) {
            list.getTail().setNext(iter1);
            list.setTail(first.getTail());
        } else if (iter2 != null) {
            list.getTail().setNext(iter2);
            list.setTail(first.getTail());
        }

        return list;
    }
}
