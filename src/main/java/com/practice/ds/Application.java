package com.practice.ds;

import com.practice.ds.linkedList.Helper;
import com.practice.ds.linkedList.LinkedList;

/**
 * Main class
 * Created by Karshit Kumar on 02/07/17.
 */
public class Application {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();

        list1.append(1);
        list1.append(3);
        list1.append(3);
        list1.append(5);

        list2.append(2);
        list2.append(2);
        list2.append(4);
        list2.append(6);

        LinkedList<Integer> list = Helper.sortedMerge(list1, list2);
        list.print();
    }
}
