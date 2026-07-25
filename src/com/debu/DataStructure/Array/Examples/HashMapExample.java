package com.debu.DataStructure.Array.Examples;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args)
    {
        HashMap<Integer,Integer> elementsMap = new HashMap<Integer,Integer>();
        elementsMap.put(1,2);
        elementsMap.put(3,4);
        elementsMap.put(5,6);
        System.out.println("Elements in map:"+elementsMap.get(3));
    }
}
