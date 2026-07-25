package com.debu.DataStructure.leetcode.Examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Group_Anagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> elementsMap = new HashMap<>();
        for(String str: strs)
        {
            char[] a = str.toCharArray();
            Arrays.sort(a);
            String key = new String(a);
            elementsMap.computeIfAbsent(key,k -> new ArrayList<>()).add(str);

        }
        return new ArrayList<>(elementsMap.values());
    }

    public static void main(String[] args)
    {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("Group Anagrams: " + groupAnagrams(strs));
    }
}
