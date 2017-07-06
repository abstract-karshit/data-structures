package com.practice.ds;

import com.practice.ds.linkedList.LinkedList;

/**
 * Main class
 * Created by Karshit Kumar on 02/07/17.
 */
public class Application {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.append(1);
        list.append(3);
        list.append(3);
        list.append(5);
        list.print();
        list.sortedInsert(8);
        list.print();
    }
}
