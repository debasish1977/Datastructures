package com.debu.DataStructure.leetcode.Examples;

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int ans = 1;
        int fp = 0;
        int sp = 0;
        HashMap<Character,Integer> elementsMap = new HashMap<Character,Integer>();
        int n = s.length();
        while(sp < n)
        {
            addToMap(elementsMap,s.charAt(sp));
            while(fp < sp && !isValid(elementsMap))
            {
                deleteFromMap(elementsMap,s.charAt(fp));
                fp++;
            }
            int length = sp - fp + 1;
            ans = Math.min(ans,length);
            sp++;
        }
        return ans;
    }

    static void addToMap(HashMap<Character,Integer> map,char c)
    {
        map.put(c,map.getOrDefault(c,0)+1);
    }

    static void deleteFromMap(HashMap<Character,Integer> map, char c)
    {
        map.put(c,map.get(c)-1);
    }

    static boolean isValid(HashMap<Character,Integer> elementsMap)
    {
        for(char c:elementsMap.keySet())
        {
            if(elementsMap.get(c) > 1)
            {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args)
    {
        String s = "abcabcbb";
        System.out.println("Length of Longest Substring: " + lengthOfLongestSubstring(s));
    }
}
