package com.practice.ds;

import com.practice.ds.linkedList.LinkedList;

/**
 * Main class
 * Created by Karshit Kumar on 02/07/17.
 */
public class Application {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.append(1112213);
        list.append(1112213);
        list.append(11112213);
        list.append(1112213);
        list.append(100000);

        System.out.println(list.count(1112213));
    }
}
