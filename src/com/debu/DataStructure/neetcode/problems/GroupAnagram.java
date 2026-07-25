package com.debu.DataStructure.neetcode.problems;

import java.util.*;

//time complexity: O(n * k log k)
//space complexity: O(n * k)


public class GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] str)
    {
        Map<String,List<String>> elementsMap = new HashMap<>();
        for(String s:str)
        {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            elementsMap.putIfAbsent(key, new ArrayList<>());
            elementsMap.get(key).add(s);

        }
        return new ArrayList<>(elementsMap.values());
    }

    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
    }
}
