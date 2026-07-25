package com.debu.DataStructure.HashTable;

import java.util.HashMap;
import java.util.HashSet;

public class EqualNoOfOccurances {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> elementsMap = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            elementsMap.put(ch, elementsMap.getOrDefault(ch, 0)+1);
        }

        HashSet<Integer> elementSet = new HashSet<Integer>();
        for(char ch: elementsMap.keySet())
        {
            elementSet.add(elementsMap.get(ch));
        }
        return elementSet.size() == 1;

    }
}
