package com.debu.DataStructure.leetcode.ArrayExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs)
    {
        HashMap<String,List<String>> elementsMap = new HashMap<String,List<String>>();
        for(String str: strs)
        {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            elementsMap.putIfAbsent(key,new ArrayList<>());
            elementsMap.get(key).add(str);
        }
        return new ArrayList<>(elementsMap.values());
    }

    public static void main(String[] args) {
        String[] words = {"act","pots","tops","cat","stop","hat"};
        System.out.println("Grouped Anagrams: " + groupAnagrams(words));
    }

}
